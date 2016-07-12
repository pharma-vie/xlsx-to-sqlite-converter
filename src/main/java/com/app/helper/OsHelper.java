package com.app.helper;

/**
 * Created by Oussama on 12/07/2016.
 */
public class OsHelper {

    public static final String MAC = "Mac";
    public static final String WINDOWS = "Windows";
    public static final String UBUNTU = "Ubuntu";
    public static final String UNKNOWN = "UNKNOWN";

    public OsHelper() {
    }

    public String getOsName(){
        String osName = UNKNOWN;
        osName = System.getProperty("os.name");
        return osName;
    }

    public String getOsUser(){
        String osUser = UNKNOWN;
        osUser = System.getProperty("user.home");
        return osUser;
    }
}
