package api;

import io.qameta.allure.Step;
import models.create_user.SuccessfulCreateUserRequestModel;
import models.create_user.SuccessfulCreateUserResponseModel;
import models.create_user.WrongCreateUserResponseModel;

import static data.TestData.API_KEY;
import static io.restassured.RestAssured.given;
import static specs.CreateUserSpec.*;

public class CreateUserApiClient {

    @Step("Запрос на создание нового пользователя")
    public SuccessfulCreateUserResponseModel createUser(SuccessfulCreateUserRequestModel body) {
        return given(successfulCreateUserRequestSpec)
                .header("x-api-key", API_KEY)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/api/register")
                .then()
                .spec(successfulCreateUserResponseSpec)
                .extract()
                .as(SuccessfulCreateUserResponseModel.class);
    }

    @Step("Запрос на создание нового c не валидным Email")
    public WrongCreateUserResponseModel createUserWithInvalidData(SuccessfulCreateUserRequestModel body) {
        return given(wrongCreateUserInvalidDataRequestSpec)
                .header("x-api-key", API_KEY)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/api/register")
                .then()
                .spec(wrongCreateUserInvalidDataResponseSpec)
                .extract()
                .as(WrongCreateUserResponseModel.class);
    }
}
