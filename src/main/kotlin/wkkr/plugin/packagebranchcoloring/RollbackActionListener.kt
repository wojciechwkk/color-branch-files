package wkkr.plugin.packagebranchcoloring

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.AnActionResult
import com.intellij.openapi.actionSystem.ex.AnActionListener
import com.intellij.openapi.vcs.changes.actions.RollbackAction

class RollbackActionListener : AnActionListener {

    override fun afterActionPerformed(action: AnAction, event: AnActionEvent, result: AnActionResult) {
        super.afterActionPerformed(action, event, result)
        if (action is RollbackAction) {
            event.project?.let { GitBranchFiles.INSTANCE.updateBranchFiles(it) }
        }
    }

}