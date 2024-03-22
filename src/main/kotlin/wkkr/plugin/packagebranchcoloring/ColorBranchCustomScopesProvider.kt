package wkkr.plugin.packagebranchcoloring

import com.intellij.psi.search.scope.packageSet.CustomScopesProviderEx
import com.intellij.psi.search.scope.packageSet.NamedScope

class ColorBranchCustomScopesProvider : CustomScopesProviderEx() {
    override fun getCustomScopes(): MutableList<NamedScope> = mutableListOf(ColorBranchScope.INSTANCE)
}