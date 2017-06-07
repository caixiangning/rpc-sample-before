package org.rpc.before.invoke.http.test;

import org.junit.Test;
import org.rpc.before.invoke.http.HttpInvoker;

/**
 * 
 * 测试客户端向服务器端发起请求并接收响应
 * 
 * @author CaiXiangNing
 * @date Jun 7, 2017
 * @email caixiangning@gmail.com
 */
public class HttpInvokerTest {
	
	@Test
	public void testHttpClientPost(){
		String requestDatagram = "this is test datas";
		String result = HttpInvoker.httpInvoker.request(requestDatagram);
		System.out.println("客户端请求的响应结果：" + result);
	}
}

