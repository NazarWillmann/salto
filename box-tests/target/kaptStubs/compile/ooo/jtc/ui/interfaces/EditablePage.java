package ooo.jtc.ui.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Looo/jtc/ui/interfaces/EditablePage;", "V", "Looo/jtc/interfaces/IEntityView;", "", "checkFieldsEditable", "", "view", "(Looo/jtc/interfaces/IEntityView;)V", "box-tests"})
public abstract interface EditablePage<V extends ooo.jtc.interfaces.IEntityView> {
    
    /**
     * Проверить, что поля на форме редактируемые.
     */
    public abstract void checkFieldsEditable(@org.jetbrains.annotations.NotNull()
    V view);
}