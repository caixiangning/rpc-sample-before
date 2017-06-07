package org.rpc.before.bean.test;

import org.junit.Test;
import org.rpc.before.bean.RequestObject;
import org.rpc.before.interfaces.service.CalculateService;
import org.rpc.before.interfaces.service.impl.CalculateServiceImpl;

/**
 * 
 * 请求的接口、方法、参数类型、参数数值封装的类以及反射测试
 * 
 * @author CaiXiangNing
 * @date Jun 1, 2017
 * @email caixiangning@gmail.com
 */
public class RequestObjectTest {
	
	/**
	 * 测试反射机制：在运行中调用对象方法
	 */
	@Test
	public void testRequestObject(){
		// 封装请求参数对象
		RequestObject requestObject = new RequestObject();
		// 指定对象的Class
		requestObject.setClazz(CalculateService.class);
		// 指定方法名称
		requestObject.setMethodName("add");
		// 指定方法参数类型Class
		requestObject.setParamTypes(new Class[]{int.class, int.class});
		// 指定方法参数数值
		requestObject.setParamValues(new Integer[]{8, 2});
		
		// 创建调用对象
		CalculateService CalculateService = new CalculateServiceImpl();
		try {
			// 运行时调用指定对象的指定方法
			Object result = requestObject.invoke(CalculateService);
			System.out.println("CalculateService接口的add(8,2)计算结果：" + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
