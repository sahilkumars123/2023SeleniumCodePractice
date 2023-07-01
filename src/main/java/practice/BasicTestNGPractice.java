package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicTestNGPractice {

    @Test(dataProvider = "getData")
    public void show(String username, String password){
        System.out.println(username+" "+password);
    }

    @DataProvider(name="getData")
    public Object[][] testData(){
        Object[][] o = {
                {"Hello", "Sahil"}, {"Hello", "Sonika"}, {"Hello", "Sagar"}
        };
        return o;
    }



}
