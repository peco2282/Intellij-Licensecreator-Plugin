package com.github.peco2282.license.utils;

import com.github.peco2282.license.LicenseData;
import com.github.peco2282.license.LicenseType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

@NotNull
public class ResorceComponent {
  @NotNull
  private static final String resourceDir = "/format/";

  @NotNull
  public static LicenseData getLicenseData(@NotNull LicenseType type) {
    final String fPath = resourceDir + type.getfName();
    File file = ResorceComponent.getResource(fPath);
    String content = getDescription(file, fPath);
    return new LicenseData(type, content);
  }

  @NotNull
  private static String getDescription(
      @Nullable File file,
      @NotNull String fPath
  ) {
    if (file == null) {
      return "";
    }
    String content = ResorceComponent.convertString(
        ResorceComponent.class.getResourceAsStream(fPath)
    );
    if (content == null) {
      return "";
    }
    return content;
  }

  public static @Nullable File getResource(@NotNull String fPath) {
    URL url = ResorceComponent.class.getResource(fPath);
    return url == null ? null : new File(url.getPath());
  }

  public static @Nullable String convertString(@Nullable InputStream stream) {
    if (stream == null) {
      return null;
    }
    Scanner scanner = new Scanner(stream).useDelimiter("\\A");
    return scanner.hasNext() ? scanner.next() : "";
  }
}
