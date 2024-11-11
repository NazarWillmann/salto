package ooo.jtc.api.dictionaries.individual;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JN\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a8\u0006\u0016"}, d2 = {"Looo/jtc/api/dictionaries/individual/IndividualPrepareSteps;", "", "()V", "createIndividualDto", "Looo/jtc/dictionaries/individual/IndividualDto;", "bankCreatorUser", "Looo/jtc/uaa/User;", "personUser", "forUi", "", "individualForCreate", "withLocAddress", "withRegAddress", "prepareAddress", "Lkotlin/Function0;", "Looo/jtc/dictionaries/common/address/AddressDto;", "getIdentityDocumentDto", "Looo/jtc/dictionaries/identitydocument/IdentityDocumentDto;", "getIndividualDtoForCreate", "isBlock", "getPersonalInfoDto", "Looo/jtc/dictionaries/person/PersonalInfoDto;", "box-tests"})
public final class IndividualPrepareSteps {
    public static final ooo.jtc.api.dictionaries.individual.IndividualPrepareSteps INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.individual.IndividualDto getIndividualDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User personUser, boolean isBlock) {
        return null;
    }
    
    private final ooo.jtc.dictionaries.identitydocument.IdentityDocumentDto getIdentityDocumentDto() {
        return null;
    }
    
    private final ooo.jtc.dictionaries.person.PersonalInfoDto getPersonalInfoDto(ooo.jtc.uaa.User personUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.individual.IndividualDto createIndividualDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User bankCreatorUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User personUser, boolean forUi, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.individual.IndividualDto individualForCreate, boolean withLocAddress, boolean withRegAddress, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.dictionaries.common.address.AddressDto> prepareAddress) {
        return null;
    }
    
    private IndividualPrepareSteps() {
        super();
    }
}