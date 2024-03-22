package wkkr.plugin.packagebranchcoloring

import com.intellij.icons.AllIcons
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.scope.packageSet.FilteredPackageSet
import com.intellij.psi.search.scope.packageSet.NamedScope
import com.intellij.ui.IconManager
import java.util.function.Supplier

class ColorBranchScope : NamedScope(
    NAME,
    Supplier { NAME },
    IconManager.getInstance().createOffsetIcon(AllIcons.Scope.ChangedFiles),
    object : FilteredPackageSet(NAME) {
        override fun contains(file: VirtualFile, project: Project): Boolean {
            return GitBranchHelper.isBranchFile(file, project)
        }
    }) {

    override fun getDefaultColorName(): String {
        return "Blue"
    }

    companion object {

        val NAME: String = "ColorBranchFiles"
        val INSTANCE: ColorBranchScope = ColorBranchScope()

    }
}