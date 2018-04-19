// This is a generated file. Not intended for manual editing.
package com.intellij.devkt.json.psi;

import org.jetbrains.annotations.*;
import org.jetbrains.kotlin.com.intellij.psi.PsiNamedElement;
import org.jetbrains.kotlin.com.intellij.navigation.ItemPresentation;

public interface JsonProperty extends JsonElement, PsiNamedElement {

  @NotNull
  String getName();

  @NotNull
  JsonValue getNameElement();

  @Nullable
  JsonValue getValue();

  @Nullable
  ItemPresentation getPresentation();

}
