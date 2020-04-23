package com.zbq.util;

public class EvaluateUtil {

	
	public static String getUpEva(int eva,int base){
		if(eva>base*1.15){
			return("1");
		}else if(eva<base*1.15&&eva>=base*1.05){
			return("2");
		}else if(eva<base*1.05&&eva>=base*0.95){
			return("3");
		}else {
			return("4");
		}
	}
	
	
	public static String getDownEva(int eva,int base){
		if(eva>base*1.15){
			return("4");
		}else if(eva<base*1.15&&eva>=base*1.05){
			return("3");
		}else if(eva<base*1.05&&eva>=base*0.95){
			return("2");
		}else {
			return("1");
		}
	}
	
	
	public static String getUpEva(double eva,int base){
		if(eva>base*1.15){
			return("1");
		}else if(eva<base*1.15&&eva>=base*1.05){
			return("2");
		}else if(eva<base*1.05&&eva>=base*0.95){
			return("3");
		}else {
			return("4");
		}
	}
	
	
	public static String getDownEva(double eva,int base){
		if(eva>base*1.15){
			return("4");
		}else if(eva<base*1.15&&eva>=base*1.05){
			return("3");
		}else if(eva<base*1.05&&eva>=base*0.95){
			return("2");
		}else {
			return("1");
		}
	}
}
