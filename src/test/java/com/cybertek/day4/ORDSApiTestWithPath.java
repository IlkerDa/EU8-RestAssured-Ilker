package com.cybertek.day4;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import com.cybertek.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ORDSApiTestWithPath extends HRTestBase {

    @DisplayName("GET request to countries with Path method")
    @Test
    public void test1(){
        Response response= given().accept(ContentType.JSON)
                .queryParam("q","{\"region_id\":2}")
                .when()
                .get("/countries");

        assertEquals(200,response.statusCode());

        //print limit result
        System.out.println("response.path(\"limit\") = " + response.path("limit"));
        System.out.println("response.path(\"hasmore\") = " + response.path("hasmore"));
        String firstCountyId = response.path("items[0].country_id");
        System.out.println("firstCountyId = " + firstCountyId);

        System.out.println("response.path(\"items[1].country_name\") = " + response.path("items[1].country_name"));

        String thirdHref = response.path("items[2].links[0].href");
        System.out.println("thirdHref = " + thirdHref);

      List<String> countryNames = response.path("items.country_name");
        System.out.println("countryNames = " + countryNames);

    }

}
