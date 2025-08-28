package co.com.template.automation.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaSteps {

    @Then("la respuesta debe cumplir con el schema {string}")
    public void validarSchemaConArchivo(String schemaFile) {
        SerenityRest.lastResponse()
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/" + schemaFile));

        // Evidencia en el reporte Serenity
        Serenity.recordReportData()
                .withTitle("Schema Validado")
                .andContents("Validado contra schema: " + schemaFile);
    }
}