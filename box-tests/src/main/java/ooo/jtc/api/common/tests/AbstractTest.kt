package ooo.jtc.api.common.tests

import ooo.jtc.core.tm4j.Component
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.Priority
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jComponent
import ooo.jtc.core.tm4j.Tm4jPriority
import ooo.jtc.reflections.ReflectionUtils.findAnnotationRecursively
import org.junit.jupiter.api.Tag
import org.junit.platform.commons.util.AnnotationUtils.findRepeatableAnnotations
import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation

/**
 * Base abstract test.
 * Test must implement
 *      test name generating;
 *      test body in execution() method;
 *
 * Test may get
 *      preExecution (empty by default) function;
 *      postExecution (empty by default) function;
 *      testPostExecution (empty by default) function;
 *      params as [Map] (empty by default)
 *
 *      TR  - class of test execution result
 *      PR  - class of test preExecution result
 *
 */
abstract class AbstractTest<PR : Any, TR : Any>(
    open var name: String = "Default test name",
    open val preExecution: (() -> PR)? = null,
    open val postExecution: ((PR) -> Unit)? = null,
    open val testPostExecution: ((TR) -> Unit)? = null,
) {

    /**
     * Result object of [preExecution] function.
     * !Necessary for [postExecution].
     */
    var preconditionResult: PR? = null

    /**
     * Result object of test (i.e. [execution] function).
     * !Necessary for [testPostExecution].
     */
    var testResult: TR? = null

    abstract fun execution(preconditionResult: PR?)

    //todo get default params fromm constructor
    open fun params(): Map<String, Any> = emptyMap()

    open fun name(): String = name


    //region TMS params
    /**
     * Test case ID from TMS (Tm4j).
     * Binds test case and autotest.
     */
    var tmsId: String? = null

    /**
     * List of development task ids.
     * For creating test coverage and traceability.
     *
     * Initialized by annotation [TaskIds] over the test class
     * or by [withTaskIds] function inside TestFactory method.
     */
    var taskIds: MutableSet<String>? = null
        get() = {
            val combinedList = retrieveTaskIds()
            combinedList?.let { fromAnnotationList -> field?.let { fieldList -> fromAnnotationList.addAll(fieldList) } }
            (combinedList ?: field)?.toMutableSet()
        }.invoke()

    /**
     * List of bug ids.
     */
    var issues: List<String> = emptyList()

    /**
     * [Tm4jComponent]
     */
    var component: Tm4jComponent? = null
        get() = field ?: retrieveComponent()

    var priority: Tm4jPriority? = null
        get() = field ?: retrievePriority()

    var folder: String? = null
        get() = field ?: retrieveFolder()
    //endregion


    /**
     * Adding tms id in test.
     */
    open fun withId(id: String): AbstractTest<*, *> {
        this.tmsId = id
        return this
    }

    /**
     * Adding tms id from annotation in test.
     */
    open fun <T : Annotation> withId(kClass: KClass<T>): AbstractTest<*, *> {
        this.tmsId = kClass.findAnnotation<Tag>()?.value
        return this
    }

    /**
     * Adding issues ids in test.
     */
    fun withIssues(vararg issues: String): AbstractTest<*, *> {
        this.issues = issues.toList()
        return this
    }

    fun withTaskIds(vararg taskIds: String): AbstractTest<*, *> {
        this.taskIds = taskIds.toMutableSet()
        return this
    }

    fun <T: Annotation> withTaskIds(taskIdsClass: KClass<T>): AbstractTest<*, *> {
        this.taskIds = findRepeatableAnnotations(taskIdsClass.java, TaskIds::class.java)
            .map { it.value.toList() }.flatten().toMutableSet()
        return this
    }

    fun withComponent(component: Tm4jComponent): AbstractTest<*, *> {
        this.component = component
        return this
    }

    fun withPriority(priority: Tm4jPriority): AbstractTest<*, *> {
        this.priority = priority
        return this
    }

    fun withFolder(folder: String): AbstractTest<*, *> {
        this.folder = folder
        return this
    }

    fun <T : Annotation> withFolder(folderClass: KClass<T>): AbstractTest<*, *> {
        this.folder = folderClass.findAnnotation<Folder>()?.value
        return this
    }

    private fun retrieveTaskIds(): MutableList<String>? = findRepeatableAnnotations(this::class.java, TaskIds::class.java)
        .map { it.value.toList() }.flatten().toMutableList()

    private fun retrieveComponent(): Tm4jComponent? = findAnnotationRecursively(this::class, Component::class)?.value
    private fun retrievePriority(): Tm4jPriority? = findAnnotationRecursively(this::class, Priority::class)?.value
    private fun retrieveFolder(): String? = findAnnotationRecursively(this::class, Folder::class)?.value

    override fun toString(): String {
        return name()
    }
}