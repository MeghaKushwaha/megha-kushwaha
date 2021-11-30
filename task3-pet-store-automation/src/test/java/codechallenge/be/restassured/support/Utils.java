package codechallenge.be.restassured.support;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Utils {

    public static String getJsonPath(Response response, String key){
        String res = response.asString();
        JsonPath js = new JsonPath(res);

        return js.get(key).toString();
    }

    public static String environmentVariable(String key){

        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

        return variables.getProperty(key);
    }

}
