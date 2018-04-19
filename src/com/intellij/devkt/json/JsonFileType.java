package com.intellij.devkt.json;

import org.ice1000.devkt.openapi.ui.IconLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.com.intellij.openapi.fileTypes.LanguageFileType;

import javax.swing.*;

/**
 * @author Mikhail Golubev
 */
public class JsonFileType extends LanguageFileType {
	public static final @NotNull
	JsonFileType INSTANCE = new JsonFileType();
	public static final String DEFAULT_EXTENSION = "json";
	private Icon icon = IconLoader.getIcon("/icon/json_dark.png");

	public JsonFileType() {
		super(JsonLanguage.INSTANCE);
	}

	@Override
	public @NotNull
	String getName() {
		return "JSON";
	}

	@Override
	public @NotNull
	String getDescription() {
		return "JSON files";
	}

	@Override
	public @NotNull
	String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public @NotNull
	Icon getIcon() {
		return icon;
	}
}
