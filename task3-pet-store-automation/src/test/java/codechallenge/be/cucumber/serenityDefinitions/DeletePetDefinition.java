package codechallenge.be.cucumber.serenityDefinitions;

import codechallenge.be.restassured.config.APIPath;
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

public class DeletePetDefinition {

    RequestSpecification req;
    ResponseSpecification res;
    Response response;

    @Given("user sets Delete API base url {string}")
    public void userSetsBaseUrl(String url) {
        req = given()
                .spec(ServicesSupport.requestSpecification(Utils.environmentVariable(url)))
                .header("accept", "application/xml");
    }

    @When("user calls DeletePetAPI {string} with {string} http request for pet id {string}")
    public void userCallsWithHttpRequest(String apiName, String protocol, String id) {

        APIPath path = APIPath.valueOf(apiName);

        res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
        response = req.when()
                .delete(path.getResource() + "/" + id);
    }

    @Then("Delete Pet API call is successful with status code {int}")
    public void getPetAPICallIsSuccessfulWithStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @And("delete api response message as {string}")
    public void deleteApiResponseMessageAs(String expectedResponseMessage) {
        String responseMessage = response.body().asString();
        Assert.assertEquals(expectedResponseMessage, responseMessage);
    }
}
