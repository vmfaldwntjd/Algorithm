package org.opentutorials.javatutorials.problem;

import java.util.Scanner;

public class Main {    
    public static void main(String[] args){
    	int[] arr = new int[9];
    	int mx = 0;
    	int index = 0;
    	Scanner sc = new Scanner(System.in);
    	
    	for (int i = 0; i < 9; ++i) {
    		arr[i] = sc.nextInt();
    		if (arr[i] >= mx) {
    			mx = arr[i];
    			index = i;
    		}
    	}
    	System.out.println(mx);
    	System.out.println(index + 1);
    	sc.close();
    } 
}
