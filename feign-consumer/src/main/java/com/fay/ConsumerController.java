package com.fay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
	
	@Autowired
	HelloService helloService;
	
	@Autowired
	RefactorHelloService refactorHelloService;
	
	@RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
	public String helloConsumer() {
		return helloService.hello();
	}
	
	@RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
	public String helloConsumer2() {
		StringBuilder sb = new StringBuilder();
		sb.append(helloService.hello()).append("\n");
		sb.append(helloService.hello("fay")).append("\n");
		sb.append(helloService.hello("fay", 29)).append("\n");
		sb.append(helloService.hello(new User("fay", 29))).append("\n");
		return sb.toString();
	}
	
	@RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
	public String helloConsumer3() {
		StringBuilder sb = new StringBuilder();
		sb.append(refactorHelloService.hello("fayfay")).append("\n");
		sb.append(refactorHelloService.hello("fayfay", 29)).append("\n");
		sb.append(refactorHelloService.hello(new com.fay.dto.User("fayfay", 29))).append("\n");
		return sb.toString();
	}
}
