package org.rpc.before.serialize.json.test;

import org.junit.Test;
import org.rpc.before.bean.RequestObject;
import org.rpc.before.interfaces.service.CalculateService;
import org.rpc.before.serialize.json.JsonFormater;
import org.rpc.before.serialize.json.JsonParser;

/**
 * 
 * 将Json字符串报文解析成对象测试类
 * 
 * @author CaiXiangNing
 * @date Jun 1, 2017
 * @email caixiangning@gmail.com
 */
public class JsonParserTest {
	/**
	 * 测试将请求报文解析为请求参数对象
	 */
	@Test
	public void testParserReqParse(){
		/*********************测试之前：创建字符串请求报文*********************/
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
		//System.out.println(jsonResult);
		String datagram = jsonResult;
		/*********************测试之中：请求报文解析为请求参数对象*********************/
		requestObject = JsonParser.parser.reqParse(datagram);
		System.out.println(requestObject);
	}
	
	/**
	 * 测试将响应报文解析成响应结果对象
	 */
	@Test
	public void testReqParse(){
		String datagram = "10";
		int result = JsonParser.parser.rsbParse(datagram, int.class);
		System.out.println(result);
	}
}
