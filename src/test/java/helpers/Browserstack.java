package helpers;


import static io.restassured.RestAssured.given;

public class Browserstack {

    //curl -u ":" -X GET "https://api.browserstack.com/app-automate/sessions/<session-id>.json"

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("kwladck_37YnDW", "kf8vRL9gFB5DEHv3Eh4L")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
