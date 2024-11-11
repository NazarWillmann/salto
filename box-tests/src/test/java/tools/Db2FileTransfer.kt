package tools

import ooo.jtc.reflections.ReflectionUtils
import ooo.jtc.testdata.common.TestData
import ooo.jtc.testdata.common.TestDataSource
import org.junit.jupiter.api.Test

class Db2FileTransfer {

    @Test
    fun loadFromDbToFiles() {
        val testDataClasses = ReflectionUtils.findKotlinObjects(TestData::class.java)
        testDataClasses.forEach {
            it.transfer(TestDataSource.DATABASE, TestDataSource.FILE)
        }
    }
}