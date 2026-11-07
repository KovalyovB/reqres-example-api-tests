package tests;

import models.create_user.SuccessfulCreateUserRequestModel;
import models.create_user.SuccessfulCreateUserResponseModel;
import models.create_user.WrongCreateUserResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.TestData.*;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DisplayName("[API] Тесты по созданию нового пользователя")
public class CreateUserTests extends TestBase {

    @Test
    @DisplayName("[API] Успешное создание нового пользователя")
    public void successfulCreateUserTest() {

        SuccessfulCreateUserRequestModel requestData = new SuccessfulCreateUserRequestModel(USER_EMAIL, userPassword);

        SuccessfulCreateUserResponseModel responseData = api.makeUsers.createUser(requestData);

        step("Проверка успешного ответа при создании нового пользователя", () -> {
            assertThat(responseData.token(), is(REGISTRATION_TOKEN));
            assertThat(responseData.support().url(), is(REGISTRATION_URL));
            assertThat(responseData.meta().context(), is(REGISTRATION_CONTEXT));
        });

    }

    @Test
    @DisplayName("[API] Проверка ошибки при создании пользователя с не валидным Email")
    public void createUserWithInvalidEmailTest() {

        SuccessfulCreateUserRequestModel requestData = new SuccessfulCreateUserRequestModel(WRONG_USER_EMAIL, userPassword);

        WrongCreateUserResponseModel responseData = api.makeUsers.createUserWithInvalidData(requestData);

        step("Проверка корректности текста ошибки по не валидному Email", () -> {
            assertThat(responseData.error(), is(REGISTRATION_EMAIL_ERROR));
        });

    }

    @Test
    @DisplayName("[API] Проверка ошибки при создании пользователя без пароля")
    public void createUserWithEmptyPasswordTest() {

        SuccessfulCreateUserRequestModel requestData = new SuccessfulCreateUserRequestModel(WRONG_USER_EMAIL, null);

        WrongCreateUserResponseModel responseData = api.makeUsers.createUserWithInvalidData(requestData);

        step("Проверка корректности текста ошибки по не валидному паролю", () -> {
            assertThat(responseData.error(), is(REGISTRATION_EMPTY_PASSWORD_ERROR));
        });

    }


}
