package banger.demo.Controller;

import javax.validation.constraints.NotBlank;


public class SignUpRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private String Password;
    @NotBlank
    private String age;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phone;
    @NotBlank
    private String licenseNo;
    @NotBlank
    private String nic;
    @NotBlank
    private String role;
    @NotBlank
    private Boolean isBlacklisted;


    public SignUpRequest(@NotBlank String username, @NotBlank String email, @NotBlank String password, @NotBlank String age, @NotBlank String firstName, @NotBlank String lastName, @NotBlank String phone, @NotBlank String licenseNo, @NotBlank String nic, @NotBlank String role, @NotBlank Boolean isBlacklisted) {
        this.username = username;
        this.email = email;
        Password = password;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.licenseNo = licenseNo;
        this.nic = nic;
        this.role = role;
        this.isBlacklisted = isBlacklisted;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Boolean getBlacklisted() {
        return isBlacklisted;
    }

    public void setBlacklisted(Boolean blacklisted) {
        isBlacklisted = blacklisted;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
