package ooo.jtc.properties;

import java.lang.System;

@kotlin.Suppress(names = {"UNCHECKED_CAST"})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a4\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u001a6\u0010\u0007\u001a\u0002H\b\"\u0006\b\u0000\u0010\b\u0018\u00012\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0086\b\u00a2\u0006\u0002\u0010\r\u001a6\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f0\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u001a.\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u001a\u001a\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u001a\u001a\u0010\u0017\u001a\u00020\u00122\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u00a8\u0006\u0018"}, d2 = {"createTree", "", "", "", "keys", "", "map", "loadProps", "T", "configFilePropertyName", "configFileDefault", "profilePropertyName", "profileDefault", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "retrieveFullKeyValuePairs", "Lkotlin/Pair;", "prevKey", "retrieveProfile", "", "updateConfig", "baseNode", "updateNode", "updateMapFromSystemProperties", "updateSystemPropertiesFromFile", "qa-utils"})
public final class PropertiesLoaderKt {
    
    /**
     * Select desirable profile.
     *
     * @param profilePropertyName - desirable profile name from System.property (e.g. from maven -Dprofile=dev)
     * @param profileDefault - default profile name (e.g. "test")
     * @param map - properties from yml-file as Map<String, Any>
     */
    public static final void retrieveProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String profilePropertyName, @org.jetbrains.annotations.NotNull()
    java.lang.String profileDefault, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Object> map) {
    }
    
    public static final void updateSystemPropertiesFromFile(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Object> map) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> retrieveFullKeyValuePairs(@org.jetbrains.annotations.Nullable()
    java.lang.String prevKey, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Object> map) {
        return null;
    }
    
    /**
     * Update properties from file by system properties.
     * e.g. application.yml has property `tms:project:JTCSALTO`. if we run tests from maven with key -Dtms.project=JTC, System.getProperty("tms.project") => JTC
     */
    @kotlin.Suppress(names = {"MoveVariableDeclarationIntoWhen"})
    public static final void updateMapFromSystemProperties(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Object> map) {
    }
    
    /**
     * Update config properties, baseNode map updated from updateNode.
     * e.g.:
     * baseNode.user.name = updateNode.user.name
     * baseNode.user.age = updateNode.user.age
     */
    public static final void updateConfig(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Object> baseNode, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Object> updateNode) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.Map<java.lang.String, java.lang.Object> createTree(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> keys, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.Object> map) {
        return null;
    }
}