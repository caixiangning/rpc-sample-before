package org.rpc.before.container.http.handler;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.jetty.handler.AbstractHandler;
import org.rpc.before.container.http.HttpContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 服务器端负责处理客户端请求并进行响应的类
 *
 * @author CaiXiangning 
 * @date Jun 6, 2017 
 * @email caixiangning@gmail.com
 */
public class HttpContainerHandler extends AbstractHandler {

	private static final Logger logger = LoggerFactory.getLogger(HttpContainer.class);
	
	@Override
	public void handle(String arg0, HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse, int arg3)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String reqStr = httpServletRequest.getParameter("data");
		logger.info("服务器接收到来自客户端的请求字符串是:{}", reqStr);
		OutputStream outputStream = httpServletResponse.getOutputStream();
		String rsqStr = reqStr;
		outputStream.write(rsqStr.getBytes("UTF-8"));
		outputStream.flush();
	}
}
