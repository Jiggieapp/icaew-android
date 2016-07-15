package com.jt.icaew.android.network.actions;

import java.util.ArrayList;

/**
 * Created by LTE on 7/15/2016.
 */
public final class LikeResult {
    public final int code;
    public final String message;
    public final ArrayList<Data> data;

    public LikeResult(int code, String message, ArrayList<Data> data){
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
        public final long count;

        public Data(long count){
            this.count = count;
        }

        public long getCount() {
            return count;
        }
    }
}