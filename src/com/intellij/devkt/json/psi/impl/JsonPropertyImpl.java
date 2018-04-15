// This is a generated file. Not intended for manual editing.
package com.intellij.devkt.json.psi.impl;

import com.intellij.devkt.json.psi.JsonElementVisitor;
import com.intellij.devkt.json.psi.JsonProperty;
import com.intellij.devkt.json.psi.JsonValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

public class JsonPropertyImpl extends JsonPropertyMixin implements JsonProperty {

	public JsonPropertyImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull JsonElementVisitor visitor) {
		visitor.visitProperty(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof JsonElementVisitor) accept((JsonElementVisitor) visitor);
		else super.accept(visitor);
	}

	@NotNull
	public String getName() {
		return JsonPsiImplUtils.getName(this);
	}

	@NotNull
	public JsonValue getNameElement() {
		return JsonPsiImplUtils.getNameElement(this);
	}

	@Nullable
	public JsonValue getValue() {
		return JsonPsiImplUtils.getValue(this);
	}
}
