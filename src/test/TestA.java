package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class TestA {
	
	
	
	public static void main(String args[]) {
		//設定列表長度
		String arr[] = {"_","_","_","_","_"};
		//設定起始位置
		int startIndex=arr.length-1;
		for(int i=0;i<arr.length;i++) {
			arr[startIndex]=" *";
			for(int j=0;j<arr.length;j++) {
				if(j==arr.length-1) {
					System.out.println(arr[j]);
					
				}else {
					System.out.print(arr[j]);
				}
			}
			startIndex--;
		}
		
		
	}
}
