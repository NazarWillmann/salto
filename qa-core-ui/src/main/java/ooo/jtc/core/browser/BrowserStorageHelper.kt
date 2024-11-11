package ooo.jtc.core.browser

import org.openqa.selenium.JavascriptExecutor

/**
 * BrowserStorageHelper.
 *
 * @author Pavel_Markin
 */
object BrowserStorageHelper {

    fun fillPageStorage(executor: JavascriptExecutor, list: List<StorageItem>) {
        list.forEach { setItemInStorage(executor, it) }
    }

    fun removeItemFromStorage(executor: JavascriptExecutor, storageType: StorageType, item: String) =
        executor.executeScript(String.format("window.%s.removeItem('%s');", storageType.type, item))

    fun isItemPresentInStorage(executor: JavascriptExecutor, storageType: StorageType, item: String) =
        executor.executeScript(String.format("return window.%s.getItem('%s');", storageType.type, item)) != null

    fun getItemFromStorage(executor: JavascriptExecutor, storageType: StorageType, key: String) =
        executor.executeScript(String.format("return window.%s.getItem('%s');", storageType.type, key)) as String

    fun getKeyFromStorage(executor: JavascriptExecutor, storageType: StorageType, key: Int): String {
        return executor.executeScript(String.format("return window.%s.key('%s');", storageType.type, key)) as String
    }

    fun storageLength(executor: JavascriptExecutor, storageType: StorageType) =
        executor.executeScript(String.format("return window.%s.length;", storageType.type)) as Long

    fun setItemInStorage(executor: JavascriptExecutor, storageItem: StorageItem) =
        executor.executeScript(String.format("window.%s.setItem('%s','%s');", storageItem.sType.type, storageItem.key, storageItem.value))

    fun clearStorage(executor: JavascriptExecutor, storageType: StorageType) =
        executor.executeScript(String.format("window.%s.clear();", storageType.type))


}

/**
 * Storage type, allow local and session storage.
 *
 * @author Pavel_Markin
 */
enum class StorageType(val type: String) {
    LOCAL("localStorage"),
    SESSION("sessionStorage");
}

/**
 * Объект для взаимодействия с браузерными хранилищами.
 */
data class StorageItem(
    val sType: StorageType,
    val key: String,
    val value: String
)