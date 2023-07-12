package com.watabou.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.badlogic.gdx.Gdx;

/**
 * Exception manager singleton that is static to allow being called from static functions like main()
 */
public final class CPDExceptionManager {
    /**
     * Private constructor to prevent further instance creation
     */
    private CPDExceptionManager(){
    }

    /**
     * Log an exception
     * @param tr the exception to log
     */
    public static void report (Throwable tr) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        pw.flush();
        if(Gdx.app != null){
            Gdx.app.error("GAME", sw.toString());
        } else {
            // Used if the exception was thrown before the Application is initialized
            System.err.println(sw);
        }
    }
}
