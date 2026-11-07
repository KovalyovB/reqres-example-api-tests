package tests;

import io.restassured.response.Response;
import models.get_user.SuccessfulGetSingleUserResponseModel;
import models.get_user.SuccessfulGetUserRequestModel;
import models.get_user.SuccessfulGetListOfUserResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.TestData.API_KEY;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

@DisplayName("[API] Тесты получения списка пользователей")
public class GetUsersTests extends TestBase {

    @Test
    @DisplayName("[API] Получение списка пользователей (страница по умолчанию)")
    public void successfulGetRandomListOfUsersTest() {
        SuccessfulGetUserRequestModel requestData = new SuccessfulGetUserRequestModel(API_KEY);

        SuccessfulGetListOfUserResponseModel responseData = api.getUsers.getListOfUser(requestData);

        step("Проверка возврата 1 страницы пользователей по умолчанию", () -> {
            assertThat(responseData.page(), is(1));
        });
    }

    @Test
    @DisplayName("[API] Получение пользователя по ID")
    public void successfulGetUserTest() {
        SuccessfulGetUserRequestModel requestData = new SuccessfulGetUserRequestModel(API_KEY);

        SuccessfulGetSingleUserResponseModel responseData = api.getUsers.getUser(requestData, userId);

        step("Проверка возврата данных по пользователю с ID=" + userId, () -> {
            assertThat(responseData.data().id(), is(userId));
        });
    }

    @Test
    @DisplayName("[API] Проверка возврата ошибки при использовании некорректного метода в запросе")
    public void wrongGetRandomListOfUsersMethodTest() {
        SuccessfulGetUserRequestModel requestData = new SuccessfulGetUserRequestModel(API_KEY);

        Response responseData = api.getUsers.getListOfUserWithWrongMethod(requestData);

        step("Проверка отсутствия параметра page в ответе", () -> {
            assertThat(responseData.asString()).contains("Page Not Found");
        });
    }
}
