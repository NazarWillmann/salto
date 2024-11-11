package ooo.jtc.api.letters.frombank.tests;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/api/letters/frombank/tests/LetterFromBankGetSignaturesTestClient;", "Looo/jtc/api/common/tests/AbstractTest;", "Looo/jtc/letters/dto/LetterFromBankDto;", "", "Looo/jtc/documents/SignatureDto;", "bankUser", "Looo/jtc/uaa/User;", "clientUser", "nameDetails", "", "(Looo/jtc/uaa/User;Looo/jtc/uaa/User;Ljava/lang/String;)V", "getBankUser", "()Looo/jtc/uaa/User;", "getClientUser", "execution", "", "preconditionResult", "box-tests"})
@ooo.jtc.core.tm4j.NormalPriority()
@ooo.jtc.core.tm4j.ComponentFreeFormatDoc()
@LetterFromBankFolderSignatures()
@LetterFromBankTaskIdsDocApi()
public final class LetterFromBankGetSignaturesTestClient extends ooo.jtc.api.common.tests.AbstractTest<ooo.jtc.letters.dto.LetterFromBankDto, java.util.List<? extends ooo.jtc.documents.SignatureDto>> {
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.uaa.User bankUser = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.uaa.User clientUser = null;
    
    @java.lang.Override()
    public void execution(@org.jetbrains.annotations.Nullable()
    ooo.jtc.letters.dto.LetterFromBankDto preconditionResult) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User getBankUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User getClientUser() {
        return null;
    }
    
    public LetterFromBankGetSignaturesTestClient(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User bankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User clientUser, @org.jetbrains.annotations.NotNull()
    java.lang.String nameDetails) {
        super(null, null, null, null);
    }
}