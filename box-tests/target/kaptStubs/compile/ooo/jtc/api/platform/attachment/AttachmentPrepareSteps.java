package ooo.jtc.api.platform.attachment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J,\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\nH\u0007J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Looo/jtc/api/platform/attachment/AttachmentPrepareSteps;", "", "()V", "DEFAULT_ATTACH_FILE", "Ljava/io/File;", "getDEFAULT_ATTACH_FILE", "()Ljava/io/File;", "DEFAULT_ATTACH_FILE$delegate", "Lkotlin/Lazy;", "UPLOAD_DIR", "", "getAttachmentDto", "Looo/jtc/generic/attachments/AttachmentDto;", "fileId", "Ljava/util/UUID;", "fileName", "fileSize", "", "fileHash", "uploadFile", "user", "Looo/jtc/uaa/User;", "file", "box-tests"})
public final class AttachmentPrepareSteps {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UPLOAD_DIR = "/upload";
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy DEFAULT_ATTACH_FILE$delegate = null;
    public static final ooo.jtc.api.platform.attachment.AttachmentPrepareSteps INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getDEFAULT_ATTACH_FILE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c (upload) \u0444\u0430\u0439\u043b \u0438 \u043f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0434\u0430\u043d\u043d\u044b\u0435 \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u044f")
    public final ooo.jtc.generic.attachments.AttachmentDto uploadFile(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    java.io.File file) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0434\u0430\u043d\u043d\u044b\u0435 \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u044f ([{fileId}] / \'{fileName}\' ({fileSize}))")
    public final ooo.jtc.generic.attachments.AttachmentDto getAttachmentDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID fileId, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName, int fileSize, @org.jetbrains.annotations.NotNull()
    java.lang.String fileHash) {
        return null;
    }
    
    private AttachmentPrepareSteps() {
        super();
    }
}