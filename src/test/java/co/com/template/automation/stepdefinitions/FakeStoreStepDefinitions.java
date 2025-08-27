package co.com.template.automation.stepdefinitions;

import co.com.template.automation.models.Product;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class FakeStoreStepDefinitions {

    @When("consulto todos los productos")
    public void consulto_todos_los_productos() {
        SerenityRest.given()
                .baseUri("https://fakestoreapi.com")
                .get("/products");
    }

    @When("creo un producto con título {string} y precio {double}")
    public void creo_un_producto(String title, Double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription("Producto creado desde Serenity");
        product.setCategory("clothing");
        product.setImage("https://i.pravatar.cc");

        SerenityRest.given()
                .baseUri("https://fakestoreapi.com")
                .contentType("application/json")
                .body(product)
                .post("/products");
    }

    @When("actualizo el producto con id {int} y nuevo título {string}")
    public void actualizo_producto(int id, String newTitle) {
        Product product = new Product();
        product.setTitle(newTitle);
        product.setPrice(30.0);
        product.setDescription("Producto actualizado desde Serenity");
        product.setCategory("clothing");
        product.setImage("https://i.pravatar.cc");

        SerenityRest.given()
                .baseUri("https://fakestoreapi.com")
                .contentType("application/json")
                .body(product)
                .put("/products/" + id);
    }

    @When("elimino el producto con id {int}")
    public void elimino_producto(int id) {
        SerenityRest.given()
                .baseUri("https://fakestoreapi.com")
                .delete("/products/" + id);
    }

    @Then("la respuesta debe tener status {int}")
    public void la_respuesta_debe_tener_status(Integer status) {
        SerenityRest.lastResponse()
                .then()
                .statusCode(status);
    }
}