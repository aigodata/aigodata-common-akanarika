package com.aigodata.common.akanarika.constants;

public enum RequestContentType {
	NONE(0), MULTIPART(1), FORM(2), RAW(3), BINARY(4);

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	RequestContentType(int $v) {
		this.value = $v;
	}
}
