package ooo.jtc.be.dictionaries

import ooo.jtc.api.dictionaries.individualrepresentative.IndividualRepresentativeCreateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.testdata.Users.individual
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class IndividualRepresentativeTestsSuite {

    @TestFactory
    internal fun individualRepresentativeCrudTests(): List<DynamicTest>{
        return EntityTestGenerator.generate(
            listOf(
                IndividualRepresentativeCreateTest(individual)
                // TODO Khatmullin [2021.06.07] Tests not implemented cos of changes in nested entity
            )
        )
    }
}