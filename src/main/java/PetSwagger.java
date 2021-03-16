import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.List;

public class PetSwagger {
    private int id;
    private PetCategory category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    public PetSwagger(int id, PetCategory category, String name, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.status = status;

        photoUrls = new ArrayList<>();
        tags = new ArrayList<>();
    }

    public PetSwagger() {
        id = 0;
        category = new PetCategory(1);
        name = "doggie";
        status = PetStatus.AVAILABLE.getStatus();

        photoUrls = new ArrayList<>();
        tags = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PetCategory getCategory() {
        return category;
    }

    public void setCategory(PetCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public void addPhotoUrl(String url){
//        photoUrls.add(url);
//    }
//
//    public void addTag(int id, String name) {
//        tags.add(new Tag(id, name));
//    }
}
