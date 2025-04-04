package dev.michaelomichael.intellij.scopeswap.actions

import com.intellij.ide.projectView.ProjectView
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.diagnostic.thisLogger
import dev.michaelomichael.intellij.scopeswap.services.ScopeSwapService

class SelectPreviousScopeAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        event
            .project
            ?.apply {
                getService(ScopeSwapService::class.java)
                    .previousViewIdAndSubId
                    ?.also {
                        thisLogger().info("Changing the ProjectView to [$it]'")
                        ProjectView
                            .getInstance(this)
                            .changeView(it.id, it.subId)
                    }
                    ?: thisLogger().info("No previous ProjectView id was recorded")
            }
    }
}