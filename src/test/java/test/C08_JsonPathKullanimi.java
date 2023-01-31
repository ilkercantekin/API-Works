package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_JsonPathKullanimi {
    /*
    {
"firstName":"Ahmet",
"lastName":"Bulut",
"address":{
   	"streetAddress":"Kurtulus cad.",
   	"city":"Ankara",
	"postalCode":"06100" },
"age":49,
"phoneNumbers":[
    {
       "number":"532-555 55 55",
      "type":"cep" },
    {
      "number":"0312-123 4567",
      "type":"ev " }
          ]
}

     */

    @Test
    public void test(){

        String url="https://restful-booker.herokuapp.com/booking ";






        JSONObject cepTelefonu = new JSONObject();
        cepTelefonu.put("type","Cep Telefonu");
        cepTelefonu.put("number", "555-123-4567");

        JSONObject evTel= new JSONObject();
        evTel.put("type","Ev telefonu");
        evTel.put("number","312-123-4567");

        JSONArray telBilgileri =new JSONArray();
        telBilgileri.put(cepTelefonu);
        telBilgileri.put(evTel);

        JSONObject adresBilgisi=new JSONObject();
        adresBilgisi.put("streetAddress", "Yenimahalle kurtulus cad");
        adresBilgisi.put("city","Ankara");
        adresBilgisi.put("postalCode","06100");

        JSONObject kisiBilgisi=new JSONObject();
        kisiBilgisi.put("firstName","Ahmet");
        kisiBilgisi.put("lastName","Bulut");
        kisiBilgisi.put("age",49);
        kisiBilgisi.put("address",adresBilgisi);
        kisiBilgisi.put("phoneNumbers",telBilgileri);
        System.out.println(kisiBilgisi);
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(kisiBilgisi.toString()).
                post(url);
        response.prettyPrint();


    }
}
