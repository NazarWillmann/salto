package ooo.jtc.ui.common.pages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\n\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u0014"}, d2 = {"Looo/jtc/ui/common/pages/DictionaryCreatePage;", "V", "Looo/jtc/interfaces/IEntityView;", "Looo/jtc/ui/common/pages/ApplicationPage;", "Looo/jtc/ui/interfaces/CreatePage;", "endpoint", "", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Ljava/lang/String;Lcom/codeborne/selenide/SelenideElement;)V", "back", "Looo/jtc/core/elements/Button;", "getBack", "()Looo/jtc/core/elements/Button;", "decline", "getDecline", "save", "getSave", "waitLoading", "", "box-tests"})
public abstract class DictionaryCreatePage<V extends ooo.jtc.interfaces.IEntityView> extends ooo.jtc.ui.common.pages.ApplicationPage implements ooo.jtc.ui.interfaces.CreatePage<V> {
    
    @java.lang.Override()
    public void waitLoading() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getSave() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getDecline() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getBack() {
        return null;
    }
    
    public DictionaryCreatePage(@org.jetbrains.annotations.NotNull()
    java.lang.String endpoint, @org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null, null);
    }
}