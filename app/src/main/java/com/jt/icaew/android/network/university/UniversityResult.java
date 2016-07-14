package com.jt.icaew.android.network.university;

import java.util.ArrayList;

/**
 * Created by LTE on 7/13/2016.
 */
public final class UniversityResult {
    public final int code;
    public final String message;
    public final ArrayList<Data> data;

    public UniversityResult(int code, String message, ArrayList<Data> data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<Data> getData() {
        return data;
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

        public long getId() {
            return id;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public String getImage() {
            return image;
        }
    }
}