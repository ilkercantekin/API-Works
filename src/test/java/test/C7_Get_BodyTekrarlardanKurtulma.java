package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C7_Get_BodyTekrarlardanKurtulma {
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
 	status code’unun 200,
	ve content type’inin application-json,
	ve response body’sindeki
		"firstname“in,"Susan",
		ve "lastname“in, "Jackson",
	ve "totalprice“in,612,
	ve "depositpaid“in,false,
	ve "additionalneeds“in,"Breakfast"
oldugunu test edin

     */
    @Test
    public void test01(){

        // 1- url
        String url="https://restful-booker.herokuapp.com/booking/10";

        // 2- expected data


        //3- response kaydet
        Response response=given().contentType(ContentType.JSON).when().get(url);
        response.prettyPrint();
        // 4- assertion
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).body("firstname",Matchers.equalTo("Eric"),
                "lastname",Matchers.equalTo("Ericsson"),"totalprice",Matchers.equalTo(639),"depositpaid",Matchers.equalTo(false),
                "additionalneeds",Matchers.equalTo("Breakfast"),"bookingdates.checkin",Matchers.equalTo("2016-12-01"),"bookingdates.checkout",Matchers.equalTo("2022-10-15"));



    }

}
