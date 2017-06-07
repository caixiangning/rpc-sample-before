package org.rpc.before.invoke;

import org.junit.Test;
import org.rpc.before.invoke.http.HttpInvoker;

/**
 *
 * 测试客户端请求服务器并接收响应结果
 *
 * @author CaiXiangning 
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
