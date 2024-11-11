package ooo.jtc.ui.application;

import java.lang.System;

/**
 * Pages on Client side of Application
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010\'\u001a\u00020(8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u00a8\u0006/"}, d2 = {"Looo/jtc/ui/application/ClientApplication;", "", "()V", "budgetRuPaymentFormPage", "Looo/jtc/ui/pages/documents/rupayment/forms/BudgetRuPaymentFormPage;", "getBudgetRuPaymentFormPage", "()Looo/jtc/ui/pages/documents/rupayment/forms/BudgetRuPaymentFormPage;", "customRuPaymentFormPage", "Looo/jtc/ui/pages/documents/rupayment/forms/CustomRuPaymentFormPage;", "getCustomRuPaymentFormPage", "()Looo/jtc/ui/pages/documents/rupayment/forms/CustomRuPaymentFormPage;", "lFBFormBasicRequisitesClient", "Looo/jtc/ui/pages/documents/letterfrombank/form/LetterFromBankFormBasicRequisitesTab;", "getLFBFormBasicRequisitesClient", "()Looo/jtc/ui/pages/documents/letterfrombank/form/LetterFromBankFormBasicRequisitesTab;", "lFBScrollerPageClient", "Looo/jtc/ui/pages/documents/letterfrombank/scroller/LetterFromBankScrollerPage;", "getLFBScrollerPageClient", "()Looo/jtc/ui/pages/documents/letterfrombank/scroller/LetterFromBankScrollerPage;", "lTBFormBasicRequisitesClient", "Looo/jtc/ui/pages/documents/lettertobank/form/LetterToBankFormBasicRequisitesTab;", "getLTBFormBasicRequisitesClient", "()Looo/jtc/ui/pages/documents/lettertobank/form/LetterToBankFormBasicRequisitesTab;", "lTBScrollerPageClient", "Looo/jtc/ui/pages/documents/lettertobank/scroller/LetterToBankScrollerPage;", "getLTBScrollerPageClient", "()Looo/jtc/ui/pages/documents/lettertobank/scroller/LetterToBankScrollerPage;", "organizationRuPaymentFormPage", "Looo/jtc/ui/pages/documents/rupayment/forms/OrganizationRuPaymentFormPage;", "getOrganizationRuPaymentFormPage", "()Looo/jtc/ui/pages/documents/rupayment/forms/OrganizationRuPaymentFormPage;", "otherPaymentFormPage", "Looo/jtc/ui/pages/documents/rupayment/forms/OtherRuPaymentFormPage;", "getOtherPaymentFormPage", "()Looo/jtc/ui/pages/documents/rupayment/forms/OtherRuPaymentFormPage;", "personRuPaymentFormPage", "Looo/jtc/ui/pages/documents/rupayment/forms/PersonRuPaymentFormPage;", "getPersonRuPaymentFormPage", "()Looo/jtc/ui/pages/documents/rupayment/forms/PersonRuPaymentFormPage;", "ruPaymentScrollerPage", "Looo/jtc/ui/pages/documents/rupayment/scroller/RuPaymentScrollerPage;", "getRuPaymentScrollerPage", "()Looo/jtc/ui/pages/documents/rupayment/scroller/RuPaymentScrollerPage;", "taxRuPaymentFormPage", "Looo/jtc/ui/pages/documents/rupayment/forms/TaxRuPaymentFormPage;", "getTaxRuPaymentFormPage", "()Looo/jtc/ui/pages/documents/rupayment/forms/TaxRuPaymentFormPage;", "box-tests"})
public final class ClientApplication {
    public static final ooo.jtc.ui.application.ClientApplication INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.ui.pages.documents.rupayment.scroller.RuPaymentScrollerPage getRuPaymentScrollerPage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerPage getLTBScrollerPageClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.ui.pages.documents.letterfrombank.scroller.LetterFromBankScrollerPage getLFBScrollerPageClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.ui.pages.documents.rupayment.forms.BudgetRuPaymentFormPage getBudgetRuPaymentFormPage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.ui.pages.documents.rupayment.forms.TaxRuPaymentFormPage getTaxRuPaymentFormPage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.ui.pages.documents.rupayment.forms.PersonRuPaymentFormPage getPersonRuPaymentFormPage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.ui.pages.documents.rupayment.forms.OrganizationRuPaymentFormPage getOrganizationRuPaymentFormPage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.ui.pages.documents.rupayment.forms.CustomRuPaymentFormPage getCustomRuPaymentFormPage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.ui.pages.documents.rupayment.forms.OtherRuPaymentFormPage getOtherPaymentFormPage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormBasicRequisitesTab getLTBFormBasicRequisitesClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.ui.pages.documents.letterfrombank.form.LetterFromBankFormBasicRequisitesTab getLFBFormBasicRequisitesClient() {
        return null;
    }
    
    private ClientApplication() {
        super();
    }
}