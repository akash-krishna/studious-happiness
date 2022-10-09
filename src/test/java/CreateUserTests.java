import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserTests {

    @Test(groups = "api",description = "Should create Male user")
    public void shouldCreateMaleUser(){

        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna13\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna13@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        // 2. Act
        new UsersClient().createUser(body)
                .then()
                .log().body()

        // 3. Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("tenali.ramakrishna13@gmail.com"))
                .body("name",Matchers.equalTo("Tenali Ramakrishna13"));


    }

    @Test(groups = "api",description = "Should create Female user")
    public void shouldCreateFemaleUser(){

        // 1. Arrange
        String body = "{\n" +
                "    \"name\": \"Sharada Devi13\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"sharada.devi13@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        // 2. Act
        new UsersClient().createUser(body)
                .then()
                .log().body()

        // 3.. Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("sharada.devi13@gmail.com"))
                .body("name",Matchers.equalTo("Sharada Devi13"));


    }

}
