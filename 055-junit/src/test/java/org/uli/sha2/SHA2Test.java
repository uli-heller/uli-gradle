package org.uli.sha2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SHA2Test {
  @Test
  public void testSha2() throws Exception {
      String src = "UliWarDa";
      String sha2 = new SHA2().sha1hex(src);
      assertEquals("ea04b5f95c701e1764e8dca2f0ceefb3a7051c2cae5cdc24ff3dae3703137c8d", sha2);
  }
}
