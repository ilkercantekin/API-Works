package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThan;


public class C06_Post_ResponseBodyTesti {
     /*  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
      */

    @Test
    public void post01() {
        //1- url ve body hazirla
        String url = "https://jsonplaceholder.typicode.com/posts";
        JSONObject reqBody = new JSONObject();
        reqBody.put("title", "API");
        reqBody.put("body", "API ogrenmek ne guzel");
        reqBody.put("userId", 10);
        // System.out.println(reqBody);   testte bir kere yazip kontrol edilince sonrakilaerde calistirilmaz

        // 2- expected data hazirla ama yok simdilik

        // 3 - response kaydet

        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                post(url);
        // response.prettyPrint();   testte bir kere yazip kontrol edilince sonrakilaerde calistirilmaz

        // 4 - Asertion
        response.then().assertThat().statusCode(201).contentType("application/json").
                body("title", Matchers.equalTo("API")).
                body("userId", lessThan(100)).
                body("body", Matchers.containsString("API"));


    }


     /*  https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }
        donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
      */

        @Test
        public void post02(){
            //1- url ve body hazirla
            String url = "https://jsonplaceholder.typicode.com/posts";
            JSONObject reqBody = new JSONObject();
            reqBody.put("title", "API");
            reqBody.put("body", "API ogrenmek ne guzel");
            reqBody.put("userId", 10);
            // System.out.println(reqBody);  // testte bir kere yazip kontrol edilince sonrakilaerde calistirilmaz

            // 2- expected data hazirla ama yok simdilik

            // 3 - response kaydet

            Response response = given().
                    contentType(ContentType.JSON).
                    when().
                    body(reqBody.toString()).
                    post(url);
             //response.prettyPrint();   //testte bir kere yazip kontrol edilince sonrakilaerde calistirilmaz

            // 4 - Asertion
            response.then().assertThat().statusCode(201).contentType("application/json").
                    body("title", equalTo("API"),
                    "userId", lessThan(100),
                    "body",containsString("API"));
        }
    }
