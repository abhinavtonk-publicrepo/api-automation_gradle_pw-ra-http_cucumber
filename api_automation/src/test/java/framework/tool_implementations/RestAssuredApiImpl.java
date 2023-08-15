package framework.tool_implementations;

import framework.interfaces.IApiAutomation;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestAssuredApiImpl implements IApiAutomation {
    RequestSpecification requestSpecification;
    Response response;
    @Override
    public void setBaseUrl(String url, Map<String, String> headers) {
        RestAssured.baseURI = url;
        requestSpecification = RestAssured.given();
    }

    @Override
    public void getRequest(String url) {
        response = requestSpecification.request(Method.GET, url);
    }

    @Override
    public String getResponseBody() {
        return response.body().asString(); //response.body().toString() will not work
    }

    @Override
    public int getResponseCode() {
        return response.getStatusCode();
    }

    @Override
    public void closeRequest() {

    }
}
