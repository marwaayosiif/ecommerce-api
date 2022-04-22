package gov.iti.jets.services.dto.admin;

public class AdminPostRequest {
    private String name;

    public AdminPostRequest() {
    }

    public AdminPostRequest( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AdminPostRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
