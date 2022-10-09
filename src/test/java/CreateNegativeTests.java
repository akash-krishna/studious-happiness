import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateNegativeTests {

    @Test(groups = "api",description = "Should not create user for invalid email format")
    public void shouldNotCreateForInvalidEmailFormat(){

        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna11\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna11gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        // 2. Act
        new UsersClient().createUser(body)
                .then()
                .log().body()

                // 3. Assert
                .statusCode(422)
                .body("", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));

    }
}
