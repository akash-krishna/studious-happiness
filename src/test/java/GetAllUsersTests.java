import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsersTests {
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

}
