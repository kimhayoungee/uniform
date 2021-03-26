package com.uniform.ea.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.uniform.ea.approval.controller.EaApprovalController;

public class GetDate {
	
	public static String getFromDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		System.out.println("¿À´Ã : " + sdf.format(c.getTime()));
		//10³âÀü ¿À´Ã
		c.add(Calendar.YEAR, -10);
		StringBuffer sb = new StringBuffer(sdf.format(c.getTime()));
		
		return sb.toString();
	} //1
	
	public static String getToday(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		StringBuffer sb = new StringBuffer(sdf.format(c.getTime()));
		
		return sb.toString();
	} //2
	
} //end of getDate class
