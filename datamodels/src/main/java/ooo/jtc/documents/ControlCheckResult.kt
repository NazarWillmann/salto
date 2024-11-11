package ooo.jtc.documents

/**
 * Document validation result.
 * VALID - document passed all controls successfully
 * WARNING - document passed all hard controls successfully, but failed one or more soft controls
 * INVALID - document failed one or more hard control
 * NOT_CHECKED - document wasn't checked (controls aren't implemented yet or document was created as draft)
 */
enum class ControlCheckResult {
    VALID,
    WARNING,
    INVALID,
    NOT_CHECKED
}