
package com.bookit.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class APIStepDefinitions {
    private Response response;
    private String token;
    private JsonPath jsonPath;
    private ContentType contentType;

    @Given("authorization token is provided for {string}")
    public void authorization_token_is_provided_for(String role) {

    }

    @Given("user accepts content type as {string}")
    public void user_accepts_content_type_as(String string) {
        if (string.toLowerCase().contains("json")) {
            contentType = ContentType.JSON;
        } else if (string.toLowerCase().contains("xml")) {
            contentType = ContentType.XML;
        }
    }

    @When("user sends GET request to {string}")
    public void user_sends_GET_request_to(String string) {
        response = given().
                accept(contentType).
                auth().oauth2(token).
                when().
                get(string).prettyPeek();
    }
}