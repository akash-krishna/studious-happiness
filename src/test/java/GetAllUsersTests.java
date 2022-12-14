import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

public class GetAllUsersTests {

    // 1. Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test(groups = "api",description = "Should get all users")
    public void shouldGetAllUsers(){

     // 2. Act
        usersClient
                .getAllUsers()
                    .then()
                        .log().body()

    // 3. Assert
                        .statusCode(200)
                        .body("data",Matchers.hasSize(10))
                        .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")));

    }



}
