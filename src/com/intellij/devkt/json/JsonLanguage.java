package com.intellij.devkt.json;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.com.intellij.lang.Language;
import org.jetbrains.kotlin.com.intellij.openapi.fileTypes.LanguageFileType;

public class JsonLanguage extends Language {
	public static final JsonLanguage INSTANCE = new JsonLanguage();

	private JsonLanguage() {
		super("JSON", "application/json", "application/vnd.api+json", "application/hal+json");
	}

	@Nullable
	@Override
	public LanguageFileType getAssociatedFileType() {
		return JsonFileType.INSTANCE;
	}

	@Override
	public boolean isCaseSensitive() {
		return true;
	}
}
