package homework04.http;


public class WebService {
    private HttpClient httpClient;

    public WebService(HttpClient httpClient) {
         this. httpClient = httpClient;
    }


    public String fetchDataFromWebsite(String url) {
        return httpClient.getUrl(url);
    }
}
