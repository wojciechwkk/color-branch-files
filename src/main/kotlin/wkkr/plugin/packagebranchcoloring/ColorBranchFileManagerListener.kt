package wkkr.plugin.packagebranchcoloring

import com.intellij.openapi.editor.Document
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.FileDocumentManagerListener
import com.intellij.openapi.project.guessProjectForFile

class ColorBranchFileManagerListener : FileDocumentManagerListener {


    override fun beforeDocumentSaving(document: Document) {
        super.beforeDocumentSaving(document)
        val file = FileDocumentManager.getInstance().getFile(document)
        val project = guessProjectForFile(file!!)
        GitBranchFiles.INSTANCE.updateBranchFiles(project!!)
    }
}