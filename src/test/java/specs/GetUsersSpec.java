package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;
import static specs.BaseSpec.baseRequestSpec;

public class GetUsersSpec {

    public static RequestSpecification successfulGetListOfUsersRequestSpec = baseRequestSpec;
    public static RequestSpecification successfulGetSingleUserRequestSpec = baseRequestSpec;
    public static RequestSpecification wrongGetSingleUserMethodRequestSpec = baseRequestSpec;

    public static ResponseSpecification successfulGetListOfUsersResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath
                    ("schemas/get_user/successful_get_list_of_users_response_schema.json"))
            .expectBody("page", notNullValue())
            .expectBody("per_page", notNullValue())
            .expectBody("total", notNullValue())
            .expectBody("total_pages", notNullValue())
            .expectBody("data", notNullValue())
            .expectBody("support", notNullValue())
            .expectBody("_meta", notNullValue())
            .build();

    public static ResponseSpecification successfulGetSingleUserResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath
                    ("schemas/get_user/successful_get_single_user_response_schema.json"))
            .expectBody("data", notNullValue())
            .expectBody("support", notNullValue())
            .expectBody("_meta", notNullValue())
            .build();

    public static ResponseSpecification wrongGetListOfUsersMethodResponseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(404)
            .build();
}


