package com.intellij.devkt.json.psi.impl;

import com.intellij.devkt.json.psi.JsonElementGenerator;
import com.intellij.devkt.json.psi.JsonProperty;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.kotlin.com.intellij.psi.PsiElement;
import org.jetbrains.kotlin.com.intellij.psi.PsiReference;
import org.jetbrains.kotlin.com.intellij.util.IncorrectOperationException;

/**
 * @author Mikhail Golubev
 */
abstract class JsonPropertyMixin extends JsonElementImpl implements JsonProperty {
	public JsonPropertyMixin(@NotNull ASTNode node) {
		super(node);
	}

	@Override
	public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
		final JsonElementGenerator generator = new JsonElementGenerator(getProject());
		// Strip only both quotes in case user wants some exotic name like key'
		getNameElement().replace(generator.createStringLiteral(StringUtil.unquoteString(name)));
		return this;
	}

	@Override
	public PsiReference getReference() {
		return new JsonPropertyNameReference(this);
	}

	@NotNull
	@Override
	public PsiReference[] getReferences() {
		return PsiReference.EMPTY_ARRAY;
	}
}
