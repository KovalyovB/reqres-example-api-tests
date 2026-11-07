package api;

import io.qameta.allure.Step;
import models.update_user.SuccessfulUpdateUserDataRequestModel;
import models.update_user.SuccessfulUpdateUserDataResponseModel;

import static io.restassured.RestAssured.given;
import static specs.UpdateUserSpec.successfulUpdateUserRequestSpec;
import static specs.UpdateUserSpec.successfulUpdateUserResponseSpec;

public class UpdateUserApiClient {

    @Step("Запрос на обновление пользователя")
    public SuccessfulUpdateUserDataResponseModel updateUser(SuccessfulUpdateUserDataRequestModel body) {
        return given(successfulUpdateUserRequestSpec)
                .body(body)
                .when()
                .delete("/api/users/2")
                .then()
                .spec(successfulUpdateUserResponseSpec)
                .extract()
                .as(SuccessfulUpdateUserDataResponseModel.class);
    }
}
