// This is a generated file. Not intended for manual editing.
package com.intellij.devkt.json.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;
import com.intellij.devkt.json.psi.*;
import org.jetbrains.kotlin.com.intellij.navigation.ItemPresentation;

public class JsonObjectImpl extends JsonObjectMixin implements JsonObject {

  public JsonObjectImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JsonElementVisitor visitor) {
    visitor.visitObject(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JsonElementVisitor) accept((JsonElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<JsonProperty> getPropertyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JsonProperty.class);
  }

  @Nullable
  public ItemPresentation getPresentation() {
    return null;
  }

}
