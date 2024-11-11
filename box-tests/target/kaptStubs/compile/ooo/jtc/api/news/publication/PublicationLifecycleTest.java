package ooo.jtc.api.news.publication;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Looo/jtc/api/news/publication/PublicationLifecycleTest;", "Looo/jtc/api/common/tests/AbstractBeTest;", "Looo/jtc/news/dto/PublicationDto;", "", "bankUser", "Looo/jtc/uaa/User;", "statusTransition", "", "preExecution", "Lkotlin/Function0;", "testBody", "Lkotlin/Function1;", "(Looo/jtc/uaa/User;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "box-tests"})
@ooo.jtc.core.tm4j.HighPriority()
@ooo.jtc.core.tm4j.ComponentNews()
@PublicationFolderLifecycle()
@ooo.jtc.api.news.PublicationTaskIdsLifecycle()
public class PublicationLifecycleTest extends ooo.jtc.api.common.tests.AbstractBeTest<ooo.jtc.news.dto.PublicationDto, kotlin.Unit> {
    
    public PublicationLifecycleTest(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User bankUser, @org.jetbrains.annotations.NotNull()
    java.lang.String statusTransition, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.news.dto.PublicationDto> preExecution, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.news.dto.PublicationDto, kotlin.Unit> testBody) {
        super(null, null, null, null, null, null);
    }
}