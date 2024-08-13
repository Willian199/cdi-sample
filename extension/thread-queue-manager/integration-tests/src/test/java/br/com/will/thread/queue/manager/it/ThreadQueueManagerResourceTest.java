package br.com.will.thread.queue.manager.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ThreadQueueManagerResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/thread-queue-manager")
                .then()
                .statusCode(200)
                .body(is("Hello thread-queue-manager"));
    }
}
