// This is a generated file. Not intended for manual editing.
package com.intellij.devkt.json.psi.impl;

import org.jetbrains.annotations.*;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import com.intellij.devkt.json.psi.*;

public class JsonNumberLiteralImpl extends JsonLiteralImpl implements JsonNumberLiteral {

  public JsonNumberLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JsonElementVisitor visitor) {
    visitor.visitNumberLiteral(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JsonElementVisitor) accept((JsonElementVisitor)visitor);
    else super.accept(visitor);
  }

  public double getValue() {
    return JsonPsiImplUtils.getValue(this);
  }

}
