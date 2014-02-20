package com.joonje.jackson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.joonje.domain.User;

public class Demo {
	@Test
	public void testFilter() throws Exception{
		User user = new User();
		user.setId("1");
		user.setPassword("abc");
		user.setSex("男");
		user.setCreateDate(new Date());
		ObjectMapper mapper = new ObjectMapper();
		SimpleFilterProvider sp = new SimpleFilterProvider();
		FilterProvider filters = sp.addFilter("myFilter", SimpleBeanPropertyFilter.serializeAllExcept("name","id"));
		mapper.setFilters(filters);
		String json = mapper.writeValueAsString(user);
		System.out.println(json);
	}
	@Test
	public void testMixinAnnotation() throws Exception{
		User user = new User();
		user.setId("1");
		user.setPassword("abc");
		user.setSex("男");
		user.setCreateDate(new Date());
		ObjectMapper mapper = new ObjectMapper();
		
		SimpleFilterProvider sp = new SimpleFilterProvider();
		FilterProvider filters = sp.addFilter("myFilter", SimpleBeanPropertyFilter.serializeAllExcept(""));
		mapper.setFilters(filters);
//		mapper.addMixInAnnotations(User.class, UserFilter.class);
		
		mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
		
		String json = mapper.writeValueAsString(user);
		System.out.println(json);
	}
	
	@Test
	public void testTime() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date now = new Date();
		String date = sdf.format(now);
		System.out.println(date);
		System.out.println(TimeZone.getDefault());
	}
}
