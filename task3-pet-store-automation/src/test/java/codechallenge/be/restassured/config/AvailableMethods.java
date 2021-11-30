package codechallenge.be.restassured.config;

/**
 * Enum that defines the available methods
 */
public enum AvailableMethods {
    GET,
    POST,
    PUT,
    PATCH,
    /** to run any other method available in RequestSpecification, just add it here as it appears
     *  in RequestSpecification in capital letters followed by ','.**/
    DELETE;
}
