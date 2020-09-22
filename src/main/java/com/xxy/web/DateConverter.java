package com.xxy.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换
 * @author tym
 *
 */
//@Component
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		System.out.println("convert:"+arg0);
		
		try {
			return sdf.parse(arg0);
		} catch (ParseException e) {			
			//e.printStackTrace();
		}
		return new Date();
	}

}
