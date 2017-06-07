package org.rpc.before.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.rpc.before.interfaces.service.impl.CalculateServiceImpl;

/**
 *
 * 消费者代理工厂类
 *
 * @author CaiXiangning
 * @date May 31, 2017
 * @email caixiangning@gmail.com
 */
public class ConsumerProxyFactory implements InvocationHandler {

	/**
	 * 创建bean的工厂方法
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object create(String clazz) throws Exception {
		Class<?> interfaceClass = Class.forName(clazz);
		// Object java.lang.reflect.Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
		// 参数loader指定动态代理类的类加载器，参数interfaces指定动态代理类需要实现的所有接口，参数handler指定与动态代理类关联的InvocationHandler对象
		Object obj = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[] { interfaceClass }, this);
		return obj;
	}

	/**
	 * 当程序调用动态代理类的方法时，该方法会调用与它关联的InvocationHandler对象的invoke方法
	 * 
	 * @param proxy 指代我们所代理的那个真实对象
	 * @param method 指代的是我们所要调用真实对象的某个方法的Method对象
	 * @param args 指代的是调用真实对象某个方法时接受的参数
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Class<?> interfaceClass = proxy.getClass().getInterfaces()[0];
		
		System.out.println("调用接口类名：" + interfaceClass);
		System.out.println("调用接口方法名：" +  method.getName());
		System.out.println("调用接口方法参数类型：" + method.getParameterTypes());
		System.out.println("调用接口方法参数值：" + args);
		// 使用反射调用接口方法，在RPC框架中是远程调用服务器中服务并使用反射调用接口方法
		return method.invoke(new CalculateServiceImpl(), args);
	}
}
