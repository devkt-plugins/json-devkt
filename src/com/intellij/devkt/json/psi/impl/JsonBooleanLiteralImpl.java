// This is a generated file. Not intended for manual editing.
package com.intellij.devkt.json.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.psi.PsiElement;
import org.jetbrains.kotlin.com.intellij.psi.PsiElementVisitor;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;
import static com.intellij.devkt.json.JsonElementTypes.*;
import com.intellij.devkt.json.psi.*;

public class JsonBooleanLiteralImpl extends JsonLiteralImpl implements JsonBooleanLiteral {

  public JsonBooleanLiteralImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull JsonElementVisitor visitor) {
    visitor.visitBooleanLiteral(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JsonElementVisitor) accept((JsonElementVisitor)visitor);
    else super.accept(visitor);
  }

  public boolean getValue() {
    return JsonPsiImplUtils.getValue(this);
  }

}
