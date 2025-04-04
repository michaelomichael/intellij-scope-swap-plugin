package dev.michaelomichael.intellij.scopeswap.actions

import com.intellij.ide.projectView.ProjectView
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.diagnostic.thisLogger

class SelectDefaultScopeAction: AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val project = event.project ?: return

        ProjectView
            .getInstance(project)
            .apply {
                thisLogger().info("Switching to default project view '$defaultViewId'")
                changeView(defaultViewId)
            }
    }
}