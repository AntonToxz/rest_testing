public enum PetStatus {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("SOLD");

    private String status;

    PetStatus(String status) {
    }

    public String getStatus(){
        return status;
    }
}
