package co.touchlab.core.common

import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope

inline fun <reified T> Scope.getWith(vararg params: Any?): T {
    return get(parameters = { parametersOf(*params) })
}