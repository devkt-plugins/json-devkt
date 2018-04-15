package com.intellij.devkt.json.psi.impl;

import org.jetbrains.kotlin.com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.devkt.json.psi.JsonElement;
import org.jetbrains.kotlin.com.intellij.lang.ASTNode;
import org.jetbrains.kotlin.com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.NotNull;

/**
 * @author Mikhail Golubev
 */
public class JsonElementImpl extends ASTWrapperPsiElement implements JsonElement {

  public JsonElementImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public String toString() {
    final String className = getClass().getSimpleName();
    return StringUtil.trimEnd(className, "Impl");
  }
}
