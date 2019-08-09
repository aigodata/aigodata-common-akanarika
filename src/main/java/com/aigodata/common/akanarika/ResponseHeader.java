package com.aigodata.common.akanarika;

import java.util.Set;

import net.sf.json.JSONObject;
import okhttp3.Headers;
import okhttp3.Response;

public class ResponseHeader {
	public static JSONObject getJson(Response res) {
		JSONObject result = new JSONObject();
		Headers heads = res.headers();
		if (heads != null && heads.size() > 0) {
			Set<String> headSet = heads.names();
			headSet.stream().forEach(h -> {
				result.put(h, heads.get(h));
			});
		}
		return result;
	}
}
