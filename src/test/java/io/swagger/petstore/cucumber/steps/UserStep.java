package io.swagger.petstore.cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.petstoreinfo.UserSteps;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class UserStep {

    static int id = 9;
    static String username = "Paresh";
    static String firstName = "Kashi";
    static String lastName = "Patel";

    static String email = "krisha@gmail.com";
    static String password = "krisha123";
    static String phone = "07896584758";
    static int userStatus = 0;
    static ValidatableResponse response;
    @Steps
    UserSteps userSteps;

    @When("^User send a post request to create user$")
    public void userSendAPostRequestToCreateUser() {
        response=userSteps.createUser(id,username,firstName,lastName,email,password,phone,userStatus);

    }

    @Then("^User must be created and validate the response$")
    public void userMustBeCreatedAndValidateTheResponse() {
        response.statusCode(200);
    }

    @When("^User send a get request with username$")
    public void userSendAGetRequestWithUsername() {
        HashMap<String,Object> userMap    =  userSteps.getUserdetailsByUserName(username);
        Assert.assertThat(userMap,hasValue(username));

    }

    @Then("^User should get data of created user and validate response code$")
    public void userShouldGetDataOfCreatedUserAndValidateResponseCode() {
        response.statusCode(200);
    }

    @When("^User send a Put request to upgate user$")
    public void userSendAPutRequestToUpdateUser() { username=username+"_add";
      //  response=userSteps.getUserByUserName(id,username,firstName,lastName,email,password,phone,userStatus);
    }

    @Then("^User suould see updated user and validate response$")
    public void userSuouldSeeUpdatedUserAndValidateResponse() {
    }

    @When("^User send a delete request$")
    public void userSendADeleteRequest() {
    }

    @Then("^User should see user is deleted and check status code$")
    public void userShouldSeeUserIsDeletedAndCheckStatusCode() {
    }
}
