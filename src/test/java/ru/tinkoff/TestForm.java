package ru.tinkoff;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static ru.tinkoff.TestData.*;




    public class TestForm {

        RegistrationPage registrationPage = new RegistrationPage();


        @Test
        @Owner("andrey")
        @DisplayName("Тест заполнения формы регистрации студента")
        @Severity(SeverityLevel.BLOCKER)
        @Link(value = "Форма регистрации", url = "https://demoqa.com/automation-practice-form")

        void fillFormTest() {

            registrationPage.openPage()
                    .setFirstName(testFirstName)
                    .setLastName(testLastName)
                    .setEmail(testEmail)
                    .selectGender(testGender)
                    .setPhone(testPhoneNumber)
                    .setSubject(testSubject)
                    .selectHobbies(testHobbyName)
                    .setAddress(testAddress)
                    .uploadFile(testFilePath)
                    .selectState(testStateName)
                    .selectCity(testCityName)
                    .calendarComponent.setDate("13","June", "1991");

            registrationPage.clickSubmit();

            registrationPage
                    .checkResultValues("Student Name", testFirstName + " " + testLastName)
                    .checkResultValues("Student Email", testEmail)
                    .checkResultValues("Gender", testGender)
                    .checkResultValues("Mobile", testPhoneNumber)
                    .checkResultValues("Date of Birth", "13 June,1991")
                    .checkResultValues("Subjects", testSubject)
                    .checkResultValues("Hobbies", testHobbyName)
                    .checkResultValues("Picture", "test.png")
                    .checkResultValues("Address", testAddress)
                    .checkResultValues("State and City",testStateName + " " + testCityName);
        }
    }