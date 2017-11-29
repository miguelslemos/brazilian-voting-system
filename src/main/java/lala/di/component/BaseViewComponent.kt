package lala.di.component

/**
 * Base Component that all components injecting into an view should extend from.
 */
interface BaseViewComponent<VIEW> {
    fun inject(view: VIEW)
}