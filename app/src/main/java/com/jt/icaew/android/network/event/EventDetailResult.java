package com.jt.icaew.android.network.event;

import java.util.ArrayList;

/**
 * Created by Wandy on 7/14/2016.
 */
public final class EventDetailResult   {
    public final long code;
    public final String message;
    public final ArrayList<Data> data;

    public EventDetailResult(long code, String message, ArrayList<Data> data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static final class Data {
        public final long id;
        public final long country_id;
        public final String title;
        public final String description;
        public final String image;
        public final String start_date;
        public final String end_date;
        public final String created_at;
        public final String updated_at;
        public final String country_name;

        public Data(long id, long country_id, String title, String description, String image, String start_date, String end_date, String created_at, String updated_at, String country_name){
            this.id = id;
            this.country_id = country_id;
            this.title = title;
            this.description = description;
            this.image = image;
            this.start_date = start_date;
            this.end_date = end_date;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.country_name = country_name;
        }
    }
}
