import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class Tests_POST {

    //    @Test
    public void test_01_post() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Raghav");
        map.put("job", "Teacher");
        System.out.println(map);
        JSONObject request = new JSONObject();
        request.put("name", "Raghav");
        request.put("job", "Teacher");
        System.out.println(request);
        System.out.println(request.toJSONString());
        given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);

    }
    //    @Test
    public void test_02_put() {
        JSONObject request = new JSONObject();
        request.put("name", "Raghav");
        request.put("job", "Teacher");
        System.out.println(request);
        System.out.println(request.toJSONString());
        given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200).log().all();

    }

    //    @Test
    public void test_03_patch() {
        JSONObject request = new JSONObject();
        request.put("name", "Raghav");
        request.put("job", "Teacher");
        System.out.println(request);
        System.out.println(request.toJSONString());
        given().header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200).log().all();
    }

    @Test
    public void test_04_delete() {
        JSONObject request = new JSONObject();
        when().delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204).log().all();

    }
}
