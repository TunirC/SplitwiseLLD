package Entities;

public class User {
    private String userId;
    private String userName;
    private String phone;
    private String emailId;

    public User(String userId, String userName, String phone, String emailId) {
        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
        this.emailId = emailId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
