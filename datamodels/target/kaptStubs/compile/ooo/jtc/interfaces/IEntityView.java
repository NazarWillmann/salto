package ooo.jtc.interfaces;

import java.lang.System;

/**
 * Entity's representation on user interface.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Looo/jtc/interfaces/IEntityView;", "", "searchField", "", "getSearchField", "()Ljava/lang/String;", "datamodels"})
public abstract interface IEntityView {
    
    /**
     * Field for searching view on scroller.
     * Field must be a visible on scroller.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getSearchField();
}