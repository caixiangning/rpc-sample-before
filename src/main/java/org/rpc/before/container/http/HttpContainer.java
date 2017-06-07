package org.rpc.before.container.http;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.rpc.before.container.http.handler.HttpContainerHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 使用Jetty实现的Http容器的相关实现类
 *
 * @author CaiXiangning 
 * @date Jun 6, 2017 
 * @email caixiangning@gmail.com
 */
public class HttpContainer {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpContainer.class);
	
	private AbstractHandler httpContainerHandler = new HttpContainerHandler();
	
	public void startContainer(){
		Server server = new Server();
		// 非阻塞NIO连接器
		SelectChannelConnector selectChannelConnector = new SelectChannelConnector();
		// 设置服务器监听端口
		selectChannelConnector.setPort(8080);
		// 设置服务器连接器
		server.setConnectors(new Connector[] { selectChannelConnector });
		// 指定进行处理的Handler(添加一个处理器)
		server.setHandler(httpContainerHandler);
		try {
			// 启动Server
			server.start();
			server.join();
			logger.info("Jetty容器正常启动");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error("Jetty容器启动异常", e);
		}
	}
}
