package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    public static Response performPost(String endPoint, String requestPayLoad, Map<String, String> headers){
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayLoad)
                .post()
                .then()
                .log().all().extract().response();
    }
    public static Response performPost(String endPoint, Map<String, Object> requestPayLoad, Map<String, String> headers){
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayLoad)
                .post()
                .then()
                .log().all().extract().response();
    }
}
