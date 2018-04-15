package com.intellij.devkt.json.psi.impl;

import org.jetbrains.kotlin.com.intellij.extapi.psi.PsiFileBase;
import com.intellij.devkt.json.JsonLanguage;
import com.intellij.devkt.json.psi.JsonFile;
import com.intellij.devkt.json.psi.JsonValue;
import org.jetbrains.kotlin.com.intellij.openapi.fileTypes.FileType;
import org.jetbrains.kotlin.com.intellij.psi.FileViewProvider;
import org.jetbrains.kotlin.com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class JsonFileImpl extends PsiFileBase implements JsonFile {

  public JsonFileImpl(FileViewProvider fileViewProvider) {
    super(fileViewProvider, JsonLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return getViewProvider().getFileType();
  }

  @Nullable
  @Override
  public JsonValue getTopLevelValue() {
    return PsiTreeUtil.getChildOfType(this, JsonValue.class);
  }

  @NotNull
  @Override
  public List<JsonValue> getAllTopLevelValues() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, JsonValue.class);
  }

  @Override
  public String toString() {
    return "JsonFile: " + getName();
  }
}
