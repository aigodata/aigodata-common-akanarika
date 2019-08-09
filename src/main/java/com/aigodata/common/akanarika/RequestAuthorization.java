package com.aigodata.common.akanarika;

import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestAuthorization {
	private Logger logger = LoggerFactory.getLogger(RequestClient.class);

	public String bearerToken(String token) {
		return "Bearer " + token;
	}

	public String basicAuth(String username, String password) {
		return Base64.getEncoder().encodeToString(("Basic " + username + ":" + password).getBytes());
	}
}