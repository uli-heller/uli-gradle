package org.uli.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    final Logger logger = LoggerFactory.getLogger(EchoServer.class);

    public String echo(String shoutOut) {
	logger.debug("-> shoutOut={}", shoutOut);
	String result = shoutOut;
	logger.debug("<- result={}", result);
	return result;
    }
}
