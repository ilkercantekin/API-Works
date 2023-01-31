package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class C07 {
    /*           https://jsonplaceholder.typicode.com/posts  url’ine asagidaki body ile
     bir POST request gonderdigimizde {
     "title":"API",
     "body":"API ogrenmek ne guzel",
     "userId":10,
     }
     donen Response’un, status code’unun 201,
     ve content type’inin application/json
      ve Response Body'sindeki,
       "title"'in "API"
       oldugunu "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini    test edin.

     */

    @Test
    public void posttest01(){
        String url="https://jsonplaceholder.typicode.com/posts";
        JSONObject reqBody=new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",95);
        System.out.println(reqBody);
        // 2- expect Data hazirla

        // 3 - Response i kaydet
        Response response=given().contentType("application/json").
                when().body(reqBody.toString()).get(url);
        //response.prettyPrint();
        // 4 - Assertion
        response.then().contentType(ContentType.JSON).
                statusCode(200).
                body("title", equalTo("API"),
                        "userId",lessThan(1000),
                        "body",containsString("API"));

    }

}
