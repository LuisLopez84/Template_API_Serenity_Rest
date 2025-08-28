package co.com.template.automation.stepdefinitions;

import co.com.template.automation.utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class CommonSteps {

    @Given("el endpoint {string}")
    public void setEndpoint(String endpoint) {
        TestContext.setEndpoint(endpoint);
    }

    @When("realizo una petición GET")
    public void sendGetRequest() {
        SerenityRest.given()
                .baseUri("https://fakestoreapi.com")
                .get(TestContext.getEndpoint());
    }

    @Then("la respuesta debe tener código de estado {int}")
    public void validarStatusCode(int statusCode) {
        SerenityRest.lastResponse()
                .then()
                .statusCode(statusCode);
    }
}