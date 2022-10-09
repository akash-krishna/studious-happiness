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
                .statusCode(200)
                .log().body();
    }
}
