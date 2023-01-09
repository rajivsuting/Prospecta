package com.masai;

import java.io.File;

public class Demo {
	
	public static void main(String[]  args) {
		
		  String csv = " A1: 5, A2: 7, A3: 9, B1: 3, B2: 8, B3: =4+5, C1: =5+A1, C2: =A2+B2, C3: =C2+B3 ";

		  String[] data = csv.split(",");
		
		  String[][] table = new String[data.length][data.length];
		

		  for (int i = 0; i < data.length; i++) {
		     table[i] = data[i].split(":");
		  }
		

		  for (int i = 0; i < table.length; i++) {
		     for (int j = 0; j < table[i].length; j++) {
		        if (table[i][j].contains("=")) {
		       table[i][j] = table[i][j].replace("=", "");
		        }
		     }
		  }
		

		  for (int i = 0; i < table.length; i++) {
		     for (int j = 0; j < table[i].length; j++) {
		        System.out.print(table[i][j] + " ");
		     }
		     System.out.println();
		  }
		
	}

}
