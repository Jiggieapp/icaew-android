package com.jt.icaew.android.activity.program;

import java.util.ArrayList;

/**
 * Created by Wandy on 7/11/2016.
 */
public final class ProgramResult {
    public final long code;
    public final String message;
    public final ArrayList<Data> data;

    public ProgramResult(long code, String message,  ArrayList<Data> data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static final class Data {
        public final long id;
        public final String title;
        public final String description;
        public final String image;
        public final boolean is_banner;
        public final String initial;
        public final String created_at;
        public final String updated_at;

        public Data(long id, String title, String description, String image, boolean is_banner, String initial, String created_at, String updated_at){
            this.id = id;
            this.title = title;
            this.description = description;
            this.image = image;
            this.is_banner = is_banner;
            this.initial = initial;
            this.created_at = created_at;
            this.updated_at = updated_at;
        }
    }
}
