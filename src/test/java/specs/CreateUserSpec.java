package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;
import static specs.BaseSpec.baseRequestSpec;

public class CreateUserSpec {

    public static RequestSpecification successfulCreateUserRequestSpec = baseRequestSpec;
    public static RequestSpecification wrongCreateUserInvalidDataRequestSpec = baseRequestSpec;


    public static ResponseSpecification successfulCreateUserResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath
                    ("schemas/create_user/successful_create_user_response_schema.json"))
            .expectBody("id", notNullValue())
            .expectBody("token", notNullValue())
            .expectBody("support", notNullValue())
            .expectBody("_meta", notNullValue())
            .build();

    public static ResponseSpecification wrongCreateUserInvalidDataResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(400)
            .expectBody(matchesJsonSchemaInClasspath
                    ("schemas/create_user/wrong_create_user_invalid_data_response_schema.json"))
            .expectBody("error", notNullValue())
            .build();
}
