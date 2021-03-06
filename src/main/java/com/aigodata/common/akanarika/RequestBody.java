package com.aigodata.common.akanarika;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aigodata.common.akanarika.constants.RequestRawFormat;

import net.sf.json.JSONObject;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Builder;

/***
 * 构造网络请求参数类
 * 
 * @author saps.weaver
 *
 */
public class RequestBody {
	public static void main(String[] args) {
		JSONObject s = new JSONObject();
		String u = "{\"d\":null}";
		s.put("a", u);
		System.out.println(s);
	}

	private Logger logger = LoggerFactory.getLogger(RequestClient.class);
	private List<Map> params = new ArrayList();
	private String rowBody = "";
	private byte[] rowBodyBytes = null;
	private RequestRawFormat rawFormat = null;

	public void add(String $key, Object $value) {
		Map map = new HashMap();
		map.put("key", $key);
		map.put("value", $value);
		params.add(map);
	}

	public String ifNull(Object obj) {
		if (obj == null || "".equals(obj.toString())) {
			return "";
		}
		return obj.toString();
	}

	public void addFile(String $key, String fileName, byte[] $value) {
		Map map = new HashMap();
		map.put("key", $key);
		map.put("fileName", fileName);
		map.put("value", $value);
		params.add(map);
	}

	public void set(RequestRawFormat rawFormat, String rowBody) {
		this.rowBody = rowBody;
	}

	public void set(RequestRawFormat rawFormat, byte[] bytes) {
		this.rowBodyBytes = bytes;
	}

	public void set(int rawFormat, byte[] bytes) {
		this.rowBodyBytes = bytes;
	}

	public void set(int rawFormat, String rowBody) {
		set(RequestRawFormat.values()[rawFormat], rowBody);
	}

	String getFormBody() {
		StringBuffer sb = new StringBuffer();
		String result = "";
		if (params != null && params.size() > 0) {
			for (Map param : params) {
				String key = ifNull(param.get("key"));
				String value = ifNull(param.get("value"));
				sb.append(String.format("&%s=%s", key, value));
			}
			result = sb.substring(1);
		}
		logger.debug("body:" + result);
		return result;
	}

	String getRawBody() {
		logger.debug("body:" + rowBody);
		return rowBody;
	}

	byte[] getRawBodyBytes() {
		return rowBodyBytes;
	}

	okhttp3.RequestBody getMultipartBody() throws IOException {
		Builder build = new Builder();
		build.setType(MediaType.parse("multipart/form-data"));
		if (params != null && params.size() > 0) {
			for (Map param : params) {
				String key = ifNull(param.get("key"));
				if (param.containsKey("fileName")) {// 文件
					String fileName = ifNull(param.get("fileName"));
					byte[] value = (byte[]) param.get("value");
					build.addFormDataPart(key, fileName,
							okhttp3.RequestBody.create(MediaType.parse("application/octet-stream"), value));
				} else {// 字符串
					String value = ifNull(param.get("value"));
					build.addFormDataPart(key, value);
				}
			}
		}
		return build.build();
	}

	MediaType getMediaType() {
		MediaType mediaType = null;
		// raw
		if (RequestRawFormat.TEXT == rawFormat) {
			mediaType = MediaType.parse("text/plain");
		} else if (RequestRawFormat.JSON == rawFormat) {
			mediaType = MediaType.parse("application/json");
		} else if (RequestRawFormat.JAVASCRIPT == rawFormat) {
			mediaType = MediaType.parse("application/javascript");
		} else if (RequestRawFormat.APPLICATIONXML == rawFormat) {
			mediaType = MediaType.parse("application/xml");
		} else if (RequestRawFormat.TEXTXML == rawFormat) {
			mediaType = MediaType.parse("text/xml");
		} else if (RequestRawFormat.HTML == rawFormat) {
			mediaType = MediaType.parse("text/html");
		} else if (RequestRawFormat.BINARY == rawFormat) {
			mediaType = MediaType.parse("application/octet-stream");
		}
		return mediaType;
	}
}
