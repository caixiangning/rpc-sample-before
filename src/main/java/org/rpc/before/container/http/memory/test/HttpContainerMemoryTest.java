package org.rpc.before.container.http.memory.test;

import org.junit.Test;
import org.rpc.before.container.http.memory.HttpContainerMemory;
import org.rpc.before.interfaces.service.CalculateService;
import org.rpc.before.interfaces.service.impl.CalculateServiceImpl;

import junit.framework.Assert;

/**
 *
 * 服务注册/存储的内存容器测试类
 *
 * @author CaiXiangning 
 * @date Jun 2, 2017 
 * @email caixiangning@gmail.com
 */
public class HttpContainerMemoryTest {
	
	/**
	 * 测试注册服务
	 */
	@Test
	public void testRegisterService(){
		Class<?> clazz = CalculateService.class;
		Object obj = new CalculateServiceImpl();
		HttpContainerMemory.getInstance().registerService(clazz, obj);
	}
	
	/**
	 * 测试获取服务
	 */
	@Test
	public void testObtainService() {
		// 注册服务
		Class<?> clazz = CalculateService.class;
		Object object = new CalculateServiceImpl();
		HttpContainerMemory.getInstance().registerService(clazz, object);
		// 获取服务
		object = HttpContainerMemory.getInstance().obtainService(clazz);
		Assert.assertNotNull(object);
	}
}
