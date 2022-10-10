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

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Tenali Ramakrishna")
                .gender("male")
                .email(email)
                .status("active")
                .build();
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

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Sharada Devi")
                .gender("female")
                .email(email)
                .status("active")
                .build();

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
