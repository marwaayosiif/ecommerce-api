package gov.iti.jets.services.clerk.dto;

public class ClerkPostRequest {
    private String name;

    public ClerkPostRequest() {
    }

    public ClerkPostRequest( String name ) {
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
        return "ClerkPostRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
