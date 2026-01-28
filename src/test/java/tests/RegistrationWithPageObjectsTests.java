package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Форма регистрации студента")
public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    @DisplayName("Проверка формы регистрации студента")
    void fillFormTest() {
        step("Открыть страницу с формой регистрации студента", () ->
            registrationPage.openPage());
        step("Заполнить форму регистрации", () -> {
            registrationPage.setFirstName("Svetlana")
                    .setLastName("Abramova")
                    .setEmail("sabramova@abrams.com")
                    .setGender("Female")
                    .setUserNumber("1234567890")
                    .setDateOfBirth("10", "January", "1994")
                    .setSubjects("Physics")
                    .setHobbies("Sports")
                    .setUploadPicture("check.PNG")
                    .setCurrentAddress("Pushkin Street 1")
                    .setStateDropdown()
                    .setStateCityWrapper("NCR")
                    .setCityDropdown()
                    .setStateCityWrapper("Delhi")
                    .setSubmit();
        });
        step("Проверить данные в открывшемся диалоговом окне", () -> {
            registrationPage.setModalDialog()
                    .checkResult("Student Name", "Svetlana Abramova")
                    .checkResult("Student Email", "sabramova@abrams.com")
                    .checkResult("Gender", "Female")
                    .checkResult("Mobile", "1234567890")
                    .checkResult("Date of Birth", "10 January,1994")
                    .checkResult("Subjects", "Physics")
                    .checkResult("Hobbies", "Sports")
                    .checkResult("Picture", "check.PNG")
                    .checkResult("Address", "Pushkin Street 1")
                    .checkResult("State and City", "NCR Delhi")
                    .checkResult("Picture", "check.PNG");
        });
        step("Закрыть диалоговое окно", () ->
            registrationPage.closeModal());
    }
}