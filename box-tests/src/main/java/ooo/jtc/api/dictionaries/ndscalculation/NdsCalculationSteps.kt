package ooo.jtc.api.dictionaries.ndscalculation

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.ndscalculation.NdsCalculationDto
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User

class NdsCalculationSteps(user: User) :
    AbstractDictionarySteps<NdsCalculationDto, NdsCalculationDto>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = NdsCalculationDto::class.java,
        dictionaryName = "ndsCalculation"
    )