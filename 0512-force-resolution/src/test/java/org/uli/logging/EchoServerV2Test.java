package org.uli.logging;

import org.junit.Test;
import static org.junit.Assert.*;

public class EchoServerV2Test {

    @Test
    public void testEcho() {
        EchoServerV2 echoServer = new EchoServerV2();
        String echo = echoServer.echo("UliWasHere!");
        assertEquals("UliWasHere!", echo);
    }
}
