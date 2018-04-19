// This is a generated file. Not intended for manual editing.
package com.intellij.devkt.json.psi.impl;

import org.jetbrains.annotations.*;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElement;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;

import static com.intellij.devkt.json.JsonElementTypes.*;
import com.intellij.devkt.json.psi.*;

public class JsonReferenceExpressionImpl extends JsonValueImpl implements JsonReferenceExpression {

  public JsonReferenceExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JsonElementVisitor visitor) {
    visitor.visitReferenceExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JsonElementVisitor) accept((JsonElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
