package tools;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0002J*\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\u0011H\u0002J\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0002J\u0016\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0002J\u0006\u0010\u0016\u001a\u00020\u0017R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0018"}, d2 = {"Ltools/TmsTagWriter;", "", "()V", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "addSuiteTags", "", "content", "suiteName", "classTagsList", "", "addTagsForMethods", "methodTagsMap", "Ljava/util/HashMap;", "removeOldMethodTags", "methodTags", "transformClassTags", "classTags", "writeTmsTags", "", "box-tests"})
public final class TmsTagWriter {
    private static final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    public static final tools.TmsTagWriter INSTANCE = null;
    
    private final org.slf4j.Logger getLog() {
        return null;
    }
    
    /**
     * Add TMS tags to the *TestSuite.
     */
    public final void writeTmsTags() {
    }
    
    private final java.lang.String addSuiteTags(java.lang.String content, java.lang.String suiteName, java.util.Set<java.lang.String> classTagsList) {
        return null;
    }
    
    private final java.lang.String addTagsForMethods(java.lang.String content, java.util.HashMap<java.lang.String, java.util.Set<java.lang.String>> methodTagsMap) {
        return null;
    }
    
    private final java.lang.String removeOldMethodTags(java.lang.String content, java.util.Set<java.lang.String> methodTags) {
        return null;
    }
    
    private final java.lang.String transformClassTags(java.util.Set<java.lang.String> classTags) {
        return null;
    }
    
    private TmsTagWriter() {
        super();
    }
}