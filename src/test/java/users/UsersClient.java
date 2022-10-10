package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response createUser(CreateUserRequestBody requestBody) {
        return given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization",
                            "Bearer 04de410736692f07f5ffbcc330b725228f3c485a2d454085236449b1ec947c1a")
                    .body(requestBody)
                .when()
                    .post("https://gorest.co.in/public/v2/users");
    }

    public Response getAllUsers() {
        return given()
                .when()
                    .get("https://gorest.co.in/public/v1/users");
    }
}
