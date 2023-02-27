package com.github.peco2282.license;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LicenseData {
  @NotNull
  private  final LicenseType type;
  @Nullable
  private final String content;

  public LicenseData(@NotNull LicenseType type, @NotNull String content) {
    this.type = type;
    this.content = content;
  }

  @NotNull
  public LicenseType getType() {
    return type;
  }

  @NotNull
  public String getContent() {
    return content;
  }
}
