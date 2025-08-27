package co.com.template.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.Matchers.equalTo;

public class CommonSteps {

    private String baseUrl = "https://fakestoreapi.com";
    private String endpoint;

    @Given("el endpoint {string}")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @When("realizo una petición GET")
    public void sendGetRequest() {
        SerenityRest.given()
                .baseUri(baseUrl)
                .when()
                .get(endpoint)
                .then()
                .log().all(); // opcional para debug
    }

    @Then("la respuesta debe tener código de estado {int}")
    public void validarStatusCode(int statusCode) {
        SerenityRest.lastResponse()
                .then()
                .statusCode(statusCode);
    }
}