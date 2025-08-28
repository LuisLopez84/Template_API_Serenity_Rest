Feature: API Testing con validación de esquemas en la url https://fakestoreapi.com

  Scenario: Validar lista de productos
    Given el endpoint "/products"
    When realizo una petición GET
    Then la respuesta debe tener código de estado 200
    And la respuesta debe cumplir con el schema "products-schema.json"

  Scenario: Validar producto individual
    Given el endpoint "/products/1"
    When realizo una petición GET
    Then la respuesta debe tener código de estado 200
    And la respuesta debe cumplir con el schema "product-schema.json"

  Scenario: Validar lista de usuarios
    Given el endpoint "/users"
    When realizo una petición GET
    Then la respuesta debe tener código de estado 200
    And la respuesta debe cumplir con el schema "user-schema.json"

  Scenario: Validar lista de carritos
    Given el endpoint "/carts"
    When realizo una petición GET
    Then la respuesta debe tener código de estado 200
    And la respuesta debe cumplir con el schema "cart-schema.json"