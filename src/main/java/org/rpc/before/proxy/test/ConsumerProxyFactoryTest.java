package org.rpc.before.proxy.test;

import org.junit.Test;
import org.rpc.before.interfaces.service.CalculateService;
import org.rpc.before.proxy.ConsumerProxyFactory;

/**
 *
 * Java动态代理测试类
 *
 * @author CaiXiangning 
 * @date Jun 6, 2017 
 * @email caixiangning@gmail.com
 */
public class ConsumerProxyFactoryTest {

	@Test
	public void testConsumerProxyFactory() throws Exception{
		ConsumerProxyFactory ConsumerProxyFactory = new ConsumerProxyFactory();
		Object obj = ConsumerProxyFactory.create("org.rpc.before.interfaces.service.CalculateService");
		CalculateService calculateService = (CalculateService)obj;
		int result = calculateService.add(8, 2);
		System.out.println("调用结果：" + result);
	}
}
