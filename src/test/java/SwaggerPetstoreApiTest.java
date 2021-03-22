import io.restassured.internal.mapping.JsonbMapper;
import netscape.javascript.JSObject;
import org.apache.groovy.json.internal.JsonFastParser;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SwaggerPetstoreApiTest {
    final int ID = 1;
    final String NAME = "xaxa";

    PetCategory petCategory = new PetCategory(1);
    PetSwagger test_pet = new PetSwagger(ID, petCategory, NAME, PetStatus.AVAILABLE.getStatus());

    @Test
    public void testUpdatePet() {
        PetSwagger returnPet =
        given().
                contentType("application/json").
                body(test_pet).
        when().
                put("https://petstore.swagger.io/v2/pet").
        as(PetSwagger.class);

        assertThat(test_pet.getId(), equalTo(returnPet.getId()));
        assertThat(test_pet.getCategory(), equalTo(returnPet.getCategory()));
        assertThat(test_pet.getName(), equalTo(returnPet.getName()));
        assertThat(test_pet.getStatus(), equalTo(returnPet.getStatus()));
    }

    @Test
    public void testGetPet() {
        given().
        when().
                get("https://petstore.swagger.io/v2/pet/" + ID)
        .then()
                .statusCode(200);
    }

    @Test
    public void testUploadImage(){
        File file_image = new File("C:/Programming/Java/TESTING/rest_testing/src/main/resources/testimage.jpg");

        given().
                contentType("multipart/form-data").
                multiPart(file_image).
        when().
                post("https://petstore.swagger.io/v2/pet/"+ID+"/uploadImage").
        then().statusCode(200);
    }
}
