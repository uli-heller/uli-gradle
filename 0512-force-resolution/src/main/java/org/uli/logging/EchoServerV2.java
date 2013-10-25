package org.uli.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServerV2 {

    final Logger logger = LoggerFactory.getLogger(EchoServerV2.class);

    public String echo(String shoutOut) {
        logger.debug("-> shoutOut={}", shoutOut);
        String result = shoutOut;
        logger.debug("<- result={}", result);
        return result;
    }

    public static void main(String[] args) {
        EchoServerV2 echoServer = new EchoServerV2();
        for (String shoutOut : args) {
            System.out.println("'" + shoutOut + "' -> '" + echoServer.echo(shoutOut) + "'");
        }
    }
}
