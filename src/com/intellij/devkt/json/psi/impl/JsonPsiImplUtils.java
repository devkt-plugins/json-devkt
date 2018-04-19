package com.intellij.devkt.json.psi.impl;

import com.intellij.devkt.json.JsonParserDefinition;
import com.intellij.devkt.json.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.openapi.util.Key;
import org.jetbrains.kotlin.com.intellij.openapi.util.Pair;
import org.jetbrains.kotlin.com.intellij.openapi.util.TextRange;
import org.jetbrains.kotlin.com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.kotlin.com.intellij.psi.PsiElement;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonPsiImplUtils {
	private static final Key<List<Pair<TextRange, String>>> STRING_FRAGMENTS = new Key<>("JSON string fragments");

	@NotNull
	public static String getName(@NotNull JsonProperty property) {
		return StringUtil.unescapeStringCharacters(JsonPsiUtil.stripQuotes(property.getNameElement().getText()));
	}

	/**
	 * Actually only JSON string literal should be accepted as valid name of property according to standard,
	 * but for compatibility with JavaScript integration any JSON literals as well as identifiers (unquoted words)
	 * are possible and highlighted as error later.
	 */
	public static @NotNull
	JsonValue getNameElement(@NotNull JsonProperty property) {
		final PsiElement firstChild = property.getFirstChild();
		assert firstChild instanceof JsonLiteral || firstChild instanceof JsonReferenceExpression;
		return (JsonValue) firstChild;
	}

	public static @Nullable
	JsonValue getValue(@NotNull JsonProperty property) {
		return PsiTreeUtil.getNextSiblingOfType(getNameElement(property), JsonValue.class);
	}

	public static boolean isQuotedString(@NotNull JsonLiteral literal) {
		return literal.getNode().findChildByType(JsonParserDefinition.STRING_LITERALS) != null;
	}

	private static final String ourEscapesTable = "\"\"\\\\//b\bf\fn\nr\rt\t";

	private static boolean isHexDigit(char c) {
		return Character.isDigit(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
	}

	@NotNull
	public static List<Pair<TextRange, String>> getTextFragments(@NotNull JsonStringLiteral literal) {
		List<Pair<TextRange, String>> result = literal.getUserData(STRING_FRAGMENTS);
		if (result == null) {
			result = new ArrayList<>();
			final String text = literal.getText();
			final int length = text.length();
			int pos = 1, unescapedSequenceStart = 1;
			while (pos < length) {
				if (text.charAt(pos) == '\\') {
					if (unescapedSequenceStart != pos) {
						result.add(Pair.create(new TextRange(unescapedSequenceStart, pos),
								text.substring(unescapedSequenceStart, pos)));
					}
					if (pos == length - 1) {
						result.add(Pair.create(new TextRange(pos, pos + 1), "\\"));
						break;
					}
					final char next = text.charAt(pos + 1);
					switch (next) {
						case '"':
						case '\\':
						case '/':
						case 'b':
						case 'f':
						case 'n':
						case 'r':
						case 't':
							final int idx = ourEscapesTable.indexOf(next);
							result.add(Pair.create(new TextRange(pos, pos + 2), ourEscapesTable.substring(idx + 1, idx + 2)));
							pos += 2;
							break;
						case 'u':
							int i = pos + 2;
							for (; i < pos + 6; i++) {
								if (i == length || !isHexDigit(text.charAt(i))) {
									break;
								}
							}
							result.add(Pair.create(new TextRange(pos, i), text.substring(pos, i)));
							pos = i;
							break;
						default:
							result.add(Pair.create(new TextRange(pos, pos + 2), text.substring(pos, pos + 2)));
							pos += 2;
					}
					unescapedSequenceStart = pos;
				} else {
					pos++;
				}
			}
			final int contentEnd = text.charAt(0) == text.charAt(length - 1) ? length - 1 : length;
			if (unescapedSequenceStart < contentEnd) {
				result.add(Pair.create(new TextRange(unescapedSequenceStart, length),
						text.substring(unescapedSequenceStart, contentEnd)));
			}
			result = Collections.unmodifiableList(result);
			literal.putUserData(STRING_FRAGMENTS, result);
		}
		return result;
	}

	public static void delete(@NotNull JsonProperty property) {
		final ASTNode myNode = property.getNode();
		JsonPsiChangeUtils.removeCommaSeparatedFromList(myNode, myNode.getTreeParent());
	}

	@NotNull
	public static String getValue(@NotNull JsonStringLiteral literal) {
		return StringUtil.unescapeStringCharacters(JsonPsiUtil.stripQuotes(literal.getText()));
	}

	public static boolean getValue(@NotNull JsonBooleanLiteral literal) {
		return literal.textMatches("true");
	}

	public static double getValue(@NotNull JsonNumberLiteral literal) {
		return Double.parseDouble(literal.getText());
	}
}
