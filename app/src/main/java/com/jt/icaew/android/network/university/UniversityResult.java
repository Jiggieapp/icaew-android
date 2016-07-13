package com.jt.icaew.android.network.university;

import java.util.ArrayList;

/**
 * Created by LTE on 7/13/2016.
 */
public final class UniversityResult {
    public final long code;
    public final String message;
    public final ArrayList<Data> data;

    public UniversityResult(long code, String message, ArrayList<Data> data){
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