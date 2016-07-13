package com.jt.icaew.android.network.event;

import java.util.ArrayList;

/**
 * Created by Wandy on 7/11/2016.
 */
public final class EventResult {
    public final long code;
    public final String message;
    public final ArrayList<Data> data;

    public EventResult(long code, String message, ArrayList<Data> data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static final class Data {
        public final long id;
        public final String code;
        public final String name;
        public final String image;

        public Data(long id, String code, String name, String image){
            this.id = id;
            this.code = code;
            this.name = name;
            this.image = image;
        }
    }
}
