import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Examples {

    @Test
    public void test_GET() {
        baseURI = "http://localhost:3000";
        given().param("name", "automation")
                .get("/subjects")
                .then().statusCode(200).log().all();
    }

    @Test
    public void test_POST() {
        JSONObject request = new JSONObject();
        request.put("firstname", "Tom");
        request.put("lastname", "Vasylenko");
        request.put("subjectID", 1);
        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when().post("/users")
                .then().statusCode(201).log().all();
    }

    @Test
    public void test_PATCH() {
        JSONObject request = new JSONObject();
        request.put("lastname", "Shefered");
        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when().patch("/users/4")
                .then().statusCode(200).log().all();

    }

    @Test
    public void test_PUT() {
        JSONObject request = new JSONObject();
        request.put("firstname", "Mary");
        request.put("lastname", "Popens");
        request.put("subjectID", 1);
        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when().put("/users/4")
                .then().statusCode(200).log().all();
    }

    @Test
    public void test_DELETE() {
        baseURI = "http://localhost:3000";
        when().delete("/users/4").then().statusCode(200);

    }
}
