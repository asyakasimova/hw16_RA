package tests;

import com.codeborne.selenide.Condition;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SubscriptionTests extends TestBase{

    @Test
    void testSubscriptionWithoutEmail(){
        given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .when()
                        .post("/subscribenewsletter")
                .then()
                        .statusCode(200)
                        .log().body()
                        .body("Result", is("Enter valid email"));

    }

    @Test
    void testSubscribeWithEmail() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("email", "b@b.com")
                .when()
                .post("/subscribenewsletter")
                .then()
                .statusCode(200)
                .log().body()
                .body("Success", is(true))
                .body("Result", is("Thank you for signing up! A verification email has been sent. We appreciate your interest."));
    }
}


