package ooo.jtc.core.api;

import java.lang.System;

/**
 * LogOutputStream.
 *
 * @author Pavel_Markin
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Looo/jtc/core/api/LoggingOutputStream;", "Ljava/io/OutputStream;", "logger", "Lorg/slf4j/Logger;", "level", "Ljava/util/logging/Level;", "(Lorg/slf4j/Logger;Ljava/util/logging/Level;)V", "buf", "", "bufLength", "", "count", "hasBeenClosed", "", "close", "", "flush", "reset", "write", "b", "Companion", "qa-core-api"})
public final class LoggingOutputStream extends java.io.OutputStream {
    
    /**
     * Used to maintain the contract of [EMAIL PROTECTED] #close()}.
     */
    private boolean hasBeenClosed = false;
    
    /**
     * The internal buffer where data is stored.
     */
    private byte[] buf;
    
    /**
     * The number of valid bytes in the buffer. This value is always
     * in the range <tt>0</tt> through <tt>buf.length</tt>; elements
     * <tt>buf[0]</tt> through <tt>buf[count-1]</tt> contain valid
     * byte data.
     */
    private int count = 0;
    
    /**
     * Remembers the size of the buffer for speed.
     */
    private int bufLength = 0;
    
    /**
     * The category to write to.
     */
    private final org.slf4j.Logger logger = null;
    
    /**
     * The priority to use when writing to the Category.
     */
    private final java.util.logging.Level level = null;
    
    /**
     * The default number of bytes in the buffer. =2048
     */
    private static final int DEFAULT_BUFFER_LENGTH = 2048;
    public static final ooo.jtc.core.api.LoggingOutputStream.Companion Companion = null;
    
    /**
     * Closes this output stream and releases any system resources
     * associated with this stream. The general contract of
     * `close`
     * is that it closes the output stream. A closed stream cannot
     * perform
     * output operations and cannot be reopened.
     */
    @java.lang.Override()
    public void close() {
    }
    
    /**
     * Writes the specified byte to this output stream. The general
     * contract for `write` is that one byte is written
     * to the output stream. The byte to be written is the eight
     * low-order bits of the argument `b`. The 24
     * high-order bits of `b` are ignored.
     *
     * @param b the `byte` to write
     * @throws java.io.IOException if an I/O error occurs. In particular, an `IOException` may be
     * thrown if the output stream has been closed.
     */
    @java.lang.Override()
    public void write(int b) throws java.io.IOException {
    }
    
    /**
     * Flushes this output stream and forces any buffered output bytes
     * to be written out. The general contract of `flush` is
     * that calling it is an indication that, if any bytes previously
     * written have been buffered by the implementation of the output
     * stream, such bytes should immediately be written to their
     * intended destination.
     */
    @java.lang.Override()
    public void flush() {
    }
    
    private final void reset() {
    }
    
    public LoggingOutputStream(@org.jetbrains.annotations.Nullable()
    org.slf4j.Logger logger, @org.jetbrains.annotations.Nullable()
    java.util.logging.Level level) throws java.lang.IllegalArgumentException {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Looo/jtc/core/api/LoggingOutputStream$Companion;", "", "()V", "DEFAULT_BUFFER_LENGTH", "", "getDEFAULT_BUFFER_LENGTH", "()I", "qa-core-api"})
    public static final class Companion {
        
        public final int getDEFAULT_BUFFER_LENGTH() {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}