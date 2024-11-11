package ooo.jtc.api.common.steps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B-\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ1\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00010\u001a\"\u0004\b\u0002\u0010\u0001\"\u000e\b\u0003\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u00010\u001c2\u0006\u0010\n\u001a\u0002H\u0001H\u0016\u00a2\u0006\u0002\u0010\u001dR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\r8TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Looo/jtc/api/common/steps/AbstractDictionarySteps;", "T", "Looo/jtc/interfaces/IEntityDto;", "U", "Looo/jtc/interfaces/UpdateIEntityDto;", "Looo/jtc/api/common/steps/AbstractEntitySteps;", "user", "Looo/jtc/uaa/User;", "service", "Looo/jtc/testdata/Service;", "entity", "Ljava/lang/Class;", "dictionaryName", "", "(Looo/jtc/uaa/User;Looo/jtc/testdata/Service;Ljava/lang/Class;Ljava/lang/String;)V", "getDictionaryName", "()Ljava/lang/String;", "getEntity", "()Ljava/lang/Class;", "setEntity", "(Ljava/lang/Class;)V", "servicePath", "getServicePath", "servicePath$delegate", "Lkotlin/Lazy;", "requestDtoWrapper", "Looo/jtc/generic/DictionaryWrapperDto;", "R", "Looo/jtc/generic/GenericDto;", "(Ljava/lang/Object;)Looo/jtc/generic/DictionaryWrapperDto;", "box-tests"})
public abstract class AbstractDictionarySteps<T extends ooo.jtc.interfaces.IEntityDto, U extends ooo.jtc.interfaces.UpdateIEntityDto<T>> extends ooo.jtc.api.common.steps.AbstractEntitySteps<T, U> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy servicePath$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.Class<T> entity;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String dictionaryName = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public <T extends java.lang.Object, R extends ooo.jtc.generic.GenericDto<T>>ooo.jtc.generic.DictionaryWrapperDto<T> requestDtoWrapper(T entity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.lang.String getServicePath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Class<T> getEntity() {
        return null;
    }
    
    public final void setEntity(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDictionaryName() {
        return null;
    }
    
    public AbstractDictionarySteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.testdata.Service service, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> entity, @org.jetbrains.annotations.NotNull()
    java.lang.String dictionaryName) {
        super(null, null, null);
    }
}