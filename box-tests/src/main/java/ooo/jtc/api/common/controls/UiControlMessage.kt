package ooo.jtc.api.common.controls

object UiControlMessage {
    val getFieldIsEmptyMsg: (fieldName: String) -> String
        get() = { fieldName ->
            "Реквизит $fieldName является обязательным для заполнения, не может быть пустым или заполненным пробелами"
        }
    val getFieldIsTooBigMsg: (fieldName: String, charLimit: Int) -> String
        get() = { fieldName, charLimit ->
            //TODO Так в текущей реализации:
//            "Необходимо сократить длину реквизита $fieldName. Длина не может превышать $charLimit"
            //TODO Так должно быть по ТЗ:
            "Измените значение реквизита $fieldName. Длина реквизита не может быть больше $charLimit"
        }
    val getFieldHasForbiddenSymbolsMsg: (fieldName: String, forbiddenSymbols: String) -> String
        get() = { fieldName, forbiddenSymbols ->
            val expForbiddenSymbols = if (forbiddenSymbols.length > 1)
                forbiddenSymbols.toCharArray().joinToString(separator = ";")
            else forbiddenSymbols

            "Необходимо удалить в реквизите $fieldName все недопустимые символы (недопустимые символы: $expForbiddenSymbols)"
        }
}