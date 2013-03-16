package org.uli.htmlunescape;

import org.apache.commons.lang3.StringEscapeUtils;

public class HtmlUnescape {
	public String unescapeHtml(String src, String encoding) {
		return StringEscapeUtils(src, encoding);
	}
}

