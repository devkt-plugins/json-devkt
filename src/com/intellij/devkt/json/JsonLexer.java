package com.intellij.devkt.json;

import org.jetbrains.kotlin.com.intellij.lexer.FlexAdapter;

/**
 * @author Mikhail Golubev
 */
public class JsonLexer extends FlexAdapter {
  public JsonLexer() {
    super(new _JsonLexer());
  }
}
