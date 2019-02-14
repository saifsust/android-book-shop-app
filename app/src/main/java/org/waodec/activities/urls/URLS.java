package org.waodec.activities.urls;

public interface URLS {
    public static final String GET_REGISTER_CLIENT = "http://localhost:8080/register_client/all";
    public static final String POST_REGISTER_CLIENT = "http://192.168.0.118:8080/register_client/upload";
    public static final String GET_THANA = "http://192.168.0.118:8080/thana/all";
    public static final String THANA = "http://192.168.0.118:8080/thana/single";
    public static final String THANA_UPLOAD = "http://192.168.0.118:8080/thana/upload";

    public static final String GEL_ZELA = "http://192.168.0.118:8080/zela/all";
    public static final String GET_POST_OFFICE_CODE = "http://192.168.0.118:8080/post_office_code/all";
    public static final String GET_DIVISIONS = "http://192.168.0.118:8080/division/all";

    public static final String POST_AUTHENTICATION = "http://192.168.0.118:8080/authorizer/isAuthorized";
    public static final String POST_BOOKS = "http://192.168.0.118:8080/book/search/";
}
