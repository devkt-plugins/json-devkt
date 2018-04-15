// This is a generated file. Not intended for manual editing.
package com.intellij.devkt.json.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import org.jetbrains.kotlin.com.intellij.psi.PsiElement;
import org.jetbrains.kotlin.com.intellij.navigation.ItemPresentation;

public interface JsonArray extends JsonContainer {

  @NotNull
  List<JsonValue> getValueList();

  @Nullable
  ItemPresentation getPresentation();

}
