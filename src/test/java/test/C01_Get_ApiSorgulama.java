package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {
    /*
        https://restful-booker.herokuapp.com/booking/9856 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
         */

    @Test
    public void get01(){

        // 1 - gonderecegimiz Request icin gerekli olan Url ve ihtiyacimiz varsa body i hazirla

        String url="https://restful-booker.herokuapp.com/booking/1599";

        // 2 - eger soruda bize verilmisse expected Datayi hazirla

        // 3 - bize donen response'i actual data olarak kaydedecegiz
        Response response= given().when().get(url);
        response.prettyPrint();
        System.out.println("Status code = "+response.getStatusCode());
        System.out.println("Content type = "+response.contentType());
        System.out.println("server in Degeri ="+response.getHeader("Server"));
        System.out.println(response.getStatusLine());
        System.out.println(response.getTime());
        // 4 - Expected Data ile Actual Datanin karsilastirilmasi  - Assertion



    }
}
