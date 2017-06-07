package org.rpc.before.invoke.http;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * 客户端与服务器交互工具类
 *
 * @author CaiXiangning
 * @date May 31, 2017
 * @email caixiangning@gmail.com
 */
public class HttpInvoker {
	
	private static final HttpClient httpClient = HttpInvoker.getHttpClient();

	public static final HttpInvoker httpInvoker = new HttpInvoker();
	
	/**
	 * 客户端发送请求报文和服务器进行交互
	 * 
	 * @param requestDatagram 请求报文
	 * @param consumerConfig 消费者配置类
	 * @return
	 */
	public String request(String requestDatagram) {
		// TODO Auto-generated method stub
		HttpPost httpPost = new HttpPost("http://127.0.0.1:8888");
		// 使用长连接的模式
		httpPost.setHeader("Connection", "Keep-Alive");
		// 建立一个NameValuePair数组，用于存储欲传递的参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("data", requestDatagram));
		try {
			// 设置请求的实体(参数与值)
			httpPost.setEntity(new UrlEncodedFormEntity(params, Charset.forName("UTF-8")));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过连接池生成httpClient
	 * @return HttpClient对象
	 */
	public static HttpClient getHttpClient() {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		// 连接池最大生成连接数
		cm.setMaxTotal(200);
		// 设置每个路由上的默认连接个数20
		cm.setDefaultMaxPerRoute(20);
		HttpHost localhost = new HttpHost("localhost", 8080);
		// 单独为某个站点设置最大连接个数50
		cm.setMaxPerRoute(new HttpRoute(localhost), 50);
		// 创建httpClient
		return HttpClients.custom().setConnectionManager(cm).build();
	}
}
