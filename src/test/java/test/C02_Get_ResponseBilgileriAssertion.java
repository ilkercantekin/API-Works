package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ResponseBilgileriAssertion {

    /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        oldugunu test edin.
         */
    @Test
    public void get01(){

        // 1 - gonderecegimiz Request icin gerekli olan Url ve ihtiyacimiz varsa body i hazirla
        String url="https://restful-booker.herokuapp.com/booking/15";

        // 2 - eger soruda bize verilmisse expected Datayi hazirla

        // 3 - bize donen response'i actual data olarak kaydedecegiz
        Response response= given().when().get(url);
        response.prettyPrint();

        //4 - Assertion

        System.out.println(response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","Cowboy").
                statusLine("HTTP/1.1 200 OK"));

    }
}
