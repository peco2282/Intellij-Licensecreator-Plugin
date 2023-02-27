package com.github.peco2282.license;

import com.github.peco2282.license.utils.ResorceComponent;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptor;
import com.intellij.ide.fileTemplates.FileTemplateGroupDescriptorFactory;
import com.intellij.openapi.fileTypes.UnknownFileType;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class LicenseGenerator implements FileTemplateGroupDescriptorFactory {
  private final LicenseType licenseType;

  public LicenseGenerator(@NotNull LicenseType licenseType) {
    this.licenseType = licenseType;
  }

  /**
   * Creates a templates group containing a set of belonging templates.
   */
  @Override
  public FileTemplateGroupDescriptor getFileTemplatesDescriptor() {
    return null;
  }

  @NotNull
  public PsiFile generateLicense(final PsiDirectory directory) {
    final String fName = licenseType.getfName();
    final PsiFile currentFile = directory.findFile(fName);
    if (currentFile != null) {
      return currentFile;
    }
    final PsiFileFactory factory = PsiFileFactory.getInstance(directory.getProject());
    final LicenseData license = ResorceComponent.getLicenseData(licenseType);
    String content = replaceParametricValues(
        StringUtils.defaultIfBlank(license.getContent(), "[year] [fullname]")
    );
    final PsiFile file = factory.createFileFromText("LICENSE", UnknownFileType.INSTANCE, content);
    return (PsiFile) directory.add(file);
  }

  @NotNull
  private String replaceParametricValues(@NotNull String content) {
    return content
        .replace("[year]", String.valueOf(
            Calendar.getInstance().get(Calendar.YEAR))
        )
        .replace("[fullname]", System.getProperty("user.name")
        );
  }
}
