# Тестирование заполнения формы регистрации

#### Стек проекта:
- Java
- JUnit
- Maven
- Selenium
- Allure

#### Шаги:
1. Открыть страницу https://demoqa.com/automation-practice-form 
2. Заполнить поля для регистрации пользователя: "First Name", "Last Name", "Email", "Gender", "Mobile", "Date of birth", "Subjects", "Picture", "Current Address", "Select State", "Select City".
3. Нажать кнопку "Submit".

#### Ожидаемый результат:
1. Появилось всплывающее окно с заголовком "Thanks for submitting the form".
2. В таблице на окне отображаются введенные ранее значения.

#### Запуск теста:
```
mvn clean verify
```
#### Построение отчета в Allure:
```
cd target
allure generate
allure open
```