// This is a generated file. Not intended for manual editing.
package com.intellij.devkt.json.psi.impl;

import com.intellij.devkt.json.psi.JsonArray;
import com.intellij.devkt.json.psi.JsonElementVisitor;
import com.intellij.devkt.json.psi.JsonValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.navigation.ItemPresentation;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;

import java.util.List;

public class JsonArrayImpl extends JsonContainerImpl implements JsonArray {

	public JsonArrayImpl(ASTNode node) {
		super(node);
	}

	public void accept(@NotNull JsonElementVisitor visitor) {
		visitor.visitArray(this);
	}

	public void accept(@NotNull PsiElementVisitor visitor) {
		if (visitor instanceof JsonElementVisitor) accept((JsonElementVisitor) visitor);
		else super.accept(visitor);
	}

	@Override
	@NotNull
	public List<JsonValue> getValueList() {
		return PsiTreeUtil.getChildrenOfTypeAsList(this, JsonValue.class);
	}

	@Nullable
	public ItemPresentation getPresentation() {
		return null;
	}

}
