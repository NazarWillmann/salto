package ooo.jtc.api.platform.attachment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0006H\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Looo/jtc/api/platform/attachment/AttachmentSteps;", "Looo/jtc/api/common/steps/AbstractApiSteps;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "servicePath", "", "getServicePath", "()Ljava/lang/String;", "stepApi", "Looo/jtc/core/api/CoreApi;", "download", "Lio/restassured/response/Response;", "fileId", "Ljava/util/UUID;", "accessToken", "withCheckResponseCode", "", "statusCode", "", "getFileStatus", "Looo/jtc/generic/attachments/FileStatusDto;", "upload", "file", "Ljava/io/File;", "fileName", "box-tests"})
public final class AttachmentSteps extends ooo.jtc.api.common.steps.AbstractApiSteps {
    private ooo.jtc.core.api.CoreApi stepApi;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String servicePath = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.lang.String getServicePath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
    @io.qameta.allure.Step(value = "\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044c (upload) \u0444\u0430\u0439\u043b \'{fileName}\'")
    public final ooo.jtc.generic.attachments.FileStatusDto upload(@org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u0442\u0430\u0442\u0443\u0441 \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u044f [{fileId}]")
    public final ooo.jtc.generic.attachments.FileStatusDto getFileStatus(@org.jetbrains.annotations.NotNull()
    java.util.UUID fileId) {
        return null;
    }
    
    /**
     * [fileId] and [accessToken] retrieves from document with attachment response (getById or getPage).
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0412\u044b\u0433\u0440\u0443\u0437\u0438\u0442\u044c (download) \u0444\u0430\u0439\u043b [{fileId}]")
    public final io.restassured.response.Response download(@org.jetbrains.annotations.NotNull()
    java.util.UUID fileId, @org.jetbrains.annotations.NotNull()
    java.lang.String accessToken, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    public AttachmentSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null);
    }
}