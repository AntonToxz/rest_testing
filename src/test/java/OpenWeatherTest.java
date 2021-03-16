import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class OpenWeatherTest {
    final String OP_TOKEN = "5b23a2f84a10a47100366863650f9bbd";
    final String CITY_NAME = "Ekaterinburg";
    final String ENDPOINT_URL = "https://api.openweathermap.org/data/2.5/weather?appid="+OP_TOKEN+"&q="+CITY_NAME;

    @Test
    public void getCurrentWeatherTest(){
        when().
                get(ENDPOINT_URL).
        then().
                assertThat().body("name", equalTo(CITY_NAME));
    }

    @Test
    public void getCurrentWeatherTestV2(){
        RestAssured.get(ENDPOINT_URL).then().statusCode(200).assertThat().body("name",equalTo(CITY_NAME));
        //System.out.println(RestAssured.get(ENDPOINT_URL).andReturn().prettyPrint());
    }
}
