##Проект автотестов для системы SALTO
- Git-репозиторий: [https://gerrit.jtc.ooo/admin/repos/salto-autotest](https://gerrit.jtc.ooo/admin/repos/salto-autotest)
- Основной раздел в [Conflience](https://confluence.jtc.ooo/pages/viewpage.action?pageId=21727010)

###Системные требования
- Java 8+
- Maven

###Компиляция проекта
Для разрешения используемых в проекте зависимостей, необходимо для Maven'a указать файл `settings.xml` (в корне проекта).
Это можно сделать скопировав его в папку `<Папка пользователя>\.m2\`.

###Запуск тестов из командной строки
осуществляется по тегам или ID тест кейсов из [ТМС](https://jira.jtc.ooo/secure/Tests.jspa#/design?projectId=10301).
Теги разделены на 2 списка [BeTags](box-tests/src/test/java/ooo/jtc/BeTags.kt) 
и [UiTags](box-tests/src/test/java/ooo/jtc/UiTags.kt) .  

Запуск выполняется командой `mvn test -Dtags=тут_желаемые,теги,можно_несколько,через_запятую -Dl4j=file`
