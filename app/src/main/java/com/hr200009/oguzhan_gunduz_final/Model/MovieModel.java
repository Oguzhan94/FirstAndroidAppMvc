
package com.hr200009.oguzhan_gunduz_final.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// film model sinifimiz. Json modelinin Java objesine donusturulmus hali.
// Getter ve Setterlari ile birlikte bulunmaktadir.
public class MovieModel {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("genres")
    @Expose
    private String genres;
    @SerializedName("stars")
    @Expose
    private String stars;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("photoUrl")
    @Expose
    private String photoUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}