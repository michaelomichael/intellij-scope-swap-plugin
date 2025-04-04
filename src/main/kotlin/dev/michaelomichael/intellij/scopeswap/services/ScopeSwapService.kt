package dev.michaelomichael.intellij.scopeswap.services

import com.intellij.ide.projectView.impl.AbstractProjectViewPane
import com.intellij.openapi.components.Service

@Service(Service.Level.PROJECT)
class ScopeSwapService {
    var previousViewIdAndSubId : ViewIdAndSubId? = null

    data class ViewIdAndSubId(val id: String, val subId: String?) {
        companion object {
            val AbstractProjectViewPane.idAndSubId
                get() = ViewIdAndSubId(this.id, this.subId)
        }
    }
}