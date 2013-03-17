package org.uli.htmlunescape;

public class Main {
    static public void main(String[] args) {
        HtmlUnescape htmlUnescape = new HtmlUnescape();
        for (String arg : args) {
            System.out.println(htmlUnescape.unescapeHtml(arg));
        }
    }
}
