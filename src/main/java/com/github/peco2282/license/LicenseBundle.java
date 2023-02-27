package com.github.peco2282.license;

import com.intellij.AbstractBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.util.ResourceBundle;

public class LicenseBundle {

  @NotNull
  private static final String BUNDLE = "messages.LicenseBundle";
  @NotNull
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE);

  public LicenseBundle() {
  }

  @NotNull
  public static String message(
      @NotNull @PropertyKey(resourceBundle = LicenseBundle.BUNDLE) String key,
      Object... param
  ) {
    return AbstractBundle.message(LicenseBundle.RESOURCE_BUNDLE, key, param);
  }
}
