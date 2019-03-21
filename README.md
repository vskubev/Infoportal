<b>Перед запуском тестов:</b>

1. В папку Java добавить папку Resources с файлом config.properties 

  Структура файла config.properties:<br>
  login = xxxx <br>
  password = xxxx <br>
  url = xxxx <br>

2. Указать путь к ChromeDriver (класс BaseTest)

При наличии прокси:

3. Установить расширение AutoAuth и авторизоваться в этом расширении
4. Указать путь к учетной записи Google Chrome для параметра options (класс BaseTest)


<b>Запуск тестов:</b>

1. По умолчанию запуск тестов осуществляется в Google Chrome
2. Все тесты хранятся в пакете "test"
