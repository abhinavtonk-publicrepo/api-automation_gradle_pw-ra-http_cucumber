package step_defs;

import framework.interfaces.IApiAutomation;
import framework.tool_implementations.PlaywrightApiImpl;
import framework.tool_implementations.RestAssuredApiImpl;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.JsonUtil;
import utils.PlaywrightApiUtil;

import java.util.HashMap;
import java.util.Map;

public class ApiAutomation {
    IApiAutomation apiDriver;
    JsonUtil jsonUtil;
    Map<String, String> headers;

    @Before
    public void beforeScenario(){
//        apiDriver = new PlaywrightApiImpl();
        apiDriver = new RestAssuredApiImpl();
        jsonUtil = new JsonUtil();
    }

    @Given("User initializes the baseurl as {string}")
    public void userInitBaseUrl(String url){
        headers = new HashMap<>();
        headers.put("Accept", "application/json");
        apiDriver.setBaseUrl(url,headers);
    }

    @When("User fires the GET call to url {string}")
    public void userFiresGetCall(String url){
        apiDriver.getRequest(url);
    }

    @Then("User verifies the Success status code")
    public void userVerifiesStatusCode(){
        System.out.println("Response Body = " + apiDriver.getResponseBody());
        System.out.println("Response Code = " + apiDriver.getResponseCode());
    }
}
