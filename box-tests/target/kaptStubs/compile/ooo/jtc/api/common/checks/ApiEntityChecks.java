package ooo.jtc.api.common.checks;

import java.lang.System;

/**
 * Base asserts than can be applied for Entity
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 e*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001eB\u0005\u00a2\u0006\u0002\u0010\u0004J]\u0010\u0010\u001a\u00020\u0011\"\b\b\u0001\u0010\u0001*\u00020\u0002\"\u0004\b\u0002\u0010\u00122\u0006\u0010\u0013\u001a\u0002H\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00152\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00170\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0002\u00a2\u0006\u0002\u0010\u001bJ*\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0007H\u0007J#\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00028\u00002\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0007\u00a2\u0006\u0002\u0010$J\u001e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\'2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0007J(\u0010(\u001a\u00020\u001d2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\b\b\u0002\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\bH\u0007J>\u0010-\u001a\u00020\u001d\"\u000e\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00152\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010/\u001a\u0002002\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001202H\u0007J\u0016\u00103\u001a\u0002042\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0007J\u001a\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000107H\u0007J\u001a\u00109\u001a\u00020\u001d2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000107H\u0007J\u0016\u0010:\u001a\u00020\u001d2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0007JG\u0010;\u001a\u00020\u0011\"\u000e\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u0012022\b\b\u0002\u0010\u001a\u001a\u00020\u0011H\u0003\u00a2\u0006\u0002\u0010<J=\u0010=\u001a\u00020\u001d\"\u000e\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010>\u001a\u00020?2\u000e\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001202H\u0007\u00a2\u0006\u0002\u0010@J\u0016\u0010A\u001a\u00020\u001d2\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000CH\u0007J4\u0010D\u001a\u00020\u001d2\f\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010G\u001a\u00020+2\u0006\u0010H\u001a\u00020+H\u0007J*\u0010I\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0007H\u0007J#\u0010J\u001a\u00020\u001d2\u0006\u0010K\u001a\u00028\u00002\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0007\u00a2\u0006\u0002\u0010$J-\u0010M\u001a\u00020\u001d2\u0006\u0010N\u001a\u00028\u00002\f\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\b\b\u0002\u0010P\u001a\u00020QH\u0007\u00a2\u0006\u0002\u0010RJ&\u0010S\u001a\u00020\u001d2\u0006\u0010T\u001a\u00020U2\u000e\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00062\u0006\u0010W\u001a\u00020XJD\u0010Y\u001a\u00020\u001d\"\u000e\b\u0001\u0010Z*\b\u0012\u0004\u0012\u00028\u00000[2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\\\u001a\u0002002\f\u0010]\u001a\b\u0012\u0004\u0012\u0002HZ022\u0006\u0010W\u001a\u00020XH\u0007J#\u0010^\u001a\u00020\u001d2\u0006\u0010K\u001a\u00028\u00002\f\u0010_\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0007\u00a2\u0006\u0002\u0010$J\u0010\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\bH\u0002J\u0014\u0010b\u001a\u0004\u0018\u00010\b2\b\u0010a\u001a\u0004\u0018\u00010\bH\u0002J0\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010T\u001a\u00020U2\u000e\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010W\u001a\u00020XH\u0002R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR$\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006f"}, d2 = {"Looo/jtc/api/common/checks/ApiEntityChecks;", "T", "Looo/jtc/interfaces/IEntityDto;", "", "()V", "filtrationStringTransform", "", "Lkotlin/Function1;", "", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "sortStringTransform", "check", "", "R", "entity", "fieldGetter", "Looo/jtc/api/common/filter/IFilterParams;", "matcherProvider", "Lorg/hamcrest/Matcher;", "operand", "Looo/jtc/generic/pageparams/Operand;", "softAssert", "(Looo/jtc/interfaces/IEntityDto;Looo/jtc/api/common/filter/IFilterParams;Lkotlin/jvm/functions/Function1;Looo/jtc/generic/pageparams/Operand;Z)Z", "checkAddFavorites", "", "responseDto", "Looo/jtc/generic/GenericResponseDto;", "retrieveIsFavorites", "checkConsumeEntity", "expDto", "genericResponse", "(Looo/jtc/interfaces/IEntityDto;Looo/jtc/generic/GenericResponseDto;)V", "checkControl", "expCheckResult", "Looo/jtc/generic/CheckResult;", "checkErrorResponse", "response", "expectedCode", "", "expectedMessage", "checkFilter", "entities", "getPageRequest", "Looo/jtc/generic/pageparams/GetPageRequest;", "filterParamsClass", "Ljava/lang/Class;", "checkIdExist", "Ljava/util/UUID;", "checkNestedControl", "expValidationResult", "Looo/jtc/generic/ValidationResultDto;", "actValidationResult", "checkNestedDictionaryControl", "checkNotFound", "checkOperand", "(Looo/jtc/interfaces/IEntityDto;Looo/jtc/generic/pageparams/Operand;Ljava/lang/Class;Z)Z", "checkOperands", "filterData", "Looo/jtc/generic/pageparams/FilterData;", "(Looo/jtc/interfaces/IEntityDto;Looo/jtc/generic/pageparams/FilterData;Ljava/lang/Class;)V", "checkPageResponse", "pageResponse", "Looo/jtc/generic/GenericPageResponseDto;", "checkPagination", "expAllList", "actPagingList", "offset", "limit", "checkRemoveFromFavorites", "checkRemoved", "preparedDto", "deletedResponse", "checkRequestResponseValid", "expectedEntity", "actualResponse", "expResult", "Looo/jtc/documents/ControlCheckResult;", "(Looo/jtc/interfaces/IEntityDto;Looo/jtc/generic/GenericResponseDto;Looo/jtc/documents/ControlCheckResult;)V", "checkSortList", "dir", "Looo/jtc/generic/pageparams/Direction;", "actualValues", "dbExecutor", "Looo/jtc/db/DbExecutorJdbi;", "checkSorting", "F", "Looo/jtc/api/common/sorting/ISortingParams;", "pageRequest", "clazz", "checkUpdated", "updatedResponse", "filtrationStringHandling", "expectValue", "sortStringHandling", "sortUsingPsotgreSql", "values", "Companion", "box-tests"})
public class ApiEntityChecks<T extends ooo.jtc.interfaces.IEntityDto> {
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    
    /**
     * List of transform functions for sorting string.
     */
    private final java.util.List<kotlin.jvm.functions.Function1<java.lang.String, java.lang.String>> sortStringTransform = null;
    private final java.util.List<kotlin.jvm.functions.Function1<java.lang.String, java.lang.String>> filtrationStringTransform = null;
    private static final java.lang.String POSTGRES_IGNORE_SYMBOLS = "[ \\\\.:;\'`,\\-()_/#+=\\[\\]?@<>\u00ab^\u00bb\u25a0\u263a\u263b\u2663\u25d8\u2022\u25cb]";
    public static final ooo.jtc.api.common.checks.ApiEntityChecks.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    protected final org.slf4j.Logger getLog() {
        return null;
    }
    
    /**
     * Check that received from service list of [entities] are filtered correctly.
     */
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c \u0444\u0438\u043b\u044c\u0442\u0440\u0430\u0446\u0438\u044e \u0432 \u043e\u0442\u0432\u0435\u0442\u0435")
    public final <R extends ooo.jtc.api.common.filter.IFilterParams<T>>void checkFilter(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> entities, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.GetPageRequest getPageRequest, @org.jetbrains.annotations.NotNull()
    java.lang.Class<? extends R> filterParamsClass) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \u0437\u0430\u043f\u0438\u0441\u044c \u0441 id = \'{entity.id}\' \u0443\u0434\u043e\u0432\u043b\u0435\u0442\u0432\u043e\u0440\u044f\u0435\u0442 \u0443\u0441\u043b\u043e\u0432\u0438\u044f\u043c \u0444\u0438\u043b\u044c\u0442\u0440\u0430\u0446\u0438\u0438")
    public final <R extends ooo.jtc.api.common.filter.IFilterParams<T>>void checkOperands(@org.jetbrains.annotations.NotNull()
    T entity, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.FilterData filterData, @org.jetbrains.annotations.NotNull()
    java.lang.Class<? extends R> filterParamsClass) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \u0437\u0430\u043f\u0438\u0441\u044c \u0441 id = \'{entity.id}\'  {operand.predicate}  \'{operand.value}\'")
    private final <R extends ooo.jtc.api.common.filter.IFilterParams<T>>boolean checkOperand(T entity, ooo.jtc.generic.pageparams.Operand operand, java.lang.Class<? extends R> filterParamsClass, boolean softAssert) {
        return false;
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    private final <T extends ooo.jtc.interfaces.IEntityDto, R extends java.lang.Object>boolean check(T entity, ooo.jtc.api.common.filter.IFilterParams<T> fieldGetter, kotlin.jvm.functions.Function1<? super R, ? extends org.hamcrest.Matcher<R>> matcherProvider, ooo.jtc.generic.pageparams.Operand operand, boolean softAssert) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \u0432 \u0437\u0430\u043f\u0438\u0441\u0438 \u0435\u0441\u0442\u044c id")
    public final java.util.UUID checkIdExist(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.GenericResponseDto<T> response) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u044c \u0443\u0441\u043f\u0435\u0448\u043d\u043e \u0441\u043e\u0437\u0434\u0430\u043d\u0430/\u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0430")
    public final void checkRequestResponseValid(@org.jetbrains.annotations.NotNull()
    T expectedEntity, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.GenericResponseDto<T> actualResponse, @org.jetbrains.annotations.NotNull()
    ooo.jtc.documents.ControlCheckResult expResult) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u044c \u0443\u0441\u043f\u0435\u0448\u043d\u043e \u0443\u0434\u0430\u043b\u0435\u043d\u0430")
    public final void checkRemoved(@org.jetbrains.annotations.NotNull()
    T preparedDto, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.GenericResponseDto<T> deletedResponse) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u044c \u0443\u0441\u043f\u0435\u0448\u043d\u043e \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0430")
    public final void checkUpdated(@org.jetbrains.annotations.NotNull()
    T preparedDto, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.GenericResponseDto<T> updatedResponse) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \u0441\u043f\u0438\u0441\u043e\u043a \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439 \u043e\u0442\u0441\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u043d")
    public final <F extends ooo.jtc.api.common.sorting.ISortingParams<T>>void checkSorting(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> entities, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.GetPageRequest pageRequest, @org.jetbrains.annotations.NotNull()
    java.lang.Class<F> clazz, @org.jetbrains.annotations.NotNull()
    ooo.jtc.db.DbExecutorJdbi dbExecutor) {
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public final void checkSortList(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.Direction dir, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> actualValues, @org.jetbrains.annotations.NotNull()
    ooo.jtc.db.DbExecutorJdbi dbExecutor) {
    }
    
    private final java.util.List<java.lang.String> sortUsingPsotgreSql(ooo.jtc.generic.pageparams.Direction dir, java.util.List<java.lang.String> values, ooo.jtc.db.DbExecutorJdbi dbExecutor) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u044c \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u0430")
    public final void checkConsumeEntity(@org.jetbrains.annotations.NotNull()
    T expDto, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.GenericResponseDto<T> genericResponse) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u044c \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u0430")
    public final void checkNotFound(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.GenericResponseDto<T> response) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \u043f\u0440\u043e\u0438\u0437\u043e\u0448\u043b\u0430 \u043e\u0448\u0438\u0431\u043a\u0430")
    public final void checkErrorResponse(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.GenericResponseDto<T> response, int expectedCode, @org.jetbrains.annotations.NotNull()
    java.lang.String expectedMessage) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c \u0441\u043f\u0438\u0441\u043e\u043a \u0437\u0430\u043f\u0438\u0441\u0435\u0439 \u0438\u0437 \u043e\u0442\u0432\u0435\u0442\u0430")
    public final void checkPageResponse(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.GenericPageResponseDto<T> pageResponse) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u044c \u043d\u0430 \u043f\u043e\u043b\u0435 {expCheckResult.fieldName}")
    public final void checkControl(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.CheckResult expCheckResult, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.GenericResponseDto<T> responseDto) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u0441\u0440\u0430\u0431\u043e\u0442\u0430\u0432\u0448\u0438\u0439 \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u044c \u0441\u043e\u0433\u043b\u0430\u0441\u043d\u043e \u0438\u0435\u0440\u0430\u0440\u0445\u0438\u0438 \u0432\u043b\u043e\u0436\u0435\u043d\u043d\u043e\u0441\u0442\u0438")
    public final void checkNestedControl(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.ValidationResultDto expValidationResult, @org.jetbrains.annotations.Nullable()
    ooo.jtc.generic.ValidationResultDto actValidationResult) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u0441\u0440\u0430\u0431\u043e\u0442\u0430\u0432\u0448\u0438\u0439 \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u044c \u0441\u043f\u0440\u0430\u0432\u043e\u0447\u043d\u0438\u043a\u0430 \u0441\u043e\u0433\u043b\u0430\u0441\u043d\u043e \u0438\u0435\u0440\u0430\u0440\u0445\u0438\u0438 \u0432\u043b\u043e\u0436\u0435\u043d\u043d\u043e\u0441\u0442\u0438")
    public final void checkNestedDictionaryControl(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.ValidationResultDto expValidationResult, @org.jetbrains.annotations.Nullable()
    ooo.jtc.generic.ValidationResultDto actValidationResult) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u043e\u0441\u0442\u044c \u043f\u0430\u0433\u0438\u043d\u0430\u0446\u0438\u0438")
    public final void checkPagination(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> expAllList, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> actPagingList, int offset, int limit) {
    }
    
    /**
     * Handling for string in sorting checks.
     */
    private final java.lang.String sortStringHandling(java.lang.String expectValue) {
        return null;
    }
    
    /**
     * Handling for string in filtration checks.
     */
    private final java.lang.String filtrationStringHandling(java.lang.String expectValue) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \u0434\u043e\u0431\u0430\u0432\u043b\u0435\u043d \u0432 \u0438\u0437\u0431\u0440\u0430\u043d\u043d\u043e\u0435")
    public final void checkAddFavorites(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.GenericResponseDto<T> responseDto, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> retrieveIsFavorites) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \u0443\u0434\u0430\u043b\u0435\u043d \u0438\u0437 \u0438\u0437\u0431\u0440\u0430\u043d\u043d\u043e\u0433\u043e")
    public final void checkRemoveFromFavorites(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.GenericResponseDto<T> responseDto, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> retrieveIsFavorites) {
    }
    
    public ApiEntityChecks() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Looo/jtc/api/common/checks/ApiEntityChecks$Companion;", "", "()V", "POSTGRES_IGNORE_SYMBOLS", "", "box-tests"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}