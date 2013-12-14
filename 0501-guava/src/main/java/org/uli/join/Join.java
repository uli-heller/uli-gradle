package org.uli.join;

import com.google.common.base.Joiner;

public class Join {
    static private final Joiner joiner = Joiner.on(",");

    public String join(Object... joinThem) {
	return joiner.join(joinThem);
    }
}

