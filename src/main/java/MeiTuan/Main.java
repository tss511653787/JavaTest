package MeiTuan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int count = 0;
        boolean flag = true;
		int n = scanner.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i < n ; i++){
			list.add(scanner.nextInt());
		}
		Collections.sort(list);
       
		for(int i = 0 ; i < n; i++){
			count = count + list.get(i);
			//count = count - list.get(i+1);
		}
        if(list.get(n-1) > (count/2))
            flag = false;
		if(flag){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		scanner.close();
	}

}