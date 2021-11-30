package codechallenge.be.restassured.config;

import codechallenge.be.restassured.model.Category;
import codechallenge.be.restassured.model.PetDetails;
import codechallenge.be.restassured.model.Tags;


public class TestDataBuild {


    public static PetDetails petDetailsBuilder(String id, String name, String status, String categoryId, String categoryName, String tagId, String tagName, String photoUrlValue){

        PetDetails petDetails = new PetDetails();
        petDetails.setId(id);
        petDetails.setName(name);
        petDetails.setStatus(status);

        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        petDetails.setCategory(category);

        Tags tags = new Tags();
        tags.setId(tagId);
        tags.setName(tagName);
        Tags[] tags1 = {tags};
        petDetails.setTags(tags1);

        String[] photoUrls = {photoUrlValue};
        petDetails.setPhotoUrls(photoUrls);

        return petDetails;
    }
}
