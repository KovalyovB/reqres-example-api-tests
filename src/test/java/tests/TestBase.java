package tests;

import api.ApiClient;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    static final ApiClient api = new ApiClient();

    Integer userId;
    String userPassword;
    String userName;
    String userJob;

    @BeforeAll
    static void setupEnvironment() {
        RestAssured.baseURI = System.getProperty(
                "url",
                "https://reqres.in"
        );

        Configuration.remote = System.getProperty("remote");
    }

    @BeforeEach
    public void prepareTests() {
        Faker faker = new Faker();

        userId = faker.number().numberBetween(1, 12);
        userPassword = faker.name().firstName();
        userName = faker.name().firstName();
        userJob = faker.job().title();

    }

    void addListener() {
        SelenideLogger.addListener(
                "Allure Selenide",
                new AllureSelenide()
        );
    }
}