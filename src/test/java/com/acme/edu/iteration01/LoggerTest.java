package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exceptions.SaverException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

import static java.lang.System.lineSeparator;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Ignore
    @Test
    public void shouldLogInteger() throws IOException, SaverException {
        //region when
        Logger.log(1);
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1" + lineSeparator() + "primitive: 0" + lineSeparator() + "primitive: -1" + lineSeparator());
        //endregion
    }
/*
    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Logger.log((byte)1);
        Logger.flush();
        Logger.log((byte)0);
        Logger.flush();
        Logger.log((byte)-1);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }



    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Logger.log('a');
        Logger.flush();
        Logger.log('b');
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

*/
    @Ignore
    @Test
    public void shouldLogString() throws IOException, SaverException {
        //region when
        Logger.log("test string 1");
        Logger.flush();
        Logger.log("other str");
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }
/*
    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        Logger.log(true);
        Logger.flush();
        Logger.log(false);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        Logger.log(new Object());
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }
    */
}