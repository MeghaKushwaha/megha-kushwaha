package codechallenge.be.restassured.config;

public enum APIPath {

    AddPetAPI("/pet"),
    UpdatePetAPI("/pet"),
    FindPetByStatusAPI("/pet/findByStatus"),
    FindPetByTagsAPI("/pet/findByTags"),
    FindPetById("/pet"),
    DeletePetAPI("/pet"),
    UploadImageAPI("/uploadImage");

    private String resource;

    APIPath(String resource){
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }



}
