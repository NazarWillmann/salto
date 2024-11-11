package ooo.jtc.api.platform.crypto.bankkey

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.crypto.BankKeyDto
import ooo.jtc.generic.CryptoNames
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User

/**
 * BankKeySteps.
 * "Это справочник банковских ключей для атвоматической подписи.
 * Используется соответственно там где банк автоматически подписывает документы. Например для выписок"
 * (Константин Волченко)
 *
 * @author Pavel Sergeyev
 */
class BankKeySteps(user: User) :
    AbstractDictionarySteps<BankKeyDto, BankKeyDto>(
        user = user,
        service = Services.CRYPTO,
        entity = BankKeyDto::class.java,
        dictionaryName = CryptoNames.BANK_KEY
    )