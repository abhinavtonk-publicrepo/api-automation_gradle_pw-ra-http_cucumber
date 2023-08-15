package framework.tool_implementations;

import com.microsoft.playwright.*;
import framework.interfaces.IApiAutomation;
import framework.interfaces.IAssertion;

import java.util.Map;

public class PlaywrightApiImpl implements IApiAutomation {
    APIRequestContext apiRequestContext;
    APIResponse response;

    @Override
    public void setBaseUrl(String url, Map<String, String> headers) {
        apiRequestContext = Playwright.create()
                .request()
                .newContext(new APIRequest.NewContextOptions().setBaseURL(url).setExtraHTTPHeaders(headers));
    }

    @Override
    public void getRequest(String url) {
        response = apiRequestContext.get(url);
    }

    @Override
    public String getResponseBody() {
        return response.text();
    }

    @Override
    public int getResponseCode() {
        return response.status();
    }

    @Override
    public void closeRequest() {

    }

}
