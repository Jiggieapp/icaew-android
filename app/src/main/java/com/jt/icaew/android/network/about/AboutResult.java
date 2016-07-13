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

    public static final class Data {
        public final long id;
        public final String title;
        public final String description;
        public final Image image;
        public final Created_at created_at;
        public final String updated_at;

        public Data(long id, String title, String description, Image image, Created_at created_at, String updated_at){
            this.id = id;
            this.title = title;
            this.description = description;
            this.image = image;
            this.created_at = created_at;
            this.updated_at = updated_at;
        }

        public static final class Image {

            public Image(){
            }
        }

        public static final class Created_at {

            public Created_at(){
            }
        }
    }
}
