package com.intellij.devkt.json.psi.impl;

import org.jetbrains.kotlin.com.intellij.lang.ASTNode;

/**
 * @author Konstantin.Ulitin
 */
public abstract class JsonStringLiteralMixin extends JsonLiteralImpl {
  protected JsonStringLiteralMixin(ASTNode node) {
    super(node);
  }
}
