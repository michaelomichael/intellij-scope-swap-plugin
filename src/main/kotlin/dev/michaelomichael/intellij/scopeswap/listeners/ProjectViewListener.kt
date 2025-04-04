package dev.michaelomichael.intellij.scopeswap.listeners

import com.intellij.ide.projectView.impl.AbstractProjectViewPane
import com.intellij.ide.projectView.impl.ProjectViewListener
import com.intellij.openapi.project.Project
import dev.michaelomichael.intellij.scopeswap.services.ScopeSwapService
import dev.michaelomichael.intellij.scopeswap.services.ScopeSwapService.ViewIdAndSubId.Companion.idAndSubId

class ProjectViewListener(private val project: Project) : ProjectViewListener {
    override fun paneShown(current: AbstractProjectViewPane, previous: AbstractProjectViewPane?) {
        project
            .getService(ScopeSwapService::class.java)
            .previousViewIdAndSubId = previous?.idAndSubId
    }
}