package framework.interfaces;

import java.util.Map;

public interface IApiAutomation {
    void setBaseUrl(String url, Map<String,String> headers);
    void getRequest(String url);
    String getResponseBody();
    int getResponseCode();
    void closeRequest();
}
