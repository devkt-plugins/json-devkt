package com.intellij.devkt.json.highlighting;

/*public class JsonSyntaxHighlighterFactory extends SyntaxHighlighterFactory {

  public static final TextAttributesKey JSON_BRACKETS = TextAttributesKey.createTextAttributesKey("JSON.BRACKETS", BRACKETS);
  public static final TextAttributesKey JSON_BRACES = TextAttributesKey.createTextAttributesKey("JSON.BRACES", BRACES);
  public static final TextAttributesKey JSON_COMMA = TextAttributesKey.createTextAttributesKey("JSON.COMMA", COMMA);
  public static final TextAttributesKey JSON_COLON = TextAttributesKey.createTextAttributesKey("JSON.COLON", SEMICOLON);
  public static final TextAttributesKey JSON_NUMBER = TextAttributesKey.createTextAttributesKey("JSON.NUMBER", NUMBER);
  public static final TextAttributesKey JSON_STRING = TextAttributesKey.createTextAttributesKey("JSON.STRING", STRING);
  public static final TextAttributesKey JSON_KEYWORD = TextAttributesKey.createTextAttributesKey("JSON.KEYWORD", KEYWORD);
  public static final TextAttributesKey JSON_LINE_COMMENT = TextAttributesKey.createTextAttributesKey("JSON.LINE_COMMENT", LINE_COMMENT);
  public static final TextAttributesKey JSON_BLOCK_COMMENT = TextAttributesKey.createTextAttributesKey("JSON.BLOCK_COMMENT", BLOCK_COMMENT);

  // Artificial element type
  public static final TextAttributesKey JSON_IDENTIFIER = TextAttributesKey.createTextAttributesKey("JSON.IDENTIFIER", IDENTIFIER);

  // Added by annotators
  public static final TextAttributesKey JSON_PROPERTY_KEY = TextAttributesKey.createTextAttributesKey("JSON.PROPERTY_KEY", INSTANCE_FIELD);

  // String escapes
  public static final TextAttributesKey JSON_VALID_ESCAPE =
    TextAttributesKey.createTextAttributesKey("JSON.VALID_ESCAPE", VALID_STRING_ESCAPE);
  public static final TextAttributesKey JSON_INVALID_ESCAPE =
    TextAttributesKey.createTextAttributesKey("JSON.INVALID_ESCAPE", INVALID_STRING_ESCAPE);


  @NotNull
  @Override
  public SyntaxHighlighter getSyntaxHighlighter(@Nullable Project project, @Nullable VirtualFile virtualFile) {
    return new MyHighlighter();
  }

  private static class MyHighlighter extends SyntaxHighlighterBase {
    private static final Map<IElementType, TextAttributesKey> ourAttributes = new HashMap<>();

    static {
      fillMap(ourAttributes, JSON_BRACES, JsonElementTypes.L_CURLY, JsonElementTypes.R_CURLY);
      fillMap(ourAttributes, JSON_BRACKETS, JsonElementTypes.L_BRACKET, JsonElementTypes.R_BRACKET);
      fillMap(ourAttributes, JSON_COMMA, JsonElementTypes.COMMA);
      fillMap(ourAttributes, JSON_COLON, JsonElementTypes.COLON);
      fillMap(ourAttributes, JSON_STRING, JsonElementTypes.DOUBLE_QUOTED_STRING);
      fillMap(ourAttributes, JSON_STRING, JsonElementTypes.SINGLE_QUOTED_STRING);
      fillMap(ourAttributes, JSON_NUMBER, JsonElementTypes.NUMBER);
      fillMap(ourAttributes, JSON_KEYWORD, JsonElementTypes.TRUE, JsonElementTypes.FALSE, JsonElementTypes.NULL);
      fillMap(ourAttributes, JSON_LINE_COMMENT, JsonElementTypes.LINE_COMMENT);
      fillMap(ourAttributes, JSON_BLOCK_COMMENT, JsonElementTypes.BLOCK_COMMENT);
      // TODO may be it's worth to add more sensible highlighting for identifiers
      fillMap(ourAttributes, JSON_IDENTIFIER, JsonElementTypes.IDENTIFIER);
      fillMap(ourAttributes, HighlighterColors.BAD_CHARACTER, TokenType.BAD_CHARACTER);

      fillMap(ourAttributes, JSON_VALID_ESCAPE, StringEscapesTokenTypes.VALID_STRING_ESCAPE_TOKEN);
      fillMap(ourAttributes, JSON_INVALID_ESCAPE, StringEscapesTokenTypes.INVALID_CHARACTER_ESCAPE_TOKEN);
      fillMap(ourAttributes, JSON_INVALID_ESCAPE, StringEscapesTokenTypes.INVALID_UNICODE_ESCAPE_TOKEN);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
      LayeredLexer layeredLexer = new LayeredLexer(new JsonLexer());
      layeredLexer.registerSelfStoppingLayer(new StringLiteralLexer('\"', JsonElementTypes.DOUBLE_QUOTED_STRING, false, "/", false, false),
                                             new IElementType[]{JsonElementTypes.DOUBLE_QUOTED_STRING}, IElementType.EMPTY_ARRAY);
      layeredLexer.registerSelfStoppingLayer(new StringLiteralLexer('\'', JsonElementTypes.SINGLE_QUOTED_STRING, false, "/", false, false),
                                             new IElementType[]{JsonElementTypes.SINGLE_QUOTED_STRING}, IElementType.EMPTY_ARRAY);
      return layeredLexer;
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType type) {
      return pack(ourAttributes.get(type));
    }
  }
}*/
