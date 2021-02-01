package Data;

import Data.DataForTests;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataDrivenExample extends DataForTests {

    @DataProvider(name = "DataForTest")
    public Object[][] dataForTest() {

//        Object[][] data = new Object[2][3];
//        data[0][0] = "Albert";
//        data[0][1] = "Andreevich";
//        data[0][2] = 2;
//        data[1][0] = "Thomas";
//        data[1][1] = "Test";
//        data[1][2] = 2;
//        return data;

        return new Object[][]{
                {"Graham", "Bang", 1},
                {"Yellow", "UserTeST", 2}
        };
    }

    @Test(dataProvider = "DataForTest")
    public void test_POST(String firstname, String lastname, int subjeCtID) {
        JSONObject request = new JSONObject();
        request.put("firstname", firstname);
        request.put("lastname", lastname);
        request.put("subjectID", subjeCtID);
        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when().post("/users")
                .then().statusCode(201).log().all();
    }

    @DataProvider(name = "DeleteData")
    public Object[] dataDelete () {
        return new Object[] {
                4, 5,6,7
        };
    }

    @Test (dataProvider = "DeleteData")
    public void test_DELETE(int userID) {
        baseURI = "http://localhost:3000";
        when().delete("/users/" + userID).then().statusCode(200);
    }

    @Parameters({"userID"})
    @Test
    public void test_DELETE2(int userID) {
        System.out.println("value for userID is" + userID);
        baseURI = "http://localhost:3000";
        when().delete("/users/" + userID).then().statusCode(200);

    }
}
