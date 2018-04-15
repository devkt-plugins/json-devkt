package com.intellij.devkt.json;

import org.ice1000.devkt.openapi.AnnotationHolder;
import org.ice1000.devkt.openapi.ColorScheme;
import org.ice1000.devkt.openapi.ExtendedDevKtLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.psi.PsiElement;
import org.jetbrains.kotlin.com.intellij.psi.PsiErrorElement;
import org.jetbrains.kotlin.com.intellij.psi.tree.IElementType;

public class Json<T> extends ExtendedDevKtLanguage<T> {
	@NotNull
	@Override
	public String getLineCommentStart() {
		return "//";
	}

	public Json() {
		super(JsonLanguage.INSTANCE, new JsonParserDefinition());
	}

	@Override
	public boolean satisfies(String fileName) {
		return fileName.endsWith(".json") || fileName.equals(".pinpoint");
	}

	@Override
	public void annotate(PsiElement psiElement, AnnotationHolder<? super T> annotationHolder, ColorScheme<? extends T> colorScheme) {
		if (psiElement instanceof PsiErrorElement) annotationHolder.highlight(psiElement, colorScheme.getUnknown());
	}

	@Nullable
	@Override
	public T attributesOf(IElementType iElementType, ColorScheme<? extends T> colorScheme) {
		if (iElementType == JsonElementTypes.LINE_COMMENT) return colorScheme.getLineComments();
		else if (iElementType == JsonElementTypes.BLOCK_COMMENT) return colorScheme.getBlockComments();
		else if (iElementType == JsonElementTypes.NUMBER) return colorScheme.getNumbers();
		else if (iElementType == JsonElementTypes.SINGLE_QUOTED_STRING) return colorScheme.getString();
		else if (iElementType == JsonElementTypes.DOUBLE_QUOTED_STRING) return colorScheme.getProperty();
		else if (iElementType == JsonElementTypes.IDENTIFIER) return colorScheme.getIdentifiers();
		else if (JsonParserDefinition.JSON_BRACES.contains(iElementType)) return colorScheme.getBraces();
		else if (JsonParserDefinition.JSON_KEYWORDS.contains(iElementType)) return colorScheme.getKeywords();
		else if (JsonParserDefinition.JSON_BRACKETS.contains(iElementType)) return colorScheme.getBrackets();
		else return null;
	}
}
