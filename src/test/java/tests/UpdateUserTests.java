package tests;


import models.update_user.SuccessfulUpdateUserDataRequestModel;
import models.update_user.SuccessfulUpdateUserDataResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static data.TestData.UPDATE_CONTEXT;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@DisplayName("[API] Тесты по обновлению данных пользователя")
public class UpdateUserTests extends TestBase {

    @Test
    @DisplayName("[API] Успешное обновление данных пользователя")
    public void successfulUpdateUserDataTest() {
        SuccessfulUpdateUserDataRequestModel requestData =
                new SuccessfulUpdateUserDataRequestModel(userName, userJob);

        Instant beforeRequestTime = Instant.now();
        SuccessfulUpdateUserDataResponseModel responseData = api.updateUsers.updateUser(requestData);
        Instant afterRequestTime = Instant.now();

        step("Проверка успешного обновления данных пользователя", () -> {
            assertThat(responseData.name(), is(requestData.name()));
            assertThat(responseData.job(), is(requestData.job()));
            assertThat(responseData.updatedAt(), is(notNullValue()));
            assertThat(responseData.updatedAt(), is(greaterThanOrEqualTo(beforeRequestTime)));
            assertThat(responseData.updatedAt(), is(lessThanOrEqualTo(afterRequestTime)));
            assertThat(responseData.meta().context(), is(UPDATE_CONTEXT));
        });
    }
}
