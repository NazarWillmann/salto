package ooo.jtc.documents;

import java.lang.System;

/**
 * Document validation result.
 * VALID - document passed all controls successfully
 * WARNING - document passed all hard controls successfully, but failed one or more soft controls
 * INVALID - document failed one or more hard control
 * NOT_CHECKED - document wasn't checked (controls aren't implemented yet or document was created as draft)
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Looo/jtc/documents/ControlCheckResult;", "", "(Ljava/lang/String;I)V", "VALID", "WARNING", "INVALID", "NOT_CHECKED", "datamodels"})
public enum ControlCheckResult {
    /*public static final*/ VALID /* = new VALID() */,
    /*public static final*/ WARNING /* = new WARNING() */,
    /*public static final*/ INVALID /* = new INVALID() */,
    /*public static final*/ NOT_CHECKED /* = new NOT_CHECKED() */;
    
    ControlCheckResult() {
    }
}