package com.community.services.config;

import com.community.services.listener.MyHttpSessionListener;
import com.community.services.listener.MyServletContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 
 * @author Administrator
 *
 */
@Configuration
public class ListenerConfig {
	@Bean
	public ServletListenerRegistrationBean<MyHttpSessionListener> listenerRegist() {
		ServletListenerRegistrationBean<MyHttpSessionListener> srb = new ServletListenerRegistrationBean<MyHttpSessionListener>();
		srb.setListener(new MyHttpSessionListener());
		return srb;
	}

	@Bean
	public ServletListenerRegistrationBean<MyServletContextListener> listenerRegist2() {
		ServletListenerRegistrationBean<MyServletContextListener> srb = new ServletListenerRegistrationBean<MyServletContextListener>();
		srb.setListener(new MyServletContextListener());
		return srb;
	}

	/*@Bean
	public ServletListenerRegistrationBean<ActiveMQListener> listenerRegist3() {
		ServletListenerRegistrationBean<ActiveMQListener> srb = new ServletListenerRegistrationBean<ActiveMQListener>();
		srb.setListener(new ActiveMQListener());
		return srb;
	}*/

}