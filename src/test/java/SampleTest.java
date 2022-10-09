import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTest {
    @Test(groups = "api",description = "Should get all users")
    public void shouldGetAllUsers(){

     // 1. Arrange
     // 2. Act
     // 3. Assert

        //can add mandatory header
        given()
                .when()
                    .get("https://gorest.co.in/public/v1/users")
                .then()
                    .log().body()
                    .statusCode(200)
                    .body("data",Matchers.hasSize(10))
                    .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
        ;

    }

    @Test(groups = "api",description = "Should create user")
    public void shouldCreateUser(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization",
                        "Bearer 04de410736692f07f5ffbcc330b725228f3c485a2d454085236449b1ec947c1a")
                .body("{\n" +
                        "    \"name\": \"Tenali Ramakrishna3\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"email\": \"tenali.ramakrishna@15126.com\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when()
                    .post("https://gorest.co.in/public/v2/users")
                .then()
                    .log().body()
                    .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("tenali.ramakrishna@15126.com"))
                .body("name",Matchers.equalTo("Tenali Ramakrishna3"));


    }
}
