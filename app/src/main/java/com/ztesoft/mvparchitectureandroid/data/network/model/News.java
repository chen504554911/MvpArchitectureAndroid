package com.ztesoft.mvparchitectureandroid.data.network.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * @class describe:描述
 * @anthor chenyx
 * @time 2018/05/31 11:42
 * @chang 2018/05/31 11:42
 */
public class News {


    @SerializedName("stat")
    public String stat;
    @SerializedName("data")
    public List<DataBean> data;

    public static class DataBean {
        @SerializedName("uniquekey")
        public String uniquekey;
        @SerializedName("title")
        public String title;
        @SerializedName("date")
        public String date;
        @SerializedName("category")
        public String category;
        @SerializedName("author_name")
        public String authorName;
        @SerializedName("url")
        public String url;
        @SerializedName("thumbnail_pic_s")
        public String thumbnailPicS;
        @SerializedName("thumbnail_pic_s02")
        public String thumbnailPicS02;

        public String getUniquekey() {
            return uniquekey;
        }

        public void setUniquekey(String uniquekey) {
            this.uniquekey = uniquekey;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbnailPicS() {
            return thumbnailPicS;
        }

        public void setThumbnailPicS(String thumbnailPicS) {
            this.thumbnailPicS = thumbnailPicS;
        }

        public String getThumbnailPicS02() {
            return thumbnailPicS02;
        }

        public void setThumbnailPicS02(String thumbnailPicS02) {
            this.thumbnailPicS02 = thumbnailPicS02;
        }
    }

    public String getStat() {
        return stat;
    }

    public List<DataBean> getData() {
        return data;
    }
}
