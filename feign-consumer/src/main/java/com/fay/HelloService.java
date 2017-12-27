package com.fay;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-service")
public interface HelloService {
	
	@RequestMapping("/hello")
	String hello();
	
	@RequestMapping(value = "hello1", method = RequestMethod.GET)
	String hello(@RequestParam("name") String name);
	
	@RequestMapping(value = "hello2", method = RequestMethod.GET)
	User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
	
	@RequestMapping(value = "hello3", method = RequestMethod.GET)
	String hello(@RequestBody User user);
}
