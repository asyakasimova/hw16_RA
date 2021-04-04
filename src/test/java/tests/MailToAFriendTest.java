package tests;

import api.Auth;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.containsString;

public class MailToAFriendTest extends TestBase{
    @Test
    void testMailToAFriend(){
        Map<String, String> cookies = new Auth().login("qaguru@qa.guru", "qaguru@qa.guru1");
        Response response = given()
                                    .formParam("FriendEmail", "a@a.com")
                                    .formParam("YourEmailAddress", "qaguru@qa.guru")
                                    .formParam("PersonalMessage", "LOOOK!!!")
                                    .formParam("send-email", true)
                                    .cookies(cookies)
                               .when()
                                    .post("http://demowebshop.tricentis.com/productemailafriend/74")
                               .then()
                                    .log().body()
                                    .statusCode(200)
                                    .extract().response();

        assertThat(response.asString(), containsString("Your message has been sent"));;
    }
}
