package ooo.jtc.testdata.common;

import java.lang.System;

/**
 * Abstract class to load from testDataProvider as [TestDataProvider] store test data
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020\tH\u0016\u00a2\u0006\u0002\u0010@J\b\u0010A\u001a\u00020$H\u0007J+\u0010B\u001a\u00028\u00002\b\b\u0002\u0010?\u001a\u00020\t2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a2\u0006\u0002\u0010DJ>\u0010E\u001a\b\u0012\u0004\u0012\u0002HG0F\"\u0004\b\u0001\u0010G2\b\b\u0002\u0010H\u001a\u00020I2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HG0\b2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HG0\u000fJ)\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000 2\b\b\u0002\u0010?\u001a\u00020\t2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010NJ=\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000 2\b\b\u0002\u0010?\u001a\u00020\t2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\t2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bH\u0017\u00a2\u0006\u0002\u0010OJ\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010Q\u001a\u00020RH\u0002J\u000e\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0003J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0003J$\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0 2\b\b\u0002\u0010H\u001a\u00020V2\b\b\u0002\u0010?\u001a\u00020\tH\u0016J\u0015\u0010W\u001a\u00020\t2\u0006\u0010X\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010YJ%\u0010Z\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010?\u001a\u00020\t2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010[J#\u0010\\\u001a\u00028\u00002\b\b\u0002\u0010?\u001a\u00020\t2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\tH\u0017\u00a2\u0006\u0002\u0010[J\u0016\u0010]\u001a\u00020$2\u0006\u0010^\u001a\u00020R2\u0006\u0010_\u001a\u00020RJJ\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000a2\b\b\u0002\u0010?\u001a\u00020\t2\b\b\u0002\u0010b\u001a\u00020I2\u0014\b\u0002\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b2\u0010\b\u0002\u0010d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fH\u0017R$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R)\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00018\u00008\u00000\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u001b\u001a\u00020\u001cX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030!0 0\u000fX\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u0011R&\u0010#\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 \u0012\u0004\u0012\u00020$0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u000bR8\u0010&\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030!0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R(\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$\u0018\u00010\bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000b\"\u0004\b2\u0010\rR\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010\u001a\u001a\u0004\b5\u00106R\u0014\u00108\u001a\u00020\u001cX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001eR(\u0010:\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030;\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006e"}, d2 = {"Looo/jtc/testdata/common/TestData;", "E", "Looo/jtc/interfaces/IEntity;", "", "entityClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "atMarkerPredicate", "Lkotlin/Function1;", "", "getAtMarkerPredicate", "()Lkotlin/jvm/functions/Function1;", "setAtMarkerPredicate", "(Lkotlin/jvm/functions/Function1;)V", "createRecord", "Lkotlin/Function0;", "getCreateRecord", "()Lkotlin/jvm/functions/Function0;", "setCreateRecord", "(Lkotlin/jvm/functions/Function0;)V", "data", "Ljava/util/concurrent/CopyOnWriteArrayList;", "kotlin.jvm.PlatformType", "getData", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "data$delegate", "Lkotlin/Lazy;", "dataFileName", "", "getDataFileName", "()Ljava/lang/String;", "dbDataConsumer", "", "", "getDbDataConsumer", "dbDataProvider", "", "getDbDataProvider", "dbResultPostProcessor", "getDbResultPostProcessor", "getEntityClass", "()Ljava/lang/Class;", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "removeRecord", "getRemoveRecord", "setRemoveRecord", "testDataFile", "Ljava/io/File;", "getTestDataFile", "()Ljava/io/File;", "testDataFile$delegate", "testDataName", "getTestDataName", "transform", "", "byId", "id", "Ljava/util/UUID;", "fromCache", "(Ljava/util/UUID;Z)Looo/jtc/interfaces/IEntity;", "cleanAtCreated", "find", "predicate", "(ZLkotlin/jvm/functions/Function1;)Looo/jtc/interfaces/IEntity;", "generateUniqueValues", "Ljava/util/concurrent/BlockingQueue;", "R", "size", "", "consume", "generate", "get", "seekAtCreated", "(ZLjava/lang/Boolean;)Ljava/util/List;", "(ZLjava/lang/Boolean;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "getFrom", "source", "Looo/jtc/testdata/common/TestDataSource;", "getFromDatabase", "getFromFile", "getRandomIds", "", "isRequiredFieldsNonNull", "model", "(Looo/jtc/interfaces/IEntity;)Z", "random", "(ZLjava/lang/Boolean;)Looo/jtc/interfaces/IEntity;", "randomOrException", "transfer", "from", "to", "withRequiredFields", "Looo/jtc/testdata/common/TestDataScope;", "requiredDataCount", "additionalFilter", "customCreator", "box-tests"})
public abstract class TestData<E extends ooo.jtc.interfaces.IEntity> {
    private final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String testDataName = null;
    
    /**
     * Uses in [withRequiredFields] for create test data record in specific service.
     */
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<? extends E> createRecord;
    
    /**
     * Uses in [TestDataScope.removeGenerated] for remove test data record generated in [withRequiredFields].
     */
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super E, kotlin.Unit> removeRecord;
    
    /**
     * Function to update test data, that consume from DB
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, java.lang.Object>, java.util.Map<java.lang.String, java.lang.Object>> dbResultPostProcessor = null;
    
    /**
     * Function to load test data in DB
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.util.List<? extends E>, kotlin.Unit> dbDataProvider = null;
    
    /**
     * Create file for test data if it doesn't exist
     */
    private final kotlin.Lazy testDataFile$delegate = null;
    
    /**
     * Transform mapping from source data to model object [E].
     */
    private final kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, ? extends java.lang.Object>, E> transform = null;
    
    /**
     * Test data, that loaded from testDataProvider and deserialize into List of entity
     */
    private final kotlin.Lazy data$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Class<E> entityClass = null;
    
    private final org.slf4j.Logger getLog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.lang.String getTestDataName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.jvm.functions.Function1<E, java.lang.Boolean> getAtMarkerPredicate();
    
    public abstract void setAtMarkerPredicate(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> p0);
    
    @org.jetbrains.annotations.Nullable()
    public kotlin.jvm.functions.Function0<E> getCreateRecord() {
        return null;
    }
    
    public void setCreateRecord(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends E> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public kotlin.jvm.functions.Function1<E, kotlin.Unit> getRemoveRecord() {
        return null;
    }
    
    public void setRemoveRecord(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super E, kotlin.Unit> p0) {
    }
    
    /**
     * Function to consume test data from Database
     */
    @org.jetbrains.annotations.NotNull()
    protected abstract kotlin.jvm.functions.Function0<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> getDbDataConsumer();
    
    @org.jetbrains.annotations.NotNull()
    public kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, java.lang.Object>, java.util.Map<java.lang.String, java.lang.Object>> getDbResultPostProcessor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public kotlin.jvm.functions.Function1<java.util.List<? extends E>, kotlin.Unit> getDbDataProvider() {
        return null;
    }
    
    /**
     * File name with test data
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDataFileName();
    
    /**
     * Get list of test data
     */
    @org.jetbrains.annotations.NotNull()
    public java.util.List<E> get(boolean fromCache, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean seekAtCreated) {
        return null;
    }
    
    /**
     * Get list of test data by [predicate]
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u0432 {this.testDataName} \u0434\u0430\u043d\u043d\u044b\u0435 \u043f\u043e \u043f\u0440\u0435\u0434\u0438\u043a\u0430\u0442\u0443")
    public java.util.List<E> get(boolean fromCache, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean seekAtCreated, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> predicate) {
        return null;
    }
    
    /**
     * Find entity by id
     */
    @org.jetbrains.annotations.NotNull()
    public E byId(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, boolean fromCache) {
        return null;
    }
    
    /**
     * Get random entity from test data.
     */
    @org.jetbrains.annotations.Nullable()
    public E random(boolean fromCache, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean seekAtCreated) {
        return null;
    }
    
    /**
     * Get random entity from test data.
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u0432 {this.testDataName} \u0441\u043b\u0443\u0447\u0430\u0439\u043d\u044b\u0435 \u0434\u0430\u043d\u043d\u044b\u0435")
    public E randomOrException(boolean fromCache, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean seekAtCreated) {
        return null;
    }
    
    /**
     * Get random size list of random ids.
     * By default size of list is random,
     * but you can explicitly set [size] of list.
     */
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.util.UUID> getRandomIds(int size, boolean fromCache) {
        return null;
    }
    
    /**
     * Get first element of test data by [predicate]
     */
    @org.jetbrains.annotations.NotNull()
    public E find(boolean fromCache, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> predicate) {
        return null;
    }
    
    /**
     * Generate random fields with checking in TestData.
     * @param size - random data size
     * @param consume - function for consuming field value from TestData
     * @param generate - function for generate random field value.
     */
    @org.jetbrains.annotations.NotNull()
    public final <R extends java.lang.Object>java.util.concurrent.BlockingQueue<R> generateUniqueValues(long size, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super E, ? extends R> consume, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends R> generate) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0432\u0441\u0435 \u0441\u043e\u0437\u0434\u0430\u043d\u044b\u0435 \u0410\u0422 \u0437\u0430\u043f\u0438\u0441\u0438 \u0434\u043b\u044f {this.testDataName}")
    public final void cleanAtCreated() {
    }
    
    /**
     * Returned tesData with required for test not null fields.
     * To use this function it's necessary to override [createRecord] function in specific testData.
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u043a\u0430 \u0434\u0430\u043d\u043d\u044b\u0445 \u0441 \u043e\u0431\u044f\u0437\u0430\u0442\u0435\u043b\u044c\u043d\u044b\u043c\u0438 \u0434\u043b\u044f \u0442\u0435\u0441\u0442\u043e\u0432 \u043f\u043e\u043b\u044f\u043c\u0438")
    public ooo.jtc.testdata.common.TestDataScope<E> withRequiredFields(boolean fromCache, long requiredDataCount, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> additionalFilter, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends E> customCreator) {
        return null;
    }
    
    private final boolean isRequiredFieldsNonNull(E model) {
        return false;
    }
    
    /**
     * Copy [TestData] from one [TestDataSource] to another.
     * e.g. from Db to File.
     */
    public final void transfer(@org.jetbrains.annotations.NotNull()
    ooo.jtc.testdata.common.TestDataSource from, @org.jetbrains.annotations.NotNull()
    ooo.jtc.testdata.common.TestDataSource to) {
    }
    
    private final java.util.List<E> getFrom(ooo.jtc.testdata.common.TestDataSource source) {
        return null;
    }
    
    /**
     * Get test data from DB
     */
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0430\u0435\u043c \u0442\u0435\u0441\u0442\u043e\u0432\u044b\u0435 \u0434\u0430\u043d\u043d\u044b\u0435 \u0438\u0437 \u0411\u0414 \u0434\u043b\u044f {this.testDataName}")
    private final java.util.List<E> getFromDatabase() {
        return null;
    }
    
    /**
     * Get test data from file
     */
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0430\u0435\u043c \u0442\u0435\u0441\u0442\u043e\u0432\u044b\u0435 \u0434\u0430\u043d\u043d\u044b\u0435 \u0438\u0437 \u0444\u0430\u0439\u043b\u0430 \u0434\u043b\u044f {this.testDataName}")
    private final java.util.List<E> getFromFile() {
        return null;
    }
    
    /**
     * Create file for test data if it doesn't exist
     */
    private final java.io.File getTestDataFile() {
        return null;
    }
    
    /**
     * Test data, that loaded from testDataProvider and deserialize into List of entity
     */
    private final java.util.concurrent.CopyOnWriteArrayList<E> getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Class<E> getEntityClass() {
        return null;
    }
    
    public TestData(@org.jetbrains.annotations.NotNull()
    java.lang.Class<E> entityClass) {
        super();
    }
}