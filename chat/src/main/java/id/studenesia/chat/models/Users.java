package id.studenesia.chat.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "users")
public class Users {

    @Id
    private long id;
    private String username;
    private String phone_number;
    private boolean status_online;
    private String profile_img;
    private String bio;
    private String birthday;
    private String friendlist;

    @Field("status_daily")
    private List<StatusDaily> status_daily;

    public Users() {

    }

    public Users(Long id, String username, String phone_number, boolean status_online, String profile_img, String bio,
            String birthday, String friendlist, List<StatusDaily> status_daily) {
        this.id = id;
        this.username = username;
        this.phone_number = phone_number;
        this.status_online = status_online;
        this.profile_img = profile_img;
        this.bio = bio;
        this.birthday = birthday;
        this.friendlist = friendlist;
        this.status_daily = status_daily;
    }

    public List<StatusDaily> getStatus_daily() {
        return status_daily;
    }

    public void setStatus_daily(List<StatusDaily> status_daily) {
        this.status_daily = status_daily;
    }

    public String getFriendlist() {
        return friendlist;
    }

    public void setFriendlist(String friendlist) {
        this.friendlist = friendlist;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public boolean isStatus_online() {
        return status_online;
    }

    public void setStatus_online(boolean status_online) {
        this.status_online = status_online;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
