package com.intellij.devkt.json;

import com.intellij.devkt.json.psi.JsonProperty;
import kotlin.Pair;
import org.ice1000.devkt.ASTToken;
import org.ice1000.devkt.openapi.ColorScheme;
import org.ice1000.devkt.openapi.ExtendedDevKtLanguage;
import org.ice1000.devkt.openapi.util.CompletionElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.lexer.LayeredLexer;
import org.jetbrains.kotlin.com.intellij.lexer.Lexer;
import org.jetbrains.kotlin.com.intellij.lexer.StringLiteralLexer;
import org.jetbrains.kotlin.com.intellij.openapi.project.Project;
import org.jetbrains.kotlin.com.intellij.psi.PsiElement;
import org.jetbrains.kotlin.com.intellij.psi.StringEscapesTokenTypes;
import org.jetbrains.kotlin.com.intellij.psi.tree.IElementType;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Json<T> extends ExtendedDevKtLanguage<T> {

	private final Pair<String, String> stringPair = new Pair<>("/*", "*/");
	private final HashSet<CompletionElement> completionElements = new HashSet<>(Arrays.asList(new CompletionElement("null"),
			new CompletionElement("true"),
			new CompletionElement("false")));

	@NotNull
	@Override
	public String getLineCommentStart() {
		return "//";
	}

	@Override
	public @NotNull Pair<String, String> getBlockComment() {
		return stringPair;
	}

	@Override
	public boolean invokeAutoPopup(@NotNull ASTToken currentElement, @NotNull String inputString) {
		return inputString.length() == 1 && invokeAutoPopup(inputString.charAt(0));
	}

	private boolean invokeAutoPopup(char c) {
		return Character.isAlphabetic(c) || c == '"' || c == ' ' || c == ':';
	}

	@Override
	public boolean shouldAddAsCompletion(@NotNull PsiElement element) {
		return element instanceof JsonProperty;
	}

	@Override
	public @NotNull Set<CompletionElement> getInitialCompletionElementList() {
		return completionElements;
	}

	@Override
	public @NotNull Icon getIcon() {
		return JsonFileType.INSTANCE.getIcon();
	}

	public Json() {
		super(JsonLanguage.INSTANCE, new JsonParserDefinition());
	}

	@Override
	public boolean satisfies(@NotNull String fileName) {
		return fileName.endsWith(".json") || fileName.equals(".pinpoint");
	}

	public @NotNull Lexer createLexer(@NotNull Project project) {
		LayeredLexer layeredLexer = new LayeredLexer(new JsonLexer());
		layeredLexer.registerSelfStoppingLayer(new StringLiteralLexer('\"',
				JsonElementTypes.DOUBLE_QUOTED_STRING,
				false,
				"/",
				false,
				false), new IElementType[]{JsonElementTypes.DOUBLE_QUOTED_STRING}, IElementType.EMPTY_ARRAY);
		layeredLexer.registerSelfStoppingLayer(new StringLiteralLexer('\'',
				JsonElementTypes.SINGLE_QUOTED_STRING,
				false,
				"/",
				false,
				false), new IElementType[]{JsonElementTypes.SINGLE_QUOTED_STRING}, IElementType.EMPTY_ARRAY);
		return layeredLexer;
	}

	@Override
	public @Nullable T attributesOf(@NotNull IElementType iElementType, @NotNull ColorScheme<? extends T> colorScheme) {
		if (iElementType == JsonElementTypes.LINE_COMMENT) return colorScheme.getLineComments();
		else if (iElementType == JsonElementTypes.BLOCK_COMMENT) return colorScheme.getBlockComments();
		else if (iElementType == JsonElementTypes.NUMBER) return colorScheme.getNumbers();
		else if (iElementType == JsonElementTypes.SINGLE_QUOTED_STRING) return colorScheme.getString();
		else if (iElementType == JsonElementTypes.DOUBLE_QUOTED_STRING) return colorScheme.getProperty();
		else if (iElementType == StringEscapesTokenTypes.VALID_STRING_ESCAPE_TOKEN) return colorScheme.getStringEscape();
		else if (iElementType == StringEscapesTokenTypes.INVALID_UNICODE_ESCAPE_TOKEN) return colorScheme.getUnknown();
		else if (iElementType == StringEscapesTokenTypes.INVALID_CHARACTER_ESCAPE_TOKEN) return colorScheme.getUnknown();
		else if (iElementType == JsonElementTypes.IDENTIFIER) return colorScheme.getIdentifiers();
		else if (iElementType == JsonElementTypes.COLON) return colorScheme.getColon();
		else if (iElementType == JsonElementTypes.COMMA) return colorScheme.getComma();
		else if (JsonParserDefinition.JSON_BRACES.contains(iElementType)) return colorScheme.getBraces();
		else if (JsonParserDefinition.JSON_KEYWORDS.contains(iElementType)) return colorScheme.getKeywords();
		else if (JsonParserDefinition.JSON_BRACKETS.contains(iElementType)) return colorScheme.getBrackets();
		else return super.attributesOf(iElementType, colorScheme);
	}
}
