package Data;

import org.testng.annotations.DataProvider;

public class DataForTests {


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

    @DataProvider (name = "DeleteData")
    public Object[] dataDelete () {
        return new Object[] {
                4, 5,6,7
        };
    }


}
