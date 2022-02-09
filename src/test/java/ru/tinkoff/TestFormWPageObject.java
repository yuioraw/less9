package ru.tinkoff;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static ru.tinkoff.TestData.*;


public class TestFormWPageObject {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll () {
        Configuration.browserSize = "1920x1080";
    }

    @Test
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


