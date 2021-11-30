package codechallenge.be.cucumber.serenityDefinitions;

import codechallenge.be.restassured.config.APIPath;
import codechallenge.be.restassured.config.TestDataBuild;
import codechallenge.be.restassured.support.ServicesSupport;
import codechallenge.be.restassured.support.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class PetStoreDefinition {

    RequestSpecification req;
    ResponseSpecification res;
    Response response;

    @Given("Pet Payload {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void addProductPayload(String id, String name, String status, String categoryId, String categoryName, String tagId, String tagName, String photoUrlValue, String url) {

        req = given()
                .spec(ServicesSupport.requestSpecification(Utils.environmentVariable(url)))
                .body(TestDataBuild.petDetailsBuilder(id, name, status, categoryId, categoryName, tagId, tagName, photoUrlValue));
    }

    @When("user calls {string} with {string} http request")
    public void serCallsWithPostHttpRequest(String apiName, String protocol) {

        APIPath path = APIPath.valueOf(apiName);

        res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        if(protocol.equals("POST"))
            response = req.when()
                    .post(path.getResource());
        else if(protocol.equals("PUT"))
            response = req.when()
                    .put(path.getResource());
    }
    @Then("the API call is successful with status code {int}")
    public void theAPICallIsSuccessfulWithStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @And("checking if the {string} of the pet created is {string}")
    public void checkingTheOfTheProductCreated(String key, String check) {
        String value = Utils.getJsonPath(response, key);
        Assert.assertEquals(check,value);
    }

    @And("the count of products available  by {string} is {int}")
    public void theCountOfProductsAvailableByIs(String key, int num) {

        int check;
        if(response.jsonPath().get(key)!=null)
            check = 1;
        else
            check = 0;

        Assert.assertEquals(num, check);
    }

}
