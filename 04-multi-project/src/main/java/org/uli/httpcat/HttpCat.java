package org.uli.httpcat;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpCat {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("USAGE: httpcat url");
            System.exit(1);
        }
        String url = args[0];
        URL u = new URL(url);
        URLConnection c = u.openConnection();
        InputStream is = c.getInputStream();
        byte[] buffer = new byte[10240];
        int len = 0;
        System.err.println("Downloading "+url);
        while ((len = is.read(buffer)) >= 0) {
            System.out.write(buffer, 0, len);
        }
    }
}
