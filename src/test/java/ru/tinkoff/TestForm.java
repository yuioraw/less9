package ru.tinkoff;



import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;



public class TestForm {
    @Test
    void fillFromTest() {
        //открываем страницу с формой в браузере
        open("https://demoqa.com/automation-practice-form");
        //заполняем текстовое поле имя
        $("#firstName").setValue("Andrey");
        //заполняем текстовое поле фамилия
        $("#lastName").setValue("Telezhenko");
        //заполняем текстовое поле эл.адреса
        $("#userEmail").setValue("andrey@telezhenko.ru");
        //кликаем на радоио-батн
        //$("[for='gender-radio-2']").click();
        $(byText("Male")).click();
        //заполняем текстовое поле телефон
        $("#userNumber").setValue("9003153220");
        //кликаем на поле дата чтобы всплыл календарь
        $("#dateOfBirthInput").click();
        //выбор года из календаря
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        //выбор месяца из календаря
        $(".react-datepicker__month-select").selectOptionByValue("5");
        //выбор даты из календаря. клик на дату
        $(".react-datepicker__day--006").click();
        //заполнение поля сабджект тегом. выбор значения. клик для ввода значения
        $("#subjectsInput").setValue("Economics").pressEnter();
        //выбор чек-бокса
        $("[for='hobbies-checkbox-1']").click();
        //загрузка файла текстовый файл в идеа
        ///селектор на загрузку файла по указанному пути
        $("#uploadPicture").uploadFile(new File("src/test/down.load"));
        //заполняем текстовое поле адрес
        $("#currentAddress").setValue("Penza");
        //выбор из выпадающего списка с указанием значения клик на выбранное значение
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        //клик по итоговой кнопке
        $("#submit").click();

        //проверка формы
        $(".modal-content").shouldHave(
                text("Student Name"), text("Andrey Telezhenko"),
                text("Student Email"), text("andrey@telezhenko.ru"),
                text("Gender"), text("Male"),
                text("Mobile"), text("9003153220"),
                text("Date of Birth"), text("06 June,1991"),
                text("Subjects"), text("Economics"),
                text("Hobbies"), text("Sports"),
                text("Picture"), text("down.load"),
                text("Address"), text("Penza"),
                text("State and City"), text("Haryana Karnal")
        );
    }
}


