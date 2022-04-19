package gov.iti.jets.dto.admin;

public class AdminGetResponse {
    private String name;
    private String email;
    
    public AdminGetResponse(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public AdminGetResponse() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "AdminGetResponse [email=" + email + ", name=" + name + "]";
    }
}
