package com.github.peco2282.license.actions;

import com.github.peco2282.license.LicenseBundle;
import com.github.peco2282.license.LicenseType;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.DumbAware;

import java.util.Arrays;

public class NewFileGroupAction extends DefaultActionGroup implements DumbAware {
  public NewFileGroupAction() {
    super.setPopup(true);
    this.generatePresentation();
    Arrays.stream(LicenseType.values())
        .map(NewFileAction::new)
        .forEach(this::add);
  }

  private void generatePresentation() {
    Presentation presentation = this.getTemplatePresentation();
    presentation.setText(LicenseBundle.message("licenseFile.action.group"));
  }
}
