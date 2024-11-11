package ooo.jtc.reflections

import ooo.jtc.extensions.ifNotEmpty
import org.reflections.Reflections
import org.reflections.scanners.MethodAnnotationsScanner
import org.reflections.scanners.SubTypesScanner
import org.reflections.scanners.TypeAnnotationsScanner
import org.reflections.util.ClasspathHelper
import org.reflections.util.ConfigurationBuilder
import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Paths
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance


object ReflectionUtils {

    var testClassesURL = Paths.get("target/test-classes").toUri().toURL()

    var classLoader = URLClassLoader.newInstance(
        arrayOf<URL>(testClassesURL),
        ClasspathHelper.staticClassLoader()
    )

    /**
     * Reflection for scanning classes, fields, methods using reflections
     */
    var reflections: Reflections = Reflections(
        ConfigurationBuilder()
            .setUrls(ClasspathHelper.forPackage("ooo.jtc"))
            .addClassLoader(classLoader)
            .setScanners(TypeAnnotationsScanner(), SubTypesScanner(), MethodAnnotationsScanner())
    )

    /**
     * Execute found by annotation methods.
     *
     * @param clazz - annotation class for searching
     * @param R - class of returned objects
     */
    @Suppress("UNCHECKED_CAST")
    infix fun <T : Annotation, R> executeMethodsWithAnnotation(clazz: Class<T>): MutableList<R> {
        return reflections.getMethodsAnnotatedWith(clazz).map { (it.invoke(it.declaringClass.kotlin.createInstance()) as R) }.toMutableList()
    }

    fun <T : Any> findKotlinObjects(clazz: Class<T>): List<T> =
        reflections.getSubTypesOf(clazz).map { it.kotlin }.filter { !it.isAbstract }.map { it.objectInstance!! }

    /**
     * Get enum constant, different from 'this'
     */
    inline fun <reified T : Enum<*>> T.anyOther() = T::class.java.enumConstants.find { this != it } ?: let {
        throw NoSuchElementException("No another value in ${this::class.simpleName}, except $this")
    }

    /**
     * Search for annotation recursively.
     * [clazz] - base object for searching the annotation
     * [aClass] - annotation class for search
     */
    fun <A : Annotation> findAnnotationRecursively(clazz: KClass<*>, aClass: KClass<A>): A? {
        val annotations = clazz.annotations
            .filter {
                it.annotationClass != java.lang.annotation.Documented::class &&
                        it.annotationClass != java.lang.annotation.Retention::class &&
                        it.annotationClass != java.lang.annotation.Target::class
            }
        if (annotations.isNotEmpty()) {
            val foundAnnotation = annotations.filterIsInstance(aClass::java.get()).ifNotEmpty { it.first() }
            return if (foundAnnotation != null) {
                foundAnnotation
            } else {
                val superAnnotations = mutableListOf<A?>()
                annotations.forEach {
                    val annotationClass = it.annotationClass
                    val element = findAnnotationRecursively(annotationClass, aClass)
                    superAnnotations.add(element)
                }
                superAnnotations.filterNotNull().ifNotEmpty { it.first() }
            }
        }
        return null
    }
}
