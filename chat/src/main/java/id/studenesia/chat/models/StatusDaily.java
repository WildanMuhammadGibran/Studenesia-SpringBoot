package id.studenesia.chat.models;

import org.springframework.data.annotation.Id;

public class StatusDaily {
    
    @Id
    private String id_status;
    
    private String content_text;
    private String content_image;
    private String content_video;
    private String date_created;
    private int likes;

    public StatusDaily() {

    }

    public StatusDaily(String id_status, String content_text, String content_image, String content_video, String date_created, int likes) {
        this.id_status = id_status;
        this.content_text = content_text;
        this.content_image = content_image;
        this.content_video = content_video;
        this.date_created = date_created;
        this.likes = likes;
    }

    public String getId_status() {
        return this.id_status;
    }

    public void setId_status(String id_status) {
        this.id_status = id_status;
    }

    public String getContent_text() {
        return this.content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public String getContent_image() {
        return this.content_image;
    }

    public void setContent_image(String content_image) {
        this.content_image = content_image;
    }

    public String getContent_video() {
        return this.content_video;
    }

    public void setContent_video(String content_video) {
        this.content_video = content_video;
    }

    public String getDate_created() {
        return this.date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

}
