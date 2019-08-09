package com.aigodata.common.akanarika.constants;

public enum RequestMethod {
	GET(0), POST(1), PUT(2), PATCH(3), DELETE(4), 
	COPY(5), HEAD(6), OPTIONS(7), LINK(8), UNLINK(9), 
	PURGE(10), LOCK(11), UNLOCK(12), PROPFIND(13), VIEW(14);

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	RequestMethod(int $v) {
		this.value = $v;
	}

}
