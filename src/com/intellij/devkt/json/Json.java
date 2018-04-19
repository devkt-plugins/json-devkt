package com.intellij.devkt.json;

import org.ice1000.devkt.openapi.ColorScheme;
import org.ice1000.devkt.openapi.ExtendedDevKtLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.psi.StringEscapesTokenTypes;
import org.jetbrains.kotlin.com.intellij.psi.tree.IElementType;

import javax.swing.*;

public class Json<T> extends ExtendedDevKtLanguage<T> {
	@NotNull
	@Override
	public String getLineCommentStart() {
		return "//";
	}

	@Override
	public @NotNull
	Icon getIcon() {
		return JsonFileType.INSTANCE.getIcon();
	}

	public Json() {
		super(JsonLanguage.INSTANCE, new JsonParserDefinition());
	}

	@Override
	public boolean satisfies(String fileName) {
		return fileName.endsWith(".json") || fileName.equals(".pinpoint");
	}

	@Override
	public @Nullable
	T attributesOf(IElementType iElementType, ColorScheme<? extends T> colorScheme) {
		if (iElementType == JsonElementTypes.LINE_COMMENT) return colorScheme.getLineComments();
		else if (iElementType == JsonElementTypes.BLOCK_COMMENT) return colorScheme.getBlockComments();
		else if (iElementType == JsonElementTypes.NUMBER) return colorScheme.getNumbers();
		else if (iElementType == JsonElementTypes.SINGLE_QUOTED_STRING) return colorScheme.getString();
		else if (iElementType == JsonElementTypes.DOUBLE_QUOTED_STRING) return colorScheme.getProperty();
		else if (iElementType == StringEscapesTokenTypes.VALID_STRING_ESCAPE_TOKEN) return colorScheme.getStringEscape();
		else if (iElementType == JsonElementTypes.IDENTIFIER) return colorScheme.getIdentifiers();
		else if (iElementType == JsonElementTypes.COLON) return colorScheme.getColon();
		else if (iElementType == JsonElementTypes.COMMA) return colorScheme.getComma();
		else if (JsonParserDefinition.JSON_BRACES.contains(iElementType)) return colorScheme.getBraces();
		else if (JsonParserDefinition.JSON_KEYWORDS.contains(iElementType)) return colorScheme.getKeywords();
		else if (JsonParserDefinition.JSON_BRACKETS.contains(iElementType)) return colorScheme.getBrackets();
		else return super.attributesOf(iElementType, colorScheme);
	}
}
