package com.masai;

import java.io.File;

public class Demo {
	
	public static void main(String[]  args) {
		
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(new File("C:User\\Desktop\\prospecta.csv"));
			

//		      String csv = " A1: 5, A2: 7, A3: 9, B1: 3, B2: 8, B3: =4+5, C1: =5+A1, C2: =A2+B2, C3: =C2+B3 ";


//		      String[] data = csv.split(",");
		      sc.useDelimiter(","); 


		      Map<String, String> map = new LinkedHashMap<>();


		      for (int i = 0; i < data.length; i++) {
		         String[] pair = data[i].split(":");
		         map.put(pair[0].trim(), pair[1].trim());
		      }


		      for (Map.Entry<String, String> entry : map.entrySet()) {
		         if (entry.getValue().startsWith("=")) {
		            entry.setValue(entry.getValue().substring(1));
		         }
		      }


		      Map<String, Integer> map2 = new LinkedHashMap<>();


		      for (Map.Entry<String, String> entry : map.entrySet()) {
		         String value = entry.getValue();
		         if (value.contains("+")) {
		            String[] operands = value.split("\\+");
		            int sum = 0;


		            for (int i = 0; i < operands.length; i++) {
		               if (operands[i].matches(".*[A-Z].*")) {

		                  sum += Integer.parseInt(map.get(operands[i]));

		               } else {
		                  sum += Integer.parseInt(operands[i]);
		               }
		            }

		            map.put(entry.getKey(), sum + "");
		            map2.put(entry.getKey(), sum);
		         }else{
		            map2.put(entry.getKey(), Integer.parseInt(value));
		         }
		      }


		      for (Map.Entry<String, Integer> entry : map2.entrySet()) {
		         System.out.println(entry.getKey() + " = " + entry.getValue());
		      }

		   }
	}

}
