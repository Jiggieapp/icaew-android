package com.jt.icaew.android.network.about;

/**
 * Created by Wandy on 7/12/2016.
 */
public final class AboutResult {
    public final long code;
    public final String message;
    public final Data data;

    public AboutResult(long code, String message, Data data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }

    public static final class Data {
        public final long id;
        public final String title;
        public final String description;
        public final String image;
        public final String created_at;
        public final String updated_at;

        public Data(long id, String title, String description, String image, String created_at, String updated_at){
            this.id = id;
            this.title = title;
            this.description = description;
            this.image = image;
            this.created_at = created_at;
            this.updated_at = updated_at;
        }

        public long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getImage() {
            return image;
        }

        public String getCreated_at() {
            return created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }
    }
}
