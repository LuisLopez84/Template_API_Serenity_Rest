package co.com.template.automation.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaSteps {

    @Then("la respuesta debe cumplir con el schema {string}")
    public void validarSchema(String schemaName) {
        SerenityRest.lastResponse()
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/" + schemaName));
    }
}