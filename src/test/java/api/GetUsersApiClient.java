package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.get_user.SuccessfulGetSingleUserResponseModel;
import models.get_user.SuccessfulGetUserRequestModel;
import models.get_user.SuccessfulGetListOfUserResponseModel;

import static io.restassured.RestAssured.given;
import static specs.GetUsersSpec.*;

public class GetUsersApiClient {

    @Step("Запрос получение списка пользователей")
    public SuccessfulGetListOfUserResponseModel getListOfUser(SuccessfulGetUserRequestModel body) {
        return given(successfulGetListOfUsersRequestSpec)
                .body(body)
                .when()
                .get("/api/users")
                .then()
                .spec(successfulGetListOfUsersResponseSpec)
                .extract()
                .as(SuccessfulGetListOfUserResponseModel.class);
    }

    @Step("Запрос получение пользователя с ID={id}")
    public SuccessfulGetSingleUserResponseModel getUser(SuccessfulGetUserRequestModel body, Integer id) {
        return given(successfulGetSingleUserRequestSpec)
                .body(body)
                .pathParam("id", id)
                .when()
                .get("/api/users/{id}")
                .then()
                .spec(successfulGetSingleUserResponseSpec)
                .extract()
                .as(SuccessfulGetSingleUserResponseModel.class);
    }

    @Step("Запрос получение списка пользователей с не валидным методом")
    public Response getListOfUserWithWrongMethod(SuccessfulGetUserRequestModel body) {
        return given(wrongGetSingleUserMethodRequestSpec)
                .body(body)
                .when()
                .put("/api/users")
                .then()
                .spec(wrongGetListOfUsersMethodResponseSpec)
                .extract()
                .response();
    }
}
