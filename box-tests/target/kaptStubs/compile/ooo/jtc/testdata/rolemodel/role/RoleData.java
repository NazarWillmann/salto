package ooo.jtc.testdata.rolemodel.role;

import java.lang.System;

/**
 * RoleData data, that loaded from testDataProvider as [RoleData] in [Role] format.
 * With related Privilege Groups
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R,\u0010\u0015\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00180\u00170\u00160\fX\u0094\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000eR8\u0010\u001a\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00180\u00170\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\bR!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b$\u0010\u001fR(\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\'\u0018\u00010\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\n\u00a8\u0006*"}, d2 = {"Looo/jtc/testdata/rolemodel/role/RoleData;", "Looo/jtc/testdata/common/TestData;", "Looo/jtc/rolemodel/role/Role;", "()V", "atMarkerPredicate", "Lkotlin/Function1;", "", "getAtMarkerPredicate", "()Lkotlin/jvm/functions/Function1;", "setAtMarkerPredicate", "(Lkotlin/jvm/functions/Function1;)V", "createRecord", "Lkotlin/Function0;", "getCreateRecord", "()Lkotlin/jvm/functions/Function0;", "setCreateRecord", "(Lkotlin/jvm/functions/Function0;)V", "dataFileName", "", "getDataFileName", "()Ljava/lang/String;", "dbDataConsumer", "", "", "", "getDbDataConsumer", "dbResultPostProcessor", "getDbResultPostProcessor", "privilegeGroupData", "Looo/jtc/rolemodel/privilegegroup/PrivilegeGroup;", "getPrivilegeGroupData", "()Ljava/util/List;", "privilegeGroupData$delegate", "Lkotlin/Lazy;", "relationData", "Looo/jtc/rolemodel/relations/RolePrivilegeGroup;", "getRelationData", "relationData$delegate", "removeRecord", "", "getRemoveRecord", "setRemoveRecord", "box-tests"})
public final class RoleData extends ooo.jtc.testdata.common.TestData<ooo.jtc.rolemodel.role.Role> {
    @org.jetbrains.annotations.NotNull()
    private static kotlin.jvm.functions.Function1<? super ooo.jtc.rolemodel.role.Role, java.lang.Boolean> atMarkerPredicate;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function0<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> dbDataConsumer = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String dataFileName = "role(scope).json";
    @org.jetbrains.annotations.Nullable()
    private static kotlin.jvm.functions.Function0<ooo.jtc.rolemodel.role.Role> createRecord;
    @org.jetbrains.annotations.Nullable()
    private static kotlin.jvm.functions.Function1<? super ooo.jtc.rolemodel.role.Role, kotlin.Unit> removeRecord;
    private static final kotlin.Lazy privilegeGroupData$delegate = null;
    private static final kotlin.Lazy relationData$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, java.lang.Object>, java.util.Map<java.lang.String, java.lang.Object>> dbResultPostProcessor = null;
    public static final ooo.jtc.testdata.rolemodel.role.RoleData INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<ooo.jtc.rolemodel.role.Role, java.lang.Boolean> getAtMarkerPredicate() {
        return null;
    }
    
    @java.lang.Override()
    public void setAtMarkerPredicate(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.rolemodel.role.Role, java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected kotlin.jvm.functions.Function0<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> getDbDataConsumer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getDataFileName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<ooo.jtc.rolemodel.role.Role> getCreateRecord() {
        return null;
    }
    
    @java.lang.Override()
    public void setCreateRecord(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<ooo.jtc.rolemodel.role.Role> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<ooo.jtc.rolemodel.role.Role, kotlin.Unit> getRemoveRecord() {
        return null;
    }
    
    @java.lang.Override()
    public void setRemoveRecord(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super ooo.jtc.rolemodel.role.Role, kotlin.Unit> p0) {
    }
    
    private final java.util.List<ooo.jtc.rolemodel.privilegegroup.PrivilegeGroup> getPrivilegeGroupData() {
        return null;
    }
    
    private final java.util.List<ooo.jtc.rolemodel.relations.RolePrivilegeGroup> getRelationData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, java.lang.Object>, java.util.Map<java.lang.String, java.lang.Object>> getDbResultPostProcessor() {
        return null;
    }
    
    private RoleData() {
        super(null);
    }
}