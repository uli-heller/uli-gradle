package org.uli.htmlunescape;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlUnescape3 {
    public String unescapeHtml(String src) {
        return StringEscapeUtils.unescapeHtml4(src);
    }
}

