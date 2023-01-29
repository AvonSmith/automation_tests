package api.glue;

import api.specification.Spec;
import api.examples.user_controller_pojo.create_token.CreateToken;
import api.examples.user_controller_pojo.create_token.CreateTokenResponse;
import api.examples.user_controller_pojo.create_user.CreateUser;
import api.examples.user_controller_pojo.create_user.CreateUserResponse;
import api.examples.user_controller_pojo.create_user.Games;
import api.examples.user_controller_pojo.get_user_info.GetUserInfoResponse;
import api.examples.user_controller_pojo.update_user_password.UpdateUserPassword;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.FrameworkProperties;

import java.util.ArrayList;

import static constants.Constants.*;
import static io.restassured.RestAssured.given;

public class StepDefinition {

    private static FrameworkProperties properties;
    private static CreateUser user;
    private static CreateUserResponse createUserResponse;
    private static GetUserInfoResponse userInfoResponse;
    private static UpdateUserPassword updateUserPassword;

    private static String token;

    @BeforeAll
    public static void createUser() {
        properties = new FrameworkProperties();
    }

    @Then("I get user data")
    public void iGetUserData() {
        Spec.installSpecification(Spec.requestSpec(properties.getProperty(BASE_URL)), Spec.responseSpec(200));
        Spec.authWithToken(Spec.provideToken(token));
        userInfoResponse = given()
                .when()
                .get(properties.getProperty(USER))
                .then().log().body()
                .extract().as(GetUserInfoResponse.class);
        Assert.assertEquals(userInfoResponse.getLogin(), createUserResponse.getLogin());
        Assert.assertEquals(userInfoResponse.getPass(), createUserResponse.getPass());
        Assert.assertEquals(userInfoResponse.getId(), createUserResponse.getId());
    }

    @When("I create a token")
    public void iCreateAToken() {
        Spec.installSpecification(Spec.requestSpec(properties.getProperty(BASE_URL)), Spec.responseSpec(200));
        CreateToken request = CreateToken.builder().
                password(properties.getProperty(PASSWORD)).username(properties.getProperty(LOGIN)).build();
        CreateTokenResponse response = given()
                .body(request)
                .when()
                .post(properties.getProperty(TOKEN))
                .then().log().body()
                .extract().as(CreateTokenResponse.class);
        Assert.assertNotNull(response);
        token = response.getToken();
    }

    @Then("I update the password")
    public void iUpdateThePassword() {
        Spec.installSpecification(Spec.requestSpec(properties.getProperty(BASE_URL)), Spec.responseSpec(200));
        Spec.authWithToken(Spec.provideToken(token));
        updateUserPassword = new UpdateUserPassword(NEW_PASSWORD);
        Response response = given()
                .body(updateUserPassword)
                .when()
                .put(properties.getProperty(USER))
                .then().log().body()
                .extract().response();
    }

    @Given("I add a game")
    public void iAddAGame(String query) {
        Spec.installSpecification(Spec.requestSpec(properties.getProperty(BASE_URL)), Spec.responseSpec(201));
        Games gameInfo = new Games.Builder().
                company(properties.getProperty(COMPANY)).
                title(properties.getProperty(TITLE)).
                requiredAge(Boolean.valueOf(properties.getProperty(REQUIRED_AGE))).
                isFree(Boolean.valueOf(properties.getProperty(REQUIRED_AGE))).
                price(Float.valueOf(properties.getProperty(PRICE))).
                build();
        ArrayList<Games> game = new ArrayList<>();
        game.add(gameInfo);
    }

    @Given("I create a user")
    public void iCreateAUser() {
        Spec.installSpecification(Spec.requestSpec(properties.getProperty(BASE_URL)), Spec.responseSpec(201));
        user = CreateUser.builder().
                login(properties.getProperty(LOGIN)).
                pass(properties.getProperty(PASSWORD)).build();
        createUserResponse = given()
                .body(user)
                .when()
                .post(properties.getProperty(SIGN_UP))
                .then().log().all()
                .extract().body().jsonPath().getObject("register_data", CreateUserResponse.class);
        Assert.assertEquals(createUserResponse.getLogin(), properties.getProperty(LOGIN));
        Assert.assertEquals(createUserResponse.getPass(), properties.getProperty(PASSWORD));
        Assert.assertNotNull(createUserResponse.getId());
    }

    @Then("I delete the user")
    public void iDeleteTheUser() {
        Spec.installSpecification(Spec.requestSpec(properties.getProperty(BASE_URL)), Spec.responseSpec(200));
        Spec.authWithToken(Spec.provideToken(token));
        Response response = given()
                .when()
                .delete(properties.getProperty(USER))
                .then().log().body()
                .extract().response();
    }
}


