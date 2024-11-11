package ooo.jtc.ui.pages.documents.letterfrombank.sections;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0017J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017R\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006R\u00020\u00000\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Looo/jtc/ui/pages/documents/letterfrombank/sections/LetterFromBankModalSignDocument;", "Looo/jtc/ui/common/sections/modals/ModalSignDocument;", "Looo/jtc/letters/LetterFromBankView;", "()V", "previewDetails", "", "Looo/jtc/ui/pages/documents/letterfrombank/sections/LetterFromBankModalSignDocument$LfbSignDetailsRow;", "getPreviewDetails", "()Ljava/util/List;", "checkDocsPreview", "", "expDocList", "checkModalOpened", "expDocCount", "", "expDocCounterText", "", "LfbSignDetailsRow", "box-tests"})
@ooo.jtc.core.elements.ElementType(name = "\u0424\u043e\u0440\u043c\u0430 \'\u041f\u043e\u0434\u043f\u0438\u0441\u0430\u0442\u044c\'")
public final class LetterFromBankModalSignDocument extends ooo.jtc.ui.common.sections.modals.ModalSignDocument<ooo.jtc.letters.LetterFromBankView> {
    
    private final java.util.List<ooo.jtc.ui.pages.documents.letterfrombank.sections.LetterFromBankModalSignDocument.LfbSignDetailsRow> getPreviewDetails() {
        return null;
    }
    
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \'{this.title}\' \u043e\u0442\u043a\u0440\u044b\u0442\u0430")
    public void checkModalOpened(int expDocCount, @org.jetbrains.annotations.NotNull()
    java.lang.String expDocCounterText) {
    }
    
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c \u0440\u0435\u043a\u0432\u0438\u0437\u0438\u0442\u044b \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 \u0432 \u0441\u0442\u0440\u043e\u043a\u0430\u0445 \u0431\u044b\u0441\u0442\u0440\u043e\u0433\u043e \u043f\u0440\u043e\u0441\u043c\u043e\u0442\u0440\u0430")
    public void checkDocsPreview(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.letters.LetterFromBankView> expDocList) {
    }
    
    public LetterFromBankModalSignDocument() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001aB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u001c\u0010\u0007\u001a\n0\bR\u00060\u0000R\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Looo/jtc/ui/pages/documents/letterfrombank/sections/LetterFromBankModalSignDocument$LfbSignDetailsRow;", "Looo/jtc/core/container/SContainer;", "Looo/jtc/core/elements/Row;", "Looo/jtc/core/elements/WithPanel;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Looo/jtc/ui/pages/documents/letterfrombank/sections/LetterFromBankModalSignDocument;Lcom/codeborne/selenide/SelenideElement;)V", "docRequisites", "Looo/jtc/ui/pages/documents/letterfrombank/sections/LetterFromBankModalSignDocument$LfbSignDetailsRow$DocRequisites;", "Looo/jtc/ui/pages/documents/letterfrombank/sections/LetterFromBankModalSignDocument;", "getDocRequisites", "()Looo/jtc/ui/pages/documents/letterfrombank/sections/LetterFromBankModalSignDocument$LfbSignDetailsRow$DocRequisites;", "docTheme", "Looo/jtc/core/elements/Label;", "getDocTheme", "()Looo/jtc/core/elements/Label;", "docTypeDescription", "getDocTypeDescription", "documentNumberAndDate", "getDocumentNumberAndDate", "status", "getStatus", "checkDocRequisites", "", "view", "Looo/jtc/letters/LetterFromBankView;", "DocRequisites", "box-tests"})
    public final class LfbSignDetailsRow extends ooo.jtc.core.container.SContainer implements ooo.jtc.core.elements.Row, ooo.jtc.core.elements.WithPanel {
        
        private final ooo.jtc.core.elements.Label getDocumentNumberAndDate() {
            return null;
        }
        
        private final ooo.jtc.core.elements.Label getDocTypeDescription() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.core.elements.Label getDocTheme() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.core.elements.Label getStatus() {
            return null;
        }
        
        private final ooo.jtc.ui.pages.documents.letterfrombank.sections.LetterFromBankModalSignDocument.LfbSignDetailsRow.DocRequisites getDocRequisites() {
            return null;
        }
        
        @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c \u0440\u0435\u043a\u0432\u0438\u0437\u0438\u0442\u044b \u0434\u043b\u044f \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 ({view.id})")
        public final void checkDocRequisites(@org.jetbrains.annotations.NotNull()
        ooo.jtc.letters.LetterFromBankView view) {
        }
        
        public LfbSignDetailsRow(@org.jetbrains.annotations.NotNull()
        com.codeborne.selenide.SelenideElement sElement) {
            super(null, null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public java.lang.String getId() {
            return null;
        }
        
        public boolean isExpanded() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public com.codeborne.selenide.SelenideElement getOnPanel() {
            return null;
        }
        
        public void collapse() {
        }
        
        public void expand() {
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0017\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u0011\u0010\u0019\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\fR\u0011\u0010\u001b\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\f\u00a8\u0006\u001d"}, d2 = {"Looo/jtc/ui/pages/documents/letterfrombank/sections/LetterFromBankModalSignDocument$LfbSignDetailsRow$DocRequisites;", "Looo/jtc/core/container/SContainer;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Looo/jtc/ui/pages/documents/letterfrombank/sections/LetterFromBankModalSignDocument$LfbSignDetailsRow;Lcom/codeborne/selenide/SelenideElement;)V", "attachmentsNames", "Lcom/codeborne/selenide/ElementsCollection;", "getAttachmentsNames", "()Lcom/codeborne/selenide/ElementsCollection;", "branchName", "Looo/jtc/core/elements/Label;", "getBranchName", "()Looo/jtc/core/elements/Label;", "contactName", "getContactName", "contactPhone", "getContactPhone", "customerName", "getCustomerName", "docText", "getDocText", "docTheme", "getDocTheme", "docType", "getDocType", "documentDate", "getDocumentDate", "documentNumber", "getDocumentNumber", "box-tests"})
        public final class DocRequisites extends ooo.jtc.core.container.SContainer {
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.core.elements.Label getDocumentNumber() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.core.elements.Label getDocumentDate() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.core.elements.Label getDocType() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.core.elements.Label getCustomerName() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.core.elements.Label getBranchName() {
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
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.core.elements.Label getContactName() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final ooo.jtc.core.elements.Label getContactPhone() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.codeborne.selenide.ElementsCollection getAttachmentsNames() {
                return null;
            }
            
            public DocRequisites(@org.jetbrains.annotations.NotNull()
            com.codeborne.selenide.SelenideElement sElement) {
                super(null, null);
            }
        }
    }
}