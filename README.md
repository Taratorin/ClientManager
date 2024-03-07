# Контроллер Клиентов
***
Описание эндпоинтов
***
### Создание клиента
Создает нового клиента в базе данных.

URL: /clients
Метод: POST
Тело запроса: JSON объект с данными нового клиента:

{
"email": "string",
"phone": "string"
}

Успешный ответ: 201 CREATED

Тело ответа: JSON объект с данными созданного клиента.
***

### Добавление контактов клиенту
Добавляет контакты (электронная почта и/или номер телефона) клиенту по его идентификатору.

URL: /clients/{clientId}

Метод: PATCH

Параметры пути: {clientId} - идентификатор клиента.

Параметры запроса: phone (опционально) - телефон клиента и email (опционально) - адрес электронной почты клиента.

Успешный ответ: 200 OK

Тело ответа: JSON объект с данными клиента с обновленными контактами.

***
### Получение списка всех клиентов
Возвращает список всех клиентов, имеющихся в базе данных.

URL: /clients

Метод: GET

Успешный ответ: 200 OK

Тело ответа: JSON массив с данными всех клиентов.

***
### Получение клиента по идентификатору
Возвращает данные клиента по его идентификатору.

URL: /clients/{clientId}

Метод: GET

Параметры пути: {clientId} - идентификатор клиента.

Успешный ответ: 200 OK

Тело ответа: JSON объект с данными клиента.
***

### Получение контактов клиента заданного типа
Возвращает контакты клиента заданного типа (почта или телефон) по идентификатору клиента.

URL: /clients/{clientId}/contacts

Метод: GET

Параметры пути: {clientId} - идентификатор клиента.

Параметры запроса:  type - тип контакта (почта или телефон EMAIL или PHONE соответственно).

Успешный ответ: 200 OK

Тело ответа: JSON объект с контактами клиента заданного типа.