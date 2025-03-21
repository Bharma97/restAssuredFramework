package Airlines;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class createAirlines {

    @Test
    public void createAirline() throws IOException {
        String qa = System.getProperty("env") == null ? "qa" : System.getProperty("env");

        Map<String, String> data = JsonUtils.jsonObjectMapData("airlines/"+qa+"/airlinesAPIData.json");

        String endPoint = data.get("createAirLineEndpoint");
        Map<String, Object> requestBody= Payloads.getCreatedAirlinePaylodsFromMap("34567","Sri Lankan Airways","Sri Lanka",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka","Katunayake, Sri Lanka",
                "www.srilankaaairways.com","1990");

        Response response = RestUtils.performPost(endPoint,requestBody, new HashMap<>());
        Assert.assertEquals(response.statusCode(),200);

    }
}
