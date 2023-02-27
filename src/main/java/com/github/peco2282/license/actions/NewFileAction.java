package com.github.peco2282.license.actions;

import com.github.peco2282.license.LicenseBundle;
import com.github.peco2282.license.LicenseType;
import com.intellij.ide.IdeView;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class NewFileAction extends AnAction implements DumbAware {
  LicenseType type;
  String GROUP_ID = "License generator";

  NewFileAction(@NotNull LicenseType type) {
    this.type = type;
    generatePresentation(type);
  }

  /**
   * Implement this method to provide your action handler.
   *
   * @param e Carries information on the invocation place
   */
  @Override
  public void actionPerformed(@NotNull AnActionEvent e) {
    final Project project = e.getRequiredData(CommonDataKeys.PROJECT);
    final IdeView view = e.getRequiredData(LangDataKeys.IDE_VIEW);
    final PsiDirectory directory = view.getOrChooseDirectory();
    if (directory == null) {
      return;
    }
    final PsiFile file = directory.findFile("LICENSE");
    final VirtualFile virtualFile = this.getVirtualFile(directory, file);

    if (file != null) {
      Notifications.Bus.notify(
          new Notification(
              GROUP_ID,
              LicenseBundle.message("licenseFile.action.exists"),
              LicenseBundle.message("licenseFile.action.exists.in", Objects.requireNonNull(virtualFile).getPath()),
              NotificationType.ERROR
          ), project
      );
    } else {
      final PsiFile psiFile = this.genLicense(project, directory);
      Notifications.Bus.notify(
          new Notification(
              GROUP_ID,
              LicenseBundle.message("licenseFile.action.created"),
              LicenseBundle.message("licenseFile.action.created.success"),
              NotificationType.INFORMATION
          )
      );
    }
  }

  @Contract(pure = true)
  private @Nullable PsiFile genLicense(Project project, PsiDirectory directory) {
    return new NewFileCommandAction(project, directory, type).generate();
  }

  @Nullable
  VirtualFile getVirtualFile(
      @NotNull PsiDirectory directory,
      @Nullable PsiFile file
  ) {
    if (file == null) {
      return directory.getVirtualFile().findChild("LICENSE");
    }
    return file.getVirtualFile();
  }

  void generatePresentation(@NotNull LicenseType type) {
    final Presentation presentation = getTemplatePresentation();
    presentation.setText(type.getfName());
    presentation.setDescription(
        LicenseBundle.message("licenseFile.action.description", type.getDescription())
    );
  }
}
