package org.uli.e02gretty;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
public class E02GrettyServlet extends HttpServlet implements ServletContextListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("->");
        response.setContentType("text/html");
        String pathInfo = request.getPathInfo();
        PrintWriter out = response.getWriter();
        logAll();
        if (pathInfo == null) {
            send(out, "Was soll das?");
        } else {
            if (pathInfo.startsWith("/list")) {
                StringBuilder sb = new StringBuilder();
                java.util.Enumeration e = org.apache.log4j.LogManager.getCurrentLoggers();
                while (e.hasMoreElements()) {
                    org.apache.log4j.Logger logger = (org.apache.log4j.Logger) e.nextElement();
		    sb.append(logger.getName());
                    sb.append("\t");
		    sb.append(logger.getEffectiveLevel());
                    sb.append("\r\n");
                }
                log.debug(".: LIST");
                send(out, "Gestartet - pathInfo=" + pathInfo + "\r\n\r\n" + sb.toString());
            } else if (pathInfo.startsWith("/stop")) {
                log.debug(".: STOP");
                send(out, "Gestoppt - pathInfo=" + pathInfo);
            }
        }
        log.debug("<-");
    }

    private void logAll() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }

    @Override
    public void destroy() {
        log.debug("->");
        log.debug("<-");
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.debug("->");
        log.debug("<-");
    }

    /* (non-Javadoc)
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.debug("->");
        log.debug("<-");
    }

    private void send(PrintWriter out, String text) {
        out.println("<HTML>");
        out.println("<HEAD><TITLE>E02GrettyServlet - Response</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<PRE>");
        out.println(text);
        out.println("</PRE>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
