import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

import java.util.UUID;

public class CreateUserTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test(groups = "api",description = "Should create Male user")
    public void shouldCreateMaleUser(){

        // 1. Arrange

        String email = String.format("%s@gmail.com", UUID.randomUUID());

        String name = "Tenali Ramakrishna";
        String gender = "male";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        // 2. Act
        usersClient
                .createUser(requestBody)
                .then()
                .log().body()

        // 3. Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo(email))
                .body("name",Matchers.equalTo("Tenali Ramakrishna"));


    }

    @Test(groups = "api",description = "Should create Female user")
    public void shouldCreateFemaleUser(){

        // 1. Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());

        String name = "Sharada Devi";
        String gender = "female";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        // 2. Act
        usersClient
                .createUser(requestBody)
                .then()
                .log().body()

        // 3.. Assert
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo(email))
                .body("name",Matchers.equalTo("Sharada Devi"));


    }

}
