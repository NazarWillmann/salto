package ooo.jtc.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Looo/jtc/interfaces/Identifiable;", "", "id", "Ljava/util/UUID;", "getId", "()Ljava/util/UUID;", "setId", "(Ljava/util/UUID;)V", "version", "", "getVersion", "()I", "setVersion", "(I)V", "datamodels"})
public abstract interface Identifiable {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.util.UUID getId();
    
    public abstract void setId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0);
    
    public abstract int getVersion();
    
    public abstract void setVersion(int p0);
}