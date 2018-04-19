// This is a generated file. Not intended for manual editing.
package com.intellij.devkt.json.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import org.jetbrains.kotlin.com.intellij.navigation.ItemPresentation;

public interface JsonObject extends JsonContainer {

  @NotNull
  List<JsonProperty> getPropertyList();

  @Nullable
  JsonProperty findProperty(String name);

  @Nullable
  ItemPresentation getPresentation();

}
