package ooo.jtc.core.container

/**
 * Динамическое создание элементов по входящему в локатор тексту.
 *
 * @param creator - функция, создающая элемент с учетом принимаемого параметра `param`.
 * e.g.
 * ```
 * creator: (String) -> Button = {it -> Button(sElement = find("[name='$it']"))}
 * ```
 * см. [ooo.jtc.core.elements.AllElements.buttonByName]
 * ```
 * val buttonByName get() = SElementGet { Button(sElement = this.find("[name='$it']")) => buttonByName["code"]
 * ```
 */
class SElementGet<T : SContainer>(
    val creator: (String) -> T
) {
    operator fun get(param: String): T {
        return creator(param)
    }
}