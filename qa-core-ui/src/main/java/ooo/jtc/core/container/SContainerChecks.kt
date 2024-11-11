package ooo.jtc.core.container

import com.codeborne.selenide.Condition
import ooo.jtc.scripts.invoke


/**
 * Ожидание [condition] для контейнера.
 */
infix fun <T : SContainer> T.wait(condition: Condition) {
    this.waitUntil(condition, this.timeout)
}


/**
 * Проверка [condition] для контейнера.
 */
infix fun <T : SContainer> T.should(condition: Condition) = "$title должен быть $condition " {
    this@should.should(condition)
}

/**
 * Сахар.
 */
infix fun <T : SContainer> T.shouldBe(condition: Condition) = should(condition)

infix fun <T : SContainer> T.shouldNot(condition: Condition) = "$title не должен быть $condition " {
    this@shouldNot.shouldNot(condition)
}

