package ooo.jtc.api.dictionaries.incometype;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0018\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000bJ\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004J\u001f\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\u0006\u0010\u0019\u001a\u00020\u000bR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Looo/jtc/api/dictionaries/incometype/IncomeTypePrepareSteps;", "", "()V", "allowedChars", "Looo/jtc/random/RandomData;", "getAllowedChars", "()Looo/jtc/random/RandomData;", "allowedChars$delegate", "Lkotlin/Lazy;", "validCodes", "Ljava/util/SortedSet;", "", "addValidCode", "", "code", "generateWithPrefix", "", "generator", "length", "getIncomeTypeDtoForCreate", "Looo/jtc/dictionaries/incometype/IncomeTypeDto;", "textFieldGenerator", "(Looo/jtc/random/RandomData;Ljava/lang/Integer;)Looo/jtc/dictionaries/incometype/IncomeTypeDto;", "getIncomeTypeDtoForUpdate", "createdDto", "getValidCode", "box-tests"})
public final class IncomeTypePrepareSteps {
    private static java.util.SortedSet<java.lang.Integer> validCodes;
    private static final kotlin.Lazy allowedChars$delegate = null;
    public static final ooo.jtc.api.dictionaries.incometype.IncomeTypePrepareSteps INSTANCE = null;
    
    public final int getValidCode() {
        return 0;
    }
    
    public final void addValidCode(int code) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.incometype.IncomeTypeDto getIncomeTypeDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.random.RandomData textFieldGenerator) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.incometype.IncomeTypeDto getIncomeTypeDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.random.RandomData textFieldGenerator, @org.jetbrains.annotations.Nullable()
    java.lang.Integer code) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.incometype.IncomeTypeDto getIncomeTypeDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.incometype.IncomeTypeDto createdDto) {
        return null;
    }
    
    private final ooo.jtc.random.RandomData getAllowedChars() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String generateWithPrefix(@org.jetbrains.annotations.NotNull()
    ooo.jtc.random.RandomData generator, int length) {
        return null;
    }
    
    private IncomeTypePrepareSteps() {
        super();
    }
}