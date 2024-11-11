package tools

import ooo.jtc.api.common.steps.AbstractEntitySteps
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeSteps
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.testdata.Users
import org.junit.jupiter.api.Test
import java.io.File


class TestCodeGenerator {


    @Test
    fun ft() {
        val dictionaries = listOf(
//            "accounttype"
//            ,
            "bankru",
            "branch",
            "branchcustomer",
            "budgetpayerstatus",
            "codevo",
            "contractor",
            "country",
            "customer"
        )
        dictionaries.forEach {
            val path = System.getProperty("user.dir") + "/../datamodels/src/main/java/ooo/jtc/dictionaries/$it/model"
            val dir = File(path)
            val files = dir.listFiles()

            files?.forEach { file ->
                val entityName = file.name.replace(".kt", "")
                val mapperFileName = file.name.replace(".kt", "Mapper.kt")

                val ampTempl = """package ooo.jtc.dictionaries.$it.mapper

import ooo.jtc.dictionaries.$it.dto.${entityName}Dto
import ooo.jtc.dictionaries.$it.model.$entityName
import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.Mapper

@Mapper
interface ${entityName}Mapper : AbstractDtoMapper<$entityName, ${entityName}Dto>"""

                val targetDir = File("$path/../mapper/")
                targetDir.mkdir()
                val targetFile = File("$path/../mapper/$mapperFileName")
                targetFile.writeText(ampTempl)
            }


//            files?.forEach { file ->
//
//                val dtoName = file.name.replace(".kt", "Dto.kt")
//                var fileAsText = file.readText()
//                fileAsText = fileAsText.replace(".model", ".dto")
//                fileAsText = fileAsText.replace("import com.fasterxml.jackson.annotation.JsonProperty",
//                    "import com.fasterxml.jackson.annotation.JsonIgnoreProperties\n" +
//                        "import com.fasterxml.jackson.annotation.JsonInclude\n" +
//                        "import com.github.pozo.KotlinBuilder\n" +
//                        "import ooo.jtc.annotations.EntityName")
//                fileAsText = fileAsText.replace("IEntity", "IEntityDto")
//                fileAsText = fileAsText.replace("@JsonProperty\\(\"(.*)\"\\) ".toRegex(), "")
//
//                val pattern = "override val name: String = \"(.*)\"".toRegex()
//                val entityName = pattern.find(fileAsText)!!.value.replace(".*\"(.*)\"".toRegex(), "$1")
//
//                fileAsText = fileAsText.replace("\\@JsonIgnore".toRegex(), "")
//                fileAsText = fileAsText.replace(pattern, "")
//
//
//                fileAsText = fileAsText.replace(
//                    "data class (.*)\\(".toRegex(),
//                    """
//@KotlinBuilder
//@EntityName("$entityName")
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
//data class ${dtoName.replace(".kt","")}("""
//                )
//
//                val targetFile = File("$path/../dto/$dtoName")
//                targetFile.writeText(fileAsText)
//            }
        }
    }


    @Test
    fun generateMain() {
        val entityName = "BudgetReasonCode"
        val steps = BudgetReasonCodeSteps(Users.client)

        generateFilterParams(entityName, steps)
    }

    private val toSnake: (String) -> String = { it.replace("(.)(\\p{Upper})".toRegex(), "$1_$2").toUpperCase() }

    /**
     * Generate FilterParams
     */
    private fun <T : IEntityDto> generateFilterParams(
        entityName: String,
        steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
        isDictionary: Boolean = true
    ) {
        val packageName = entityName.toLowerCase()
        val pathPostfix: String = if (isDictionary) "dictionaries/$packageName" else packageName
        val packagePostfix: String = if (isDictionary) "dictionaries.$packageName" else packageName
        val path = System.getProperty("user.dir") + "/src/main/java/ooo/jtc/testdata/$pathPostfix"
        val fileName = "${entityName}FilterParams"
        val file = File("${path}/${fileName}.kt")

        val metadata = steps.getMetadata()
        val filteringFields = metadata.filteringFields

        val enumValues = filteringFields.map {
            """${toSnake(it)}("$it", fieldDataProvider = { it.$it }),"""
        }.joinToString("\n")


        val filterParamsCodeTemplate = """
            package ooo.jtc.testdata.$packagePostfix

            import ooo.jtc.api.common.filter.IFilterParams
            import ooo.jtc.$packagePostfix.dto.${entityName}Dto

            enum class ${fileName}(override var field: String,
                                   override var fieldDataProvider: (${entityName}Dto) -> Any) : IFilterParams<${entityName}Dto> {

               $enumValues
            ;
            }
        """.trimIndent()

        file.writeText(filterParamsCodeTemplate)
        println("$packagePostfix successfully generated")
    }

}