/**
 * 
 */
package org.uli;

import java.io.File;

import org.apache.catalina.startup.Tomcat;

/**
 * @author uli
 *
 */
public class Main {
    private static final String WEBAPP_BASEDIR="src/main/webapp";
    private static final String WEBAPP_CONTEXTPATH="/091-debug-jsf-2";
    private static final int TOMCAT_PORT=8080;
    
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.addWebapp(WEBAPP_CONTEXTPATH, new File(WEBAPP_BASEDIR).getAbsolutePath());
        tomcat.setPort(TOMCAT_PORT);
        tomcat.start();
        tomcat.getServer().await();
    }
}
