@file:Suppress("MemberVisibilityCanBePrivate")

package ooo.jtc.random

import javassist.NotFoundException
import org.yaml.snakeyaml.Yaml
import kotlin.random.Random

@Suppress("UNCHECKED_CAST")
object RandomNameUtils {
    private val randData = Yaml().load(this::class.java.getResource("/rand_values_ru.yml").readText()) as MutableMap<String, Any>
    private val nameData = randData["name"] as Map<String, List<String>>
    private val companyData = randData["company"] as Map<String, Any>
    private val companyPrefixData = companyData["prefix"] as List<Map<String, String>>
    private val companyInternationalSuffixData = companyData["international_suffix"] as List<Map<String, String>>
    private val addressData = randData["address"] as Map<String, Any>


    private fun getNameList(listName: String): List<String> {
        return nameData[listName] ?: throw NotFoundException("$listName not found in $nameData")
    }

    private fun getCompanyPrefix(prefixType: String): String {
        return companyPrefixData.random()[prefixType] ?: throw NotFoundException("$prefixType not found in $companyPrefixData")
    }

    private fun getCompanyInternationalSuffix(suffixType: String): String {
        return companyInternationalSuffixData.random()[suffixType]
            ?: throw NotFoundException("$suffixType not found in $companyInternationalSuffixData")
    }

    private fun getFullCompanyPrefix(shortPrefixName: String): String {
        return companyPrefixData.find { it[AffixType.short] == shortPrefixName }?.get(AffixType.full)
            ?: throw NotFoundException("Full prefix for short prefix '$shortPrefixName' not found in $companyPrefixData")
    }

    private fun getFullInternationalCompanySuffix(shortSuffixName: String): String {
        return companyInternationalSuffixData.find { it[AffixType.short] == shortSuffixName }?.get(AffixType.full)
            ?: throw NotFoundException("Full suffix for short suffix '$shortSuffixName' not found in $companyInternationalSuffixData")
    }

    private fun getCompanyNameList(): List<String> {
        return (companyData["name"] as List<String>)
    }

    private fun getCompanyInternationalNameList(): List<String> {
        return (companyData["international_name"] as List<String>)
    }

    fun anyFirstName(): String {
        return listOf(maleFirstName(), femaleFirstName()).random()
    }

    fun maleFirstName(): String {
        return getNameList("male_first_name").random()
    }


    fun femaleFirstName(): String {
        return getNameList("female_first_name").random()
    }

    fun anyMiddleName(): String {
        return listOf(maleMiddleName(), femaleMiddleName()).random()
    }

    fun maleMiddleName(): String {
        return getNameList("male_middle_name").random()
    }

    fun femaleMiddleName(): String {
        return getNameList("female_middle_name").random()
    }

    fun anyLastName(): String {
        return listOf(maleLastName(), femaleLastName()).random()
    }

    fun maleLastName(): String {
        return getNameList("male_last_name").random()
    }

    fun femaleLastName(): String {
        return getNameList("female_last_name").random()
    }

    fun anyFullName(order: FullNameOrder = FullNameOrder.FIO): String {
        return listOf(maleFullName(order), femaleFullName(order)).random()
    }

    fun maleFullName(order: FullNameOrder = FullNameOrder.FIO): String {
        val nameMap = mapOf(
            "F" to maleLastName(),
            "I" to maleFirstName(),
            "O" to maleMiddleName()
        )
        return order.dir.map { nameMap[it] }.joinToString(" ")
    }

    fun femaleFullName(order: FullNameOrder = FullNameOrder.FIO): String {
        val nameMap = mapOf(
            "F" to femaleLastName(),
            "I" to femaleFirstName(),
            "O" to femaleMiddleName()
        )
        return order.dir.map { nameMap[it] }.joinToString(" ")
    }

    fun companyShortName(isIP: Boolean = false): String {
        if (isIP) return ipShortName()
        return "${getCompanyPrefix(AffixType.short)} \"${getCompanyNameList().random()}\""
    }

    fun companyFullName(companyShortName: String? = null, isIP: Boolean = false): String {
        if (isIP) return ipFullName(companyShortName)
        return companyShortName?.let {
            val shortPrefix = it.substringBefore(" ")
            val fullPrefix = getFullCompanyPrefix(shortPrefix)
            it.replace(shortPrefix, fullPrefix)
        } ?: "${getCompanyPrefix(AffixType.full)} \"${getCompanyNameList().random()}\""
    }

    fun ipShortName(order: FullNameOrder = FullNameOrder.FIO): String {
        return "ИП ${anyFullName(order)}"
    }

    fun ipFullName(ipShortName: String? = null, order: FullNameOrder = FullNameOrder.FIO): String {
        val fullIp = "Индивидуальный предприниматель"
        return ipShortName?.replace("^ИП".toRegex(), fullIp) ?: "$fullIp ${anyFullName(order)}"
    }

    fun companyInternationalShortName(): String {
        return "${getCompanyInternationalNameList().random()} ${getCompanyInternationalSuffix(AffixType.short)}"
    }

    fun companyInternationalFullName(companyInternationalShortName: String? = null): String {
        return companyInternationalShortName?.let {
            val shortSuffix = it.substringAfterLast(" ")
            val fullSuffix = getFullInternationalCompanySuffix(shortSuffix)
            it.replace(shortSuffix, fullSuffix)
        } ?: "${getCompanyInternationalNameList().random()} ${getCompanyInternationalSuffix(AffixType.full)}"
    }

    /**
     * Prepare correct bank short name.
     * [isChild] - flag for filial (sub-branch)
     */
    fun bankShortName(isChild: Boolean = false): String {
        val prefix = listOf("ООО", "ПАО", "АО", "ЗАО", "ОДО").random()
        val branchName = "$prefix Банк \"${getCompanyNameList().random()}\""
        val resultName = if (isChild) "Филиал № ${Random.nextInt(5000)} $branchName" else branchName
        if (resultName.length > 50) return bankShortName(isChild)
        return resultName
    }

    /**
     * Prepare correct bank full name by [shortName].
     */
    fun bankFullName(shortName: String): String {
        val cropName = shortName.replace("Филиал №\\s\\d+\\s".toRegex(), "")
        val shortPrefix = cropName.substringBefore(" ")
        val fullPrefix = getFullCompanyPrefix(shortPrefix)
        return shortName.replace(shortPrefix, fullPrefix)
    }


    //region Address

    fun city(): String {
        return (addressData["city_name"] as List<String>).random()
    }

    fun state(): String {
        return (addressData["state"] as List<String>).random()
    }

    fun street(): String {
        val streetNames = addressData["street_title"] as List<String>
        val streetSuffix = (addressData["street_suffix"] as List<String>).random()

        var streetName = streetNames.random()
        if (streetSuffix in listOf("проспект", "пр.")) {
            streetName = streetNames.filter { !it.endsWith('я') }.random()
        }
        return "$streetSuffix $streetName"
    }
    //endregion


    private object AffixType {
        const val short = "short"
        const val full = "full"
    }
}

enum class FullNameOrder(val dir: List<String>) {
    FIO(listOf("F", "I", "O")),
    IOF(listOf("I", "O", "F"))
}