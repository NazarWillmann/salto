package ooo.jtc.testdata.common

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.interfaces.IEntity
import java.util.UUID

abstract class TestDataAT<E : IEntity>(entityClass: Class<E>) : TestData<E>(entityClass) {

    override var createRecord: (() -> E)? = { throw RuntimeException("Use only custom creation providers with user depending.") }

    @Step("Найти в БД или создать сущность '{this.testDataName}'")
    open fun getOrCreate(consumer: () -> List<E> = { get(false, predicate = this.atMarkerPredicate) }, provider: (() -> E)): E =
        consumer.invoke().ifEmpty {
            listOf(
                provider.invoke()
            )
        }.random()
            .attachToAllure()

    override fun get(fromCache: Boolean, seekAtCreated: Boolean?): List<E> {
        return super.get(fromCache = false, seekAtCreated = seekAtCreated)
    }

    override fun get(fromCache: Boolean, seekAtCreated: Boolean?, predicate: (E) -> Boolean): List<E> {
        return super.get(fromCache = false, seekAtCreated = seekAtCreated, predicate = predicate)
    }

    override fun byId(id: UUID, fromCache: Boolean): E {
        return super.byId(fromCache = false, id = id)
    }

    override fun random(fromCache: Boolean, seekAtCreated: Boolean?): E? {
        return super.random(fromCache = false, seekAtCreated = seekAtCreated)
    }

    override fun randomOrException(fromCache: Boolean, seekAtCreated: Boolean?): E {
        return super.randomOrException(fromCache = false, seekAtCreated = seekAtCreated)
    }

    override fun getRandomIds(size: Int, fromCache: Boolean): List<UUID?> {
        return super.getRandomIds(fromCache = false, size = size)
    }

    override fun find(fromCache: Boolean, predicate: (E) -> Boolean): E {
        return super.find(fromCache = false, predicate = predicate)
    }

    override fun withRequiredFields(
        fromCache: Boolean,
        requiredDataCount: Long,
        additionalFilter: (E) -> Boolean,
        customCreator: (() -> E)?
    ): TestDataScope<E> {
        val atPredicate: (E) -> Boolean = { this.atMarkerPredicate.invoke(it) }
        val combinedAdditionalFilter: (E) -> Boolean = { additionalFilter.invoke(it) && atPredicate.invoke(it) }
        return super.withRequiredFields(false, requiredDataCount, combinedAdditionalFilter, customCreator)
    }
}