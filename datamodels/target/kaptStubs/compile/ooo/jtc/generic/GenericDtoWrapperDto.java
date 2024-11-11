package ooo.jtc.generic;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Looo/jtc/generic/GenericDtoWrapperDto;", "T", "", "dto", "(Ljava/lang/Object;)V", "getDto", "()Ljava/lang/Object;", "Ljava/lang/Object;", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public final class GenericDtoWrapperDto<T extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable()
    private final T dto = null;
    
    @org.jetbrains.annotations.Nullable()
    public final T getDto() {
        return null;
    }
    
    public GenericDtoWrapperDto(@org.jetbrains.annotations.Nullable()
    T dto) {
        super();
    }
}