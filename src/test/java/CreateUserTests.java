import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization",
                        "Bearer 04de410736692f07f5ffbcc330b725228f3c485a2d454085236449b1ec947c1a")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }

    @Test(groups = "api",description = "Should create Male user")
    public void shouldCreateMaleUser(){

        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna11\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna11@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        // 2. Act
        createUser(body)
                .then()
                .log().body()

        // 3. Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("tenali.ramakrishna11@gmail.com"))
                .body("name",Matchers.equalTo("Tenali Ramakrishna11"));


    }



    @Test(groups = "api",description = "Should create Female user")
    public void shouldCreateFemaleUser(){

        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Sharada Devi11\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"sharada.devi11@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        // 2. Act
        createUser(body)
                .then()
                .log().body()

        // 3.. Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("sharada.devi11@gmail.com"))
                .body("name",Matchers.equalTo("Sharada Devi11"));


    }
}
