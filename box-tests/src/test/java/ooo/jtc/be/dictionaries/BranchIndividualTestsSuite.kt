package ooo.jtc.be.dictionaries

import ooo.jtc.api.dictionaries.branchindividual.BranchIndividualCreateTest
import ooo.jtc.core.EntityTestGenerator
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

class BranchIndividualTestsSuite {
    @TestFactory
    @Execution(ExecutionMode.SAME_THREAD)
    internal fun branchIndividualCrudTests(): List<DynamicTest> {
        val tests = listOf(
            BranchIndividualCreateTest()
            // TODO Khatmullin [2021.06.07] Tests not implemented cos of changes in nested entity
        )
        return EntityTestGenerator.generate(tests)
    }
}