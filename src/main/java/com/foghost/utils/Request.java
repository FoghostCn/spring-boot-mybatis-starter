package com.foghost.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Request {

	private static final CloseableHttpClient client;

	static {
		int timeout = 5000;
		RequestConfig config = RequestConfig
				.custom()
				.setConnectTimeout(timeout)
				.setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout)
				.build();
		client = HttpClientBuilder
				.create()
				.setDefaultRequestConfig(config)
				.build();
	}

	public static Object Get(String url) throws Exception{
		HttpGet request = new HttpGet(url);
		try {
			CloseableHttpResponse response = client.execute(request);
			return EntityUtils.toString(response.getEntity(), "UTF-8");
		} catch (final Exception e) {
			e.printStackTrace();
			request.abort();
			throw e;
		}
	}

//	public static void main(String[] args) throws Exception {
//		System.out.println(Get("http://www.baidu.com"));
//	}

}
