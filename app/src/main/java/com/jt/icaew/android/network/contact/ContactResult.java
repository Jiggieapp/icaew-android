package com.jt.icaew.android.network.contact;

import java.util.ArrayList;

/**
 * Created by Wandy on 7/12/2016.
 */
public class ContactResult {
    public final long code;
    public final String message;
    public final ArrayList<Data> data;

    public ContactResult(long code, String message, ArrayList<Data> data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static class Data {
        public final long id;
        public final long country_id;
        public final String telp;
        public final String email;
        public final String created_at;
        public final String updated_at;
        public final String country_name;
        public final String website;
        public final String facebook;
        public final String address;
        public final String image;

        public Data(long id, long country_id, String telp, String email, String created_at, String updated_at, String country_name, String website, String facebook, String address, String image){
            this.id = id;
            this.country_id = country_id;
            this.telp = telp;
            this.email = email;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.country_name = country_name;
            this.website = website;
            this.facebook = facebook;
            this.address = address;
            this.image = image;
        }
    }
}
