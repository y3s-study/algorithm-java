package baekjoon.sk.substring.p_11478;

import java.util.*;

public class Main{
    public static void main(String[] agrs){
        Scanner in = new Scanner(System.in);
        
        String problem = in.nextLine();
        char[] div_pro = problem.toCharArray();
    
        int count = 0;
        
        for(int i=div_pro.length-1; i>=0; i--){
            for(int j=i; j<div_pro.length; j++){
                String temp1 = problem.substring(i+1);
                String temp2 = problem.substring(i, j+1);
                
                if(temp1.contains(temp2)){
                    continue;
                }else{
                    count++;    
                }
            }
        }
        System.out.println(count);
        in.close();
    }
}
