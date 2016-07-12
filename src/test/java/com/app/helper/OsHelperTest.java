package com.app.helper;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Oussama on 12/07/2016.
 */
public class OsHelperTest {
    @Test
    public void getOsUser() throws Exception {
        System.out.println( osHelper.getOsUser());

    }

    private OsHelper osHelper;
    @Before
    public void setUp() throws Exception {
        osHelper = new OsHelper();
    }

    @Test
    public void getOsName() throws Exception {
        System.out.println( osHelper.getOsName() );
    }

}