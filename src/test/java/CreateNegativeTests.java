import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

public class CreateNegativeTests {
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test(groups = "api",description = "Should not create user for invalid email format")
    public void shouldNotCreateForInvalidEmailFormat(){

        // 1. Arrange

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Tenali Ramakrishna11")
                .gender("male")
                .email("tenali.ramakrishna11gmail.com")
                .status("active")
                .build();

        // 2. Act
        usersClient.createUser(requestBody)
                .then()
                .log().body()

                // 3. Assert
                .statusCode(422)
                .body("", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));

    }
}
