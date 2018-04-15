package test;

import java.util.Date;

import com.tools.MatchTools;

public class testOpne {
	
	public static void main(String[] args) {
		String date = MatchTools.converDate(new Date());
		System.out.println(date);
	}

}
