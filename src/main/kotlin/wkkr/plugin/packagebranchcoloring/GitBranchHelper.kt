package wkkr.plugin.packagebranchcoloring

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.vfs.VirtualFile
import java.io.File
import java.util.concurrent.TimeUnit

object GitBranchHelper {
    fun getBranchFiles(project: Project) : List<String> {
        val projectRootManager = ProjectRootManager.getInstance(project)
        val loc = projectRootManager.contentRootUrls[0].removePrefix("file://")
        return "git diff --name-only origin/master".runCommand(File(loc))
    }

    fun isBranchFile(file: VirtualFile, project: Project) =
        getBranchFiles(project).contains(file.path.removePrefix("${project.basePath}/"))

    fun String.runCommand(workingDir: File?) : List<String>{
        val proc = ProcessBuilder(*split(" ").toTypedArray())
            .directory(workingDir)
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .redirectError(ProcessBuilder.Redirect.INHERIT)
            .start()
        proc.waitFor(60, TimeUnit.MINUTES)

        return proc.inputStream.bufferedReader().readLines().map { it }.toList()
    }
}