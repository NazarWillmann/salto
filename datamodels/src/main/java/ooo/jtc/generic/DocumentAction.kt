package ooo.jtc.generic

import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.extensions.getSafe
import ooo.jtc.interfaces.IDocument

/**
 * Интерфейс для объектов Действий (/GetActions).
 * Сейчас значения действий зашиты на фронте. Но в будущем (в след релизе) фронт будет брать их c бэка из ЛокРесов (/GetLocResource).
 * Так же на примере этих экшенов, я решил реализовать механизм использования "своих" локресов для проверок. См. подробнее в /wiki/TestLocResources.md
 *
 * Интерфейс соответствует объекту ответа `/GetActions` [AvailableActionDto] c дополнениями по локализации.
 *
 * !!Сейчас бэк присылает не актуальную информацию в `/GetActions`. Поэтому занчения для [title] в энамах используются "наши".
 */
//TODO A.Stykalin [23.07.2020] Перепроверить и переписать наши локрес-файлы,
// когда фронт будет использовать `/GetActions` и в `/GetLocResource` будут актуальные экшены.
interface DocumentAction<out T : IDocument> {
    /**
     * Системное наименование действия.
     */
    val actionName: String

    /**
     * Доступные для действия статусы документа.
     */
    val statuses: List<IDocumentStatus<T>>

    /**
     * Ключ-ссылка для фронта на локресы.
     */
    val title: String

    /**
     * Мапа с локресами из [LocResourceRepository].
     */
    val i18nMap: Map<String, String>

    /**
     * Получить наименование действия для фронта с учетом локализации по [title].
     *
     * Т.к. [title] с бэка приходит в двойных квадратных скобках "[[some.loc.resource]]",
     * а локрес-файлах эти ключи без скобок, нужно делать repace.
     */
    fun getUiName(): String {
        val key = title.replace("[", "").replace("]", "")
        return i18nMap.getSafe(key)
    }
}