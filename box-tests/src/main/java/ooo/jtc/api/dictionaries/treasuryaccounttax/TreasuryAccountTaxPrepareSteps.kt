package ooo.jtc.api.dictionaries.treasuryaccounttax

import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccAccountTypeIEnum
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccAccountTypeIEnum.UTRA
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccStatusIEnum
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccount
import ooo.jtc.dictionaries.treasuryaccounttax.TreasuryAccountTaxDto
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.dictionaries.bankbic.BankBicData
import java.time.LocalDate
import java.util.UUID.randomUUID

object TreasuryAccountTaxPrepareSteps {

    const val ACCOUNT_CODE = "03100"
    const val ACCOUNT_CURRENCY = "643"
    const val ACCOUNT_PREFIX = ACCOUNT_CODE + ACCOUNT_CURRENCY

    val bankBic by lazy {
        BankBicData.get()
            .first {
                it.name.isNotEmpty()
                it.locationType != null && it.locationType!!.isNotEmpty()
                it.location != null && it.location!!.isNotEmpty()
            }

    }

    private val bankAccountDateIn: LocalDate = LocalDate.now()

    fun getTreasuryAccountTaxDtoForCreate(
        textFieldGenerator: RandomData = RandomData.allAllowedChars,
        utraAccount: String? = null
    ): TreasuryAccountTaxDto {
        return TreasuryAccountTaxDto(
            tofk = textFieldGenerator.random(length = 160, prefix = AT_PREFIX_RUS),
            account = RandomData.digits.random(length = 20, prefix = ACCOUNT_PREFIX),
            bankName = textFieldGenerator.random(
                length = 140,
                postfix = "//${bankBic.name} ${bankBic.locationType} ${bankBic.location}"
            ),
            bic = bankBic.bic,
            utraAccount = utraAccount ?: createBankBicAccount().account
        )
    }

    fun getTreasuryAccountTaxDtoForUpdate(createdDto: TreasuryAccountTaxDto): TreasuryAccountTaxDto {
        val updateDto = getTreasuryAccountTaxDtoForCreate()
        updateDto.id = createdDto.id
        updateDto.version += 1
        return updateDto
    }

    fun createBankBicAccount(accountType: BankBicAccAccountTypeIEnum? = null, status: BankBicAccStatusIEnum? = null): BankBicAccount {
        val bankBicAccount = BankBicAccount(
            id = randomUUID(),
            bicId = bankBic.id!!,
            account = RandomData.digits.random(length = 20),
            accountType = accountType?.value ?: UTRA.value,
            accountBic = RandomData.digits.random(length = 9),
            dateIn = bankAccountDateIn,
            status = status?.value ?: BankBicAccStatusIEnum.ACTIVE.value
        )
        Services.DICTIONARY.db.execute(
            """INSERT INTO bank_account 
    |                   (id, id_bic, account, account_type, account_bic, date_in, date_out, status)
    |           VALUES  ('${bankBicAccount.id}', '${bankBicAccount.bicId}', '${bankBicAccount.account}', '${bankBicAccount.accountType}', 
    |           '${bankBicAccount.accountBic}', '${bankBicAccount.dateIn}', NULL, '${bankBicAccount.status}')""".trimMargin()
        )
        return bankBicAccount
    }

    fun deleteBankBicAccounts() {
        Services.DICTIONARY.db.execute(
            """DELETE FROM bank_account 
    |           WHERE id_bic = '${bankBic.id}' AND date_in = '$bankAccountDateIn'"""
                .trimMargin()
        )
    }
}