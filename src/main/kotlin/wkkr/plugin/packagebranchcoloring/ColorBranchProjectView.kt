package wkkr.plugin.packagebranchcoloring

import com.intellij.ide.projectView.impl.ProjectViewPane
import com.intellij.openapi.project.Project

class ColorBranchProjectView(project: Project) : ProjectViewPane(project) {

    init {
        GitBranchFiles.INSTANCE.initFiles(project)
    }
}