package com.jt.icaew.android.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Wandy on 7/11/2016.
 */
public class Constant {

    public final static String DEVELOPER_KEY = "AIzaSyD9QIf1TW3S3keg5K5ywS2sWu1j4kgd66A";

    public final static String BASE_URL = "http://icaew-admin.jiggieapp.com/api/";
    public final static String URL_PROGRAM = BASE_URL + "program";
    public final static String URL_PROGRAM_DETAIL = BASE_URL + "program/{id}";
    public final static String URL_COUNTRY = BASE_URL + "country";
    public final static String URL_ABOUT = BASE_URL + "about";
    public final static String URL_CONTACT = BASE_URL + "contact";
    public final static String URL_CONTACT_DETAIL = BASE_URL + "contact/{id}";
    public final static String URL_UNIVERSITY = BASE_URL + "university";
    public final static String URL_UNIVERSITY_DETAIL = BASE_URL + "university/{id}";
    public static final String URL_EVENT_DETAIL = BASE_URL + "event";

    public final static String PARAM_PROGRAM_ID = "program_id";
    public final static String PARAM_PROGRAM_NAME = "program_name";
    public final static String PARAM_COUNTRY_ID = "country_id";
    public final static String PARAM_COUNTRY_NAME = "country_name";
    public static final String PARAM_TOOLBAR_TITLE = "toolbar_title";

    public final static String COUNTRY_ID = "country_id";
    public final static String COUNTRY_NAME = "country_name";
    public final static int CODE_SUCCESS = 200;

    public static final SimpleDateFormat ISO8601_DATE_FORMAT_UTC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
}
