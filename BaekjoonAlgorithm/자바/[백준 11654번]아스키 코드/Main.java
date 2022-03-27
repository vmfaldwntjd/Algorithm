import java.util.Scanner;

public class Main {    
    public static void main(String[] args){
    	char ch;
    	
    	Scanner sc = new Scanner(System.in);
    	ch = sc.next().charAt(0);
    	System.out.println((int)ch);
    	sc.close();
    } 
}
