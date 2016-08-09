package com.jt.icaew.android.network.contact;

import java.util.ArrayList;

/**
 * Created by Wandy on 7/13/2016.
 */
public final class ContactDetailResult {
    public final long code;
    public final String message;
    public final ArrayList<Data> data;

    public ContactDetailResult(long code, String message, ArrayList<Data> data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public static final class Data {
        public final long id;
        public final long country_id;
        private final String telp;
        private final String email;
        private final String website;
        private final String facebook;
        private final String address;
        public final String created_at;
        public final String updated_at;
        public final String country_name;
        private final String image;

        public String getTelp() {
            if(telp == null)
                return "";
            return telp;
        }

        public String getEmail() {
            if(email == null)
                return "";
            return email;
        }

        public String getWebsite() {
            if(website == null)
                return "";
            return website;
        }

        public String getFacebook() {
            if(facebook == null)
                return "";
            return facebook;
        }

        public String getAddress() {
            if(address == null)
                return "";
            return address;
        }

        public String getImage()
        {
            if(image == null)
                return "";
            return image;
        }


        public Data(long id, long country_id, String telp, String email, String website, String facebook, String address, String created_at, String updated_at, String country_name, String image){
            this.id = id;
            this.country_id = country_id;
            this.telp = telp;
            this.email = email;
            this.website = website;
            this.facebook = facebook;
            this.address = address;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.country_name = country_name;
            this.image = image;
        }
    }
}
