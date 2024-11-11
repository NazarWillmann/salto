package ooo.jtc.ui.pages.documents.lettertobank.form;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00030\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00000\u0006:\u0001JB\r\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0007J8\u0010/\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020(H\u0007J\b\u00108\u001a\u00020,H\u0007J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\u0003H\u0017J\u0010\u0010;\u001a\u00020,2\u0006\u0010:\u001a\u00020\u0003H\u0017J\b\u0010<\u001a\u00020,H\u0017J\u0010\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020?H\u0007J\u0018\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u0002012\u0006\u0010:\u001a\u00020\u0003H\u0007J\u0010\u0010B\u001a\u00020,2\u0006\u0010:\u001a\u00020\u0003H\u0007J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020(H\u0007J\u0010\u0010F\u001a\u00020,2\u0006\u0010:\u001a\u00020\u0003H\u0017J\u0010\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020IH\u0007R\u0011\u0010\n\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u001f\u001a\u00020 8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u001aR\u0011\u0010%\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0016R\u0014\u0010\'\u001a\u00020(X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*\u00a8\u0006K"}, d2 = {"Looo/jtc/ui/pages/documents/lettertobank/form/LetterToBankFormBasicRequisitesTab;", "Looo/jtc/ui/pages/documents/lettertobank/form/LetterToBankFormPage;", "Looo/jtc/ui/interfaces/CreatePage;", "Looo/jtc/letters/LetterToBankView;", "Looo/jtc/ui/interfaces/EditablePage;", "Looo/jtc/ui/interfaces/ViewPage;", "Looo/jtc/ui/common/sections/tabs/TabSection;", "pageType", "Looo/jtc/ui/common/pages/ApplicationPageType;", "(Looo/jtc/ui/common/pages/ApplicationPageType;)V", "addAttachFileInput", "Looo/jtc/core/container/SContainer;", "getAddAttachFileInput", "()Looo/jtc/core/container/SContainer;", "attachments", "", "Looo/jtc/core/elements/Attachment;", "getAttachments", "()Ljava/util/List;", "branchName", "Looo/jtc/core/elements/DropDown;", "getBranchName", "()Looo/jtc/core/elements/DropDown;", "contactName", "Looo/jtc/core/elements/Input;", "getContactName", "()Looo/jtc/core/elements/Input;", "contactPhone", "getContactPhone", "customerName", "getCustomerName", "docText", "Looo/jtc/core/elements/TextArea;", "getDocText", "()Looo/jtc/core/elements/TextArea;", "docTheme", "getDocTheme", "docTypeDescription", "getDocTypeDescription", "tabName", "", "getTabName", "()Ljava/lang/String;", "checkAllAttachments", "", "condition", "Lcom/codeborne/selenide/Condition;", "checkAnswerToLfb", "user", "Looo/jtc/uaa/User;", "customerId", "Ljava/util/UUID;", "lfbDocNumber", "lfbDocDate", "lfbDocTheme", "lfbDocText", "checkAttachmentsCantRemove", "checkEditFromFilledCorrect", "view", "checkFieldsEditable", "checkFieldsNotEditable", "checkHeader", "docDate", "Ljava/time/LocalDate;", "checkPreFilled", "clientUser", "checkViewFormFilledCorrect", "downloadAttachment", "Ljava/io/File;", "attachName", "fill", "removeAttachments", "qty", "", "LabelFields", "box-tests"})
@ooo.jtc.core.elements.ElementType(name = "\u0424\u043e\u0440\u043c\u0430 \'\u041f\u0438\u0441\u044c\u043c\u043e \u0432 \u0431\u0430\u043d\u043a\'. \u0417\u0430\u043a\u043b\u0430\u0434\u043a\u0430 \'\u041e\u0441\u043d\u043e\u0432\u043d\u044b\u0435 \u0440\u0435\u043a\u0432\u0438\u0437\u0438\u0442\u044b\'")
public final class LetterToBankFormBasicRequisitesTab extends ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormPage implements ooo.jtc.ui.interfaces.CreatePage<ooo.jtc.letters.LetterToBankView>, ooo.jtc.ui.interfaces.EditablePage<ooo.jtc.letters.LetterToBankView>, ooo.jtc.ui.interfaces.ViewPage, ooo.jtc.ui.common.sections.tabs.TabSection<ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormBasicRequisitesTab> {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tabName = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getTabName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.DropDown getCustomerName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.DropDown getBranchName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.DropDown getDocTypeDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Input getContactName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Input getContactPhone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Input getDocTheme() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.TextArea getDocText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SContainer getAddAttachFileInput() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.core.elements.Attachment> getAttachments() {
        return null;
    }
    
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u0417\u0430\u043f\u043e\u043b\u043d\u0438\u0442\u044c \u0444\u043e\u0440\u043c\u0443 \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f")
    public void fill(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.LetterToBankView view) {
    }
    
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0444\u043e\u0440\u043c\u0430 \u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d\u0430 \u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u043e")
    public void checkEditFromFilledCorrect(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.LetterToBankView view) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043f\u043e\u043b\u044f \u043d\u0430 \u0444\u043e\u0440\u043c\u0435 \u043f\u0440\u043e\u0441\u043c\u043e\u0442\u0440\u0430")
    public final void checkViewFormFilledCorrect(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.LetterToBankView view) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u0437\u0430\u0433\u043e\u043b\u043e\u0432\u043e\u043a \u0444\u043e\u0440\u043c\u044b \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f")
    public final void checkHeader(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate docDate) {
    }
    
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u043f\u043e\u043b\u044f \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u044e\u0442\u0441\u044f \u0431\u0435\u0437 \u0432\u043e\u0437\u043c\u043e\u0436\u043d\u043e\u0441\u0442\u0438 \u0440\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u044f")
    public void checkFieldsNotEditable() {
    }
    
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u043f\u043e\u043b\u044f \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u044e\u0442\u0441\u044f \u0441 \u0432\u043e\u0437\u043c\u043e\u0436\u043d\u043e\u0441\u0442\u044c\u044e \u0440\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u044f")
    public void checkFieldsEditable(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.LetterToBankView view) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u044f {condition.name}")
    public final void checkAllAttachments(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.Condition condition) {
    }
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u044f. \u041a\u043e\u043b-\u0432\u043e: {qty}")
    public final void removeAttachments(int qty) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043a\u0430\u0447\u0430\u0442\u044c \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u0435 \u043f\u043e \u0438\u043c\u0435\u043d\u0438 \'{attachName}\'")
    public final java.io.File downloadAttachment(@org.jetbrains.annotations.NotNull()
    java.lang.String attachName) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u043e\u0442\u0441\u0443\u0442\u0441\u0442\u0432\u0443\u0435\u0442 \u0437\u043d\u0430\u0447\u043e\u043a \u0443\u0434\u0430\u043b\u0435\u043d\u0438\u044f \u0443 \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u0439")
    public final void checkAttachmentsCantRemove() {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u043d\u0430 \u0444\u043e\u0440\u043c\u0435 \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \u043f\u0440\u0435\u0434\u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d\u044b \u043f\u043e\u043b\u044f")
    public final void checkPreFilled(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User clientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.LetterToBankView view) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u043e\u0442\u043a\u0440\u044b\u043b\u0430\u0441\u044c \u0444\u043e\u0440\u043c\u0430 \u043e\u0442\u0432\u0435\u0442\u0430 \u043d\u0430 \u043f\u0438\u0441\u044c\u043c\u043e {lfbDocTheme} ")
    public final void checkAnswerToLfb(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.NotNull()
    java.lang.String lfbDocNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String lfbDocDate, @org.jetbrains.annotations.NotNull()
    java.lang.String lfbDocTheme, @org.jetbrains.annotations.NotNull()
    java.lang.String lfbDocText) {
    }
    
    public LetterToBankFormBasicRequisitesTab(@org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType pageType) {
        super(null);
    }
    
    /**
     * Ожидание загрузки элементов закладки.
     */
    public void waitTabOpens() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormBasicRequisitesTab openTab() {
        return null;
    }
    
    /**
     * Внутренний класс с полями для формы просмотра.
     */
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Looo/jtc/ui/pages/documents/lettertobank/form/LetterToBankFormBasicRequisitesTab$LabelFields;", "", "(Looo/jtc/ui/pages/documents/lettertobank/form/LetterToBankFormBasicRequisitesTab;)V", "branchName", "Looo/jtc/core/elements/Label;", "getBranchName", "()Looo/jtc/core/elements/Label;", "contactName", "getContactName", "contactPhone", "getContactPhone", "customerName", "getCustomerName", "docText", "getDocText", "docTheme", "getDocTheme", "docTypeDescription", "getDocTypeDescription", "box-tests"})
    public final class LabelFields {
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.core.elements.Label getCustomerName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.core.elements.Label getBranchName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.core.elements.Label getDocTypeDescription() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.core.elements.Label getContactName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.core.elements.Label getContactPhone() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.core.elements.Label getDocTheme() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.core.elements.Label getDocText() {
            return null;
        }
        
        public LabelFields() {
            super();
        }
    }
}