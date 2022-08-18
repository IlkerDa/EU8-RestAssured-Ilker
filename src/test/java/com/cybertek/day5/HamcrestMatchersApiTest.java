package com.cybertek.day5;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersApiTest {
       /*
       given accept type is Json
       And path param id is 15
       When user sends a get request to spartans/{id}
       Then status code is 200
       And content type is Json
       And json data has following
           "id": 15,
           "name": "Meta",
           "gender": "Female",
           "phone": 1938695106
        */

    @DisplayName("OneSpartan with Hamcrest and chaining")
    @Test
    public void test1() {
        given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when()
                .get("http://44.204.228.18:8000/api/spartans/{id}")
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .contentType("application/json")
                .and()
                .body("id", equalTo(15),
                        "name", is("Meta"),
                        "gender", is("Female"),
                        "phone", is(1938695106));
    }

    @DisplayName("CBTraining Teacher request with chaining and matchers")
    @Test

    public void teacherData(){
        given()
                .accept(ContentType.JSON)
                .and().pathParam("id", 21887)
                .when()
                .get("http://api.cybertektraining.com/teacher/{id}")
                .then()
                .statusCode(200)
                .and()
                .contentType("application/json;charset=UTF-8")
                .and()
                .header("Content-Length", is("231"))
                .header("Date", notNullValue())
                .header("fjksdfdjk",nullValue())
                .and().assertThat()
                .body("teachers[0].firstName", is("Steve"))
                .body("teachers[0].lastName", is("Peter"))
                .body("teachers[0].gender", equalToIgnoringCase("male"));
    }





}
