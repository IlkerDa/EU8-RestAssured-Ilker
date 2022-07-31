package com.cybertek.utilities;

import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.baseURI;

public abstract class HRTestBase {
    @BeforeAll
    public static void init(){
        baseURI = "http://44.204.228.18:1000/ords/hr";
    }

}
