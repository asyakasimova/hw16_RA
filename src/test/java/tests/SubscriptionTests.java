package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
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


