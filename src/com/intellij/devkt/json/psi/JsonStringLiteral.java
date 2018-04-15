// This is a generated file. Not intended for manual editing.
package com.intellij.devkt.json.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import org.jetbrains.kotlin.com.intellij.psi.PsiElement;
import org.jetbrains.kotlin.com.intellij.openapi.util.Pair;
import org.jetbrains.kotlin.com.intellij.openapi.util.TextRange;

public interface JsonStringLiteral extends JsonLiteral {

  @NotNull
  List<Pair<TextRange, String>> getTextFragments();

  @NotNull
  String getValue();

}
