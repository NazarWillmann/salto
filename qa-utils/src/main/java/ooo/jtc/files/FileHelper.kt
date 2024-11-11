package ooo.jtc.files

import java.io.File

object FileHelper {

    /**
     * Creates a list of temp files which will deletes at the end of program.
     * @param fileName - `prefix` of file name
     * @param fileExt - `suffix` of file name. Extension.
     * @param qty - size of list. Also appends to [fileName].
     * @param content - content of each file.
     * !NB: just before file extension system generates a random number,
     * e.g. `fileName = "hello", fileExt = ".txt", qty = 1` => <fileName>_<qty>_<randomNumber><fileExt> => hello_1_3457235834534.txt
     */
    fun createTempFiles(fileName: String, fileExt: String, qty: Int, content: ByteArray): List<File> {
        val resultList = mutableListOf<File>()
        val fullExt = if (fileExt.startsWith(".")) fileExt else ".$fileExt"
        for (counter in 1..qty) {
            val fullFileName = "${fileName}_${counter}_"
            val file = File.createTempFile(fullFileName, fullExt)
            file.writeBytes(content)
            file.deleteOnExit()
            resultList.add(file)
        }
        return resultList
    }

    /**
     * Creates single temporary file (will be deleted at the end of program).
     * @param fileName - `prefix` of file name
     * @param fileExt - `suffix` of file name. Extension.
     * @param content - content of file.
     * !NB: just before file extension system generates a random number,
     * e.g. `fileName = "hello", fileExt = ".txt"` => <fileName>_<randomNumber><fileExt> => hello_3457235834534.txt
     */
    fun createSingleTempFile(fileName: String, fileExt: String, content: ByteArray): File {
        val fullExt = if (fileExt.startsWith(".")) fileExt else ".$fileExt"
        val fullFileName = "${fileName}_"
        val file = File.createTempFile(fullFileName, fullExt)
        file.writeBytes(content)
        file.deleteOnExit()
        return file
    }

}