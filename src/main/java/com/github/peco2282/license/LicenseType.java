package com.github.peco2282.license;

import org.jetbrains.annotations.NotNull;

public enum LicenseType {
  AAL("AAL", "Attribution Assurance License"),
  AFL30("AFLv3_0", "Academic Free License v. 3.0"),
  APACHE10("Apachev1_0", "Apache Software License 1.1"),
  APACHE11("Apache1_1", "The Apache Software License, Version 1.1"),
  APACHE20("Apache2_0", "Apache License Version 2.0, January 2004"),
  APGL("APGLv3_0", "GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007"),
  BSD2("BSDv2", "BSD 2-Clause License"),
  BSD3("BSDv3", "BSD 3-Clause License"),
  CDDL10("CDDLv1_0", "COMMON DEVELOPMENT AND DISTRIBUTION LICENSE (CDDL) Version 1.0"),
  EPL20("EPLv2_0", "Eclipse Public License - v 2.0"),
  GPL10("GPLv1_0", "GNU GENERAL PUBLIC LICENSE Version 1, February 1989"),
  GPL20("GPLv2_0", "GNU GENERAL PUBLIC LICENSE Version 2, June 1991"),
  GPL30("GPLv3_0", "GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007"),
  LGPL20("LGPLv2_0", "GNU LIBRARY GENERAL PUBLIC LICENSE Version 2, June 1991"),
  LGPL21("LGPLv2_1", "GNU LESSER GENERAL PUBLIC LICENSE Version 2.1, February 1999"),
  LGPL30("LGPLv3_0", "GNU LESSER GENERAL PUBLIC LICENSE Version 3, 29 June 2007"),
  MIT("MIT", "MIT License"),
  MPL20("MPLv2_0", "Mozilla Public License Version 2.0"),
  NO_LICENSE("NO_LICENSE", "This is free and unencumbered software released into the public domain.")
  ;
  @NotNull private final String fName;
  @NotNull private final String description;

  LicenseType(@NotNull String key, @NotNull String description) {
    this.fName = key;
    this.description = description;
  }

  public @NotNull String getDescription() {
    return description;
  }

  public @NotNull String getfName() {
    return fName;
  }
}
