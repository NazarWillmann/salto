package ooo.jtc.api.dictionaries.country;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J,\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u0019R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007\u00a8\u0006\u001c"}, d2 = {"Looo/jtc/api/dictionaries/country/CountryPrepareSteps;", "", "()V", "alpha2Codes", "Ljava/util/concurrent/BlockingQueue;", "", "getAlpha2Codes", "()Ljava/util/concurrent/BlockingQueue;", "alpha2Codes$delegate", "Lkotlin/Lazy;", "alpha3Codes", "getAlpha3Codes", "alpha3Codes$delegate", "digitCodes", "getDigitCodes", "digitCodes$delegate", "cleanAtCreated", "", "getCountryDtoForCreate", "Looo/jtc/dictionaries/country/CountryDto;", "getCountryDtoForUpdate", "createdDto", "retrieveUsedCodes", "countryDto", "retrieveAlpha2Code", "", "retrieveAlpha3Code", "retrieveDigitCode", "box-tests"})
public final class CountryPrepareSteps {
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy alpha2Codes$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy alpha3Codes$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy digitCodes$delegate = null;
    public static final ooo.jtc.api.dictionaries.country.CountryPrepareSteps INSTANCE = null;
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043e\u0437\u0434\u0430\u043d\u043d\u044b\u0435 \u0430\u0432\u0442\u043e\u0442\u0435\u0441\u0442\u0430\u043c\u0438 \u0434\u0430\u043d\u043d\u044b\u0435 Country \u0438\u0437 \u0411\u0414")
    public final void cleanAtCreated() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.concurrent.BlockingQueue<java.lang.String> getAlpha2Codes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.concurrent.BlockingQueue<java.lang.String> getAlpha3Codes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.concurrent.BlockingQueue<java.lang.String> getDigitCodes() {
        return null;
    }
    
    public final void retrieveUsedCodes(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.country.CountryDto countryDto, boolean retrieveAlpha2Code, boolean retrieveAlpha3Code, boolean retrieveDigitCode) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.country.CountryDto getCountryDtoForCreate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.country.CountryDto getCountryDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.country.CountryDto createdDto) {
        return null;
    }
    
    private CountryPrepareSteps() {
        super();
    }
}