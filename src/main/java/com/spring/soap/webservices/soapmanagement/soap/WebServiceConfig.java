package com.spring.soap.webservices.soapmanagement.soap;

import org.springframework.context.ApplicationContext;

import java.util.Collections;
import java.util.List;

import javax.security.auth.callback.CallbackHandler;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//Enable spring web services
@EnableWs
//Spring configuration
@Configuration
public class WebServiceConfig  extends WsConfigurerAdapter{
    //MessageDispatcherServlet
    //ApplicationContext
    //url -> /ws/*
    @Bean 
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");        
    }

    //Exposition of soap services
    // wsdl
    // /ws/items.wsdl
    // item-details.xsd
    @Bean(name="items")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema itemsSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        //PortType ItemPort
        definition.setPortTypeName("ItemPort");
        //Namespace http://soap-management/items
        definition.setTargetNamespace("http://soap-management/items");
        definition.setLocationUri("/ws");
        definition.setSchema(itemsSchema);
        return definition;
    }

    @Bean
    public XsdSchema itemsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("item-details.xsd"));
    }

    //XwsSecurityInterceptor intercepts all the requests and checks if they are secure
    //Callback handler to check user and password
    //security policy -> securityPolicy.xml
    @Bean
    public XwsSecurityInterceptor securityInterceptor() {
        XwsSecurityInterceptor securityInterceptor = new XwsSecurityInterceptor();
        securityInterceptor.setCallbackHandler(callbackHandler());
        securityInterceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));
        return securityInterceptor;
    }

    @Bean 
    public SimplePasswordValidationCallbackHandler callbackHandler() {
        SimplePasswordValidationCallbackHandler handler = new SimplePasswordValidationCallbackHandler();
        handler.setUsersMap(Collections.singletonMap("user", "123"));
        return handler;
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        interceptors.add(securityInterceptor());
    }


}