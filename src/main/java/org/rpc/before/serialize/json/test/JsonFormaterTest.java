package org.rpc.before.serialize.json.test;

import org.junit.Test;
import org.rpc.before.bean.RequestObject;
import org.rpc.before.interfaces.service.CalculateService;
import org.rpc.before.interfaces.service.impl.CalculateServiceImpl;
import org.rpc.before.serialize.json.JsonFormater;

/**
 * 
 * 将对象封装成字符串报文接口测试类
 * 
 * @author CaiXiangNing
 * @date Jun 1, 2017
 * @email caixiangning@gmail.com
 */
public class JsonFormaterTest {
	
	/**
	 * 测试将请求对象封装成字符串报文
	 */
	@Test
	public void testReqFormat(){
		RequestObject requestObject = new RequestObject();
		// 指定对象的Class
		requestObject.setClazz(CalculateService.class);
		// 指定方法名称
		requestObject.setMethodName("add");
		// 指定方法参数类型Class
		requestObject.setParamTypes(new Class[]{int.class, int.class});
		// 指定方法参数数值
		requestObject.setParamValues(new Integer[]{8, 2});
		
		String jsonResult = JsonFormater.formater.reqFormat(CalculateService.class, "add", new Class[]{int.class, int.class}, new Object[]{8, 2});
		System.out.println(jsonResult);
	}
	
	/**
	 * 测试将响应结果对象封装成字符串报文
	 */
	@Test
	public void testRsbFormat(){
		Object result = new CalculateServiceImpl().add(2, 8);
		String jsonResult = JsonFormater.formater.rsbFormat(result);
		System.out.println(jsonResult);
	}
}
