package mainentry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RegExTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        while(true) {
            String s= scanner.next();
            //regex: 大小写，数字，下划线 2-16位
            System.out.println(s.matches("[\\w]{2,16}$"));
        }
    }
}
