package ooo.jtc.api.dictionaries.ndspercent

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.ndspercent.NdsPercentDto
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User

class NdsPercentSteps(user: User) :
    AbstractDictionarySteps<NdsPercentDto, NdsPercentDto>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = NdsPercentDto::class.java,
        dictionaryName = "ndsPercent"
    )