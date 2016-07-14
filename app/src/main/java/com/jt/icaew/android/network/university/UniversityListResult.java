package com.jt.icaew.android.network.university;

import java.util.ArrayList;

/**
 * Created by LTE on 7/13/2016.
 */
public final class UniversityListResult {
    public final int code;
    public final String message;
    public ArrayList<Data> data = new ArrayList<>();

    public UniversityListResult(int code, String message, ArrayList<Data> data){
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
        public final int id;
        public final int country_id;
        public final String name;
        public final String image;
        public final String created_at;
        public final String updated_at;
        public final String country_name;
        public final String email;
        public final String phone;
        public final String address;
        public final String description;

        public Data(int id, int country_id, String name, String image, String created_at, String updated_at, String country_name, String email, String phone, String address, String description){
            this.id = id;
            this.country_id = country_id;
            this.name = name;
            this.image = image;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.country_name = country_name;
            this.email = email;
            this.phone = phone;
            this.address = address;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public int getCountry_id() {
            return country_id;
        }

        public String getName() {
            return name;
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

        public String getCountry_name() {
            return country_name;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getAddress() {
            return address;
        }

        public String getDescription() {
            return description;
        }
    }
}