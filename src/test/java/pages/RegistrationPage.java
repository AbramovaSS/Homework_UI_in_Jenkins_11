package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.TableResponsiveComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityDropdown = $("#city"),
            submit = $("#submit"),
            modalDialog = $(".modal-dialog"),
            closeModal = $("#closeLargeModal");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableResponsiveComponent tableResponsiveComponent = new TableResponsiveComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    @Step("Ввести имя \"{value}\" в поле first name")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Ввести фамилию \"{value}\" в поле last name")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Ввести email \"{value}\" в поле email")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Выбрать пол \"{value}\" в поле gender")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Ввести номер телефона \"{value}\" в поле mobile number")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Нажать на поле date of birth и выбрать дату рождения {day} {month} {year} ")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Выбрать предмет \"{value}\" в поле Subjects")
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Выбрать увлечение \"{value}\" в поле Hobbies")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Нажать на кнопку \"Выберите файл\" и загрузить картинку")
    public RegistrationPage setUploadPicture(String filePath) {
        uploadPicture.uploadFromClasspath(filePath);

        return this;
    }

    @Step("Ввести адрес \"{value}\" в поле Current Address")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Нажать на поле Select State")
    public RegistrationPage setStateDropdown() {
        stateDropdown.click();

        return this;
    }

    @Step("Выбрать \"{value}\"")
    public RegistrationPage setStateCityWrapper(String value) {
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Нажать на поле Select City")
    public RegistrationPage setCityDropdown() {
        cityDropdown.click();

        return this;
    }

    @Step("Нажать на кнопку Submit")
    public RegistrationPage setSubmit() {
        submit.click();

        return this;
    }

    public RegistrationPage setModalDialog() {
        modalDialog.should(appear);

        return this;
    }

    @Step("Проверить, что \"{key}\" соответствует \"{value}\"")
    public RegistrationPage checkResult(String key, String value) {
        tableResponsiveComponent.setTable(key, value);

        return this;
    }

    public RegistrationPage closeModal() {
        closeModal.click();

        return this;
    }
}



