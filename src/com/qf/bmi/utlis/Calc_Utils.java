package com.qf.bmi.utlis;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计算工具类及时间转换工具
 * @author 郑其鑫
 *
 */
public class Calc_Utils {
	public static double calcBmi(double height,double weight){
		double bmi=weight/((height/100)*(height/100));
		DecimalFormat df=new DecimalFormat("#.00");
		String bmi1=df.format(bmi);
		double bmi2=Double.valueOf(bmi1);
		return bmi2;
		
	}
	
	public static double calcDream(double height) {
		double dream=(height-100)*0.9;
		return dream;
	}
	public static String getTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		String time = sdf.format(date);
		return time;
	}
}
