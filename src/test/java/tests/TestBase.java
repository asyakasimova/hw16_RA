package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
    }
}
