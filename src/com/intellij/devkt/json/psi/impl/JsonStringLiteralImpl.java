// This is a generated file. Not intended for manual editing.
package com.intellij.devkt.json.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import com.intellij.devkt.json.psi.*;
import org.jetbrains.kotlin.com.intellij.openapi.util.Pair;
import org.jetbrains.kotlin.com.intellij.openapi.util.TextRange;

public class JsonStringLiteralImpl extends JsonStringLiteralMixin implements JsonStringLiteral {

  public JsonStringLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JsonElementVisitor visitor) {
    visitor.visitStringLiteral(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JsonElementVisitor) accept((JsonElementVisitor)visitor);
    else super.accept(visitor);
  }

  @NotNull
  public List<Pair<TextRange, String>> getTextFragments() {
    return JsonPsiImplUtils.getTextFragments(this);
  }

  @NotNull
  public String getValue() {
    return JsonPsiImplUtils.getValue(this);
  }

}
