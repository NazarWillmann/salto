package ooo.jtc.api.common.steps;

import java.lang.System;

/**
 * Abstract steps. All implementations must have user as [User] for executing REST queries
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\b"}, d2 = {"Looo/jtc/api/common/steps/AbstractSteps;", "", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "getUser", "()Looo/jtc/uaa/User;", "setUser", "box-tests"})
public abstract class AbstractSteps {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.uaa.User user;
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User p0) {
    }
    
    public AbstractSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super();
    }
}