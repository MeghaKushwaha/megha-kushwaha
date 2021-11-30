package codechallenge.be.restassured.support;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Helper class to test APIs
 * Use this class if you prefer to avoid the use of Reflections
 *
 */
public class ServicesSupport {

    public static RequestSpecification req;

    /**
     * Converts an Input Stream to a JSON object
     *
     * @param is Input Stream to be converted (a JSON file in the project)
     * @return JSON object
     */
    public JSONObject jsonInputStreamToJsonObject(InputStream is) throws IOException {
        JSONObject json;
        String jsonTxt = IOUtils.toString(is, "UTF-8");
        json = new JSONObject(jsonTxt);
        return json;
    }

    public static RequestSpecification requestSpecification(String baseUrl){

        req = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setContentType(ContentType.JSON)
                .build();

        return req;
    }

}