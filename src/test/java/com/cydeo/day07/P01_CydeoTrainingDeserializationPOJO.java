package com.cydeo.day07;

import com.cydeo.utilities.CydeoTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P01_CydeoTrainingDeserializationPOJO extends CydeoTestBase {

    @DisplayName("GET /student/2")
    @Test
    public void test1(){
        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .pathParam("id", 2)
                .when().get("/student/{id}");
        //verify status code
        assertEquals(200,response.statusCode());

        JsonPath jsonPath = response.jsonPath();

        assertEquals("Mark",jsonPath.getString("students[0].firstName"));

        assertEquals(13,jsonPath.getInt("students[0].batch"));

        assertEquals("math",jsonPath.getString("students[0].major"));

        assertEquals("mark@email.com",jsonPath.getString("students[0].contact.emailAddress"));

        assertEquals("Cydeo",jsonPath.getString("students[0].company.companyName"));

        assertEquals("777 5th Ave",jsonPath.getString("students[0].company.address.street"));

        assertEquals(33222,jsonPath.getInt("students[0].company.address.zipCode"));


    }

}
