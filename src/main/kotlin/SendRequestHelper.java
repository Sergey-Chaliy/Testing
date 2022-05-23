import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class SendRequestHelper {

    private SendRequestHelper(){
    }

    /**
     * Метод посылает Get запрос
     * @param endPoints передаем сам запрос
     * @return
     */
    public static JsonPath sendGetRequestId(String endPoints) {
        return given()
                .accept(ContentType.ANY)
                .contentType(ContentType.JSON)
                .when()
                .get(endPoints)
                .then().statusCode(200).log().all().extract().jsonPath();
    }
}
