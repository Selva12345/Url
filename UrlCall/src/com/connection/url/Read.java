package com.connection.url;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Read {
	public static void main(String[] args) {
		try {
			BufferedReader bf=new BufferedReader(new FileReader("src/com/connection/url/Input.json"));
			
			Scanner sc=new Scanner(bf);
			sc.useDelimiter("/n");
			String s=sc.next();
			System.out.println(s);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
