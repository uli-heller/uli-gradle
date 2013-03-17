package org.uli.htmlunescape;

import org.junit.Test;
import static org.junit.Assert.*;

public class HtmlUnescape3Test {
  @Test
  public void testHtmlUnescape() {
      String escaped = "&amp;";
      String unescaped = new HtmlUnescape3().unescapeHtml(escaped);
      assertEquals("&", unescaped);
  }
}
