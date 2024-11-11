package ooo.jtc.core.api

import org.slf4j.Logger

import java.io.IOException
import java.io.OutputStream
import java.util.logging.Level
import kotlin.jvm.Throws

/**
 * LogOutputStream.
 *
 * @author Pavel_Markin
 */

class LoggingOutputStream
/**
 * Creates the ooo.jtc.core.api.LoggingOutputStream to flush to the given Category.
 *
 * @param log   the Logger to write to
 * @param level the Level to use when writing to the Logger
 * @throws IllegalArgumentException if cat == null or priority ==
 * null
 */
@Throws(IllegalArgumentException::class)
constructor(
        /**
         * The category to write to.
         */
        private val logger: Logger?,
        /**
         * The priority to use when writing to the Category.
         */
        private val level: Level?) : OutputStream() {

    /**
     * Used to maintain the contract of [EMAIL PROTECTED] #close()}.
     */
    private var hasBeenClosed = false

    /**
     * The internal buffer where data is stored.
     */
    private var buf: ByteArray? = null

    /**
     * The number of valid bytes in the buffer. This value is always
     * in the range <tt>0</tt> through <tt>buf.length</tt>; elements
     * <tt>buf[0]</tt> through <tt>buf[count-1]</tt> contain valid
     * byte data.
     */
    private var count: Int = 0

    /**
     * Remembers the size of the buffer for speed.
     */
    private var bufLength: Int = 0


    init {
        if (logger == null) {
            throw IllegalArgumentException("cat == null")
        }
        if (level == null) {
            throw IllegalArgumentException("priority == null")
        }
        bufLength = DEFAULT_BUFFER_LENGTH
        buf = ByteArray(DEFAULT_BUFFER_LENGTH)
        count = 0
    }


    /**
     * Closes this output stream and releases any system resources
     * associated with this stream. The general contract of
     * `close`
     * is that it closes the output stream. A closed stream cannot
     * perform
     * output operations and cannot be reopened.
     */
    override fun close() {
        flush()
        hasBeenClosed = true
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
    @Throws(IOException::class)
    override fun write(b: Int) {
        if (hasBeenClosed) {
            throw IOException("The stream has been closed.")
        }

        // would this be writing past the buffer?

        if (count == bufLength) {
            // grow the buffer
            val newBufLength = bufLength + DEFAULT_BUFFER_LENGTH
            val newBuf = ByteArray(newBufLength)

            System.arraycopy(buf!!, 0, newBuf, 0, bufLength)
            buf = newBuf

            bufLength = newBufLength
        }

        buf?.set(count, b.toByte())

        count++
    }


    /**
     * Flushes this output stream and forces any buffered output bytes
     * to be written out. The general contract of `flush` is
     * that calling it is an indication that, if any bytes previously
     * written have been buffered by the implementation of the output
     * stream, such bytes should immediately be written to their
     * intended destination.
     */
    override fun flush() {

        if (count == 0) {
            return
        }

        // don't print out blank lines; flushing from PrintStream puts

        // For linux system

        if (count == 1 && buf!![0].toChar() == '\n') {
            reset()
            return
        }

        // For mac system

        if (count == 1 && buf!![0].toChar() == '\r') {
            reset()
            return
        }

        // On windows system

        if (count == 2 && buf!![0].toChar() == '\r' && buf!![1].toChar() == '\n') {
            reset()
            return
        }

        val theBytes = ByteArray(count)
        System.arraycopy(buf!!, 0, theBytes, 0, count)
        logger!!.info(String(theBytes))
        reset()

    }

    private fun reset() {
        // not resetting the buffer -- assuming that if it grew then it will likely grow similarly again
        count = 0
    }

    companion object {

        /**
         * The default number of bytes in the buffer. =2048
         */
        val DEFAULT_BUFFER_LENGTH = 2048
    }

}
