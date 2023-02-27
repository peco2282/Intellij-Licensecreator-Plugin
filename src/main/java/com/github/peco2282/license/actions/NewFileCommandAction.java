package com.github.peco2282.license.actions;

import com.github.peco2282.license.LicenseGenerator;
import com.github.peco2282.license.LicenseType;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class NewFileCommandAction {
  private final Project project;
  private final PsiDirectory directory;
  private final LicenseType type;

  public NewFileCommandAction(
      @NotNull Project project,
      @NotNull PsiDirectory directory,
      @NotNull LicenseType type
  ) {
    this.project = project;
    this.directory = directory;
    this.type = type;
  }

  private PsiFile conpute() {
    final LicenseGenerator generator = new LicenseGenerator(type);
    return generator.generateLicense(directory);
  }

  public final PsiFile generate() {
    return WriteCommandAction.writeCommandAction(project).compute(this::conpute);
  }
}
