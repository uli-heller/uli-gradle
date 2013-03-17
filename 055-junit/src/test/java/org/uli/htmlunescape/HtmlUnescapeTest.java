package org.uli.htmlunescape;

import org.junit.Test;
import static org.junit.Assert.*;

public class HtmlUnescapeTest {
  @Test
  public void testHtmlUnescape() {
      String escaped = "&amp;";
      String unescaped = new HtmlUnescape().unescapeHtml(escaped);
      assertEquals("&", unescaped);
  }
}
