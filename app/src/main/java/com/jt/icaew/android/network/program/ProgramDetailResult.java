package com.jt.icaew.android.network.program;

/**
 * Created by Wandy on 7/12/2016.
 */
public final class ProgramDetailResult {
    public final long code;
    public final String message;
    public final Data data;

    public ProgramDetailResult(long code, String message, Data data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static final class Data {
        public final long id;
        public final String title;
        public final String description;
        public final String image;
        public final String youtube;
        public final String initial;
        public final boolean is_banner;
        public final String created_at;
        public final String updated_at;

        public Data(long id, String title, String description, String image, String youtube, String initial, boolean is_banner, String created_at, String updated_at){
            this.id = id;
            this.title = title;
            this.description = description;
            this.image = image;
            this.youtube = youtube;
            this.initial = initial;
            this.is_banner = is_banner;
            this.created_at = created_at;
            this.updated_at = updated_at;
        }
    }
}
