package ooo.jtc.reflections;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J-\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\b\b\u0000\u0010\u0019*\u00020\u001a\"\u0004\b\u0001\u0010\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001cH\u0086\u0004J1\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\b\b\u0000\u0010\u001e*\u00020\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0\u001f\u00a2\u0006\u0002\u0010!J$\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00190#\"\b\b\u0000\u0010\u0019*\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001cJ\"\u0010$\u001a\u0002H\u0019\"\u000e\b\u0000\u0010\u0019\u0018\u0001*\u0006\u0012\u0002\b\u00030%*\u0002H\u0019H\u0086\b\u00a2\u0006\u0002\u0010&R\"\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00110\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\'"}, d2 = {"Looo/jtc/reflections/ReflectionUtils;", "", "()V", "classLoader", "Ljava/net/URLClassLoader;", "kotlin.jvm.PlatformType", "getClassLoader", "()Ljava/net/URLClassLoader;", "setClassLoader", "(Ljava/net/URLClassLoader;)V", "reflections", "Lorg/reflections/Reflections;", "getReflections", "()Lorg/reflections/Reflections;", "setReflections", "(Lorg/reflections/Reflections;)V", "testClassesURL", "Ljava/net/URL;", "getTestClassesURL", "()Ljava/net/URL;", "setTestClassesURL", "(Ljava/net/URL;)V", "executeMethodsWithAnnotation", "", "R", "T", "", "clazz", "Ljava/lang/Class;", "findAnnotationRecursively", "A", "Lkotlin/reflect/KClass;", "aClass", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)Ljava/lang/annotation/Annotation;", "findKotlinObjects", "", "anyOther", "", "(Ljava/lang/Enum;)Ljava/lang/Enum;", "qa-utils"})
public final class ReflectionUtils {
    private static java.net.URL testClassesURL;
    private static java.net.URLClassLoader classLoader;
    
    /**
     * Reflection for scanning classes, fields, methods using reflections
     */
    @org.jetbrains.annotations.NotNull()
    private static org.reflections.Reflections reflections;
    public static final ooo.jtc.reflections.ReflectionUtils INSTANCE = null;
    
    public final java.net.URL getTestClassesURL() {
        return null;
    }
    
    public final void setTestClassesURL(java.net.URL p0) {
    }
    
    public final java.net.URLClassLoader getClassLoader() {
        return null;
    }
    
    public final void setClassLoader(java.net.URLClassLoader p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.reflections.Reflections getReflections() {
        return null;
    }
    
    public final void setReflections(@org.jetbrains.annotations.NotNull()
    org.reflections.Reflections p0) {
    }
    
    /**
     * Execute found by annotation methods.
     *
     * @param clazz - annotation class for searching
     * @param R - class of returned objects
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public final <T extends java.lang.annotation.Annotation, R extends java.lang.Object>java.util.List<R> executeMethodsWithAnnotation(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> clazz) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>java.util.List<T> findKotlinObjects(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> clazz) {
        return null;
    }
    
    /**
     * Search for annotation recursively.
     * [clazz] - base object for searching the annotation
     * [aClass] - annotation class for search
     */
    @org.jetbrains.annotations.Nullable()
    public final <A extends java.lang.annotation.Annotation>A findAnnotationRecursively(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<?> clazz, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<A> aClass) {
        return null;
    }
    
    private ReflectionUtils() {
        super();
    }
}