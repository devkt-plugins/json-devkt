package com.intellij.devkt.json.psi;

import com.intellij.devkt.json.JsonElementTypes;
import org.jetbrains.kotlin.com.intellij.lang.PsiBuilder;
import org.jetbrains.kotlin.com.intellij.lang.parser.GeneratedParserUtilBase;
import org.jetbrains.kotlin.com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * @author Mikhail Golubev
 */
public class JsonParserUtil extends GeneratedParserUtilBase {

  public static boolean notTrailingComma(@NotNull PsiBuilder builder, int level) {
    if (builder.getTokenType() != JsonElementTypes.COMMA) {
      return false;
    }
    final IElementType afterComma = builder.lookAhead(1);
    if (afterComma == JsonElementTypes.R_BRACKET || afterComma == JsonElementTypes.R_CURLY) {
      builder.error("trailing comma");
    }
    builder.advanceLexer();
    return true;
  }
}
