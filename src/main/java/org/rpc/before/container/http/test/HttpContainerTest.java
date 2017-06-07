package org.rpc.before.container.http.test;

import org.junit.Test;
import org.rpc.before.container.http.HttpContainer;

/**
 *
 * 测试jetty实现服务器并接收客户端请求作出处理
 *
 * @author CaiXiangning 
 * @date Jun 6, 2017 
 * @email caixiangning@gmail.com
 */
public class HttpContainerTest {
	
	@Test
	public void testStartContainer(){
		new HttpContainer().startContainer();
	}
}
