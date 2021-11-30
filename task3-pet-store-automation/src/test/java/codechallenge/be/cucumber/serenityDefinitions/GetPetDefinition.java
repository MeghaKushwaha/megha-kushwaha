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

public class GetPetDefinition {
    RequestSpecification req;
    ResponseSpecification res;
    Response response;

    @Given("user sets base url {string}")
    public void userSetsBaseUrl(String url) {
        req = given()
                .spec(ServicesSupport.requestSpecification(Utils.environmentVariable(url)))
                .header("accept", "application/xml");
    }

    @When("user calls GetPetAPI {string} with {string} http request for pet id {string}")
    public void userCallsWithHttpRequest(String apiName, String protocol, String id) {

        APIPath path = APIPath.valueOf(apiName);

        res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
        response = req.when()
                    .get(path.getResource() + "/" + id);
    }

    @Then("Get Pet API call is successful with status code {int}")
    public void getPetAPICallIsSuccessfulWithStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @And("response message as {string}")
    public void responseMessageAs(String expectedResponseMessage) {
        String responseMessage = response.body().asString();
        Assert.assertEquals(expectedResponseMessage, responseMessage);
    }

    @When("user calls GetPetAPI {string} with {string} http request")
    public void userCallsGetPetAPIWithHttpRequest(String apiName, String protocol) {
        APIPath path = APIPath.valueOf(apiName);

        res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
        response = req.when()
                .get(path.getResource());
    }

    @Given("user sets base url {string} with query parameters as {string} and {string}")
    public void userSetsBaseUrlWithQueryParametersAsAnd(String url, String key, String value) {
        req = given()
                .spec(ServicesSupport.requestSpecification(Utils.environmentVariable(url)))
                .header("accept", "application/xml")
                .queryParam(key, value);
    }
}
