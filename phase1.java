import java.util.Hashtable;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

// phase 1 complete

public class phase1 {
	
	@SuppressWarnings("resource")
	public static void myHashtable () throws IOException {
		File inputTest = new File("test.txt");
	
		Hashtable<String, String> nbaStatsOriginal = new Hashtable<String, String>(); // Hashtable for orginal data nbaStats created
		Hashtable<String, String> nbaStatsModify = new Hashtable<String, String>();	  // Hashtable for any date given by user or modify															
		
		BufferedReader read = new BufferedReader(new FileReader(inputTest)); // BufferedReader used to read file, FileReader used to locate file
																										
		String containFile;
		while ((containFile = read.readLine()) != null) {   // while the file is not empty reads everyline
			String[] seperate = containFile.split(" = ");   // splits the string by looking for "="
			String name = seperate[0];                      // splits the name from file
			String stats = seperate[1];						// then splits stats from file
			nbaStatsOriginal.put(name, stats);				// stores into hashtable with name as key and value as stats
			nbaStatsModify.put(name, stats);				// stores into modify hashtable
			// System.out.println(parta);
			// System.out.println(partb);
		}
		
		Scanner input = new Scanner(System.in);
	    char view;
	    do {
	    	System.out.println();
	        System.out.println("Welcome: ");
	        System.out.println("Type: S to see data or X to exit: ");
	        System.out.print("Enter: ");
	        view = input.nextLine().toLowerCase().charAt(0);
	        
	        // view hashtable

	        if (view == 's') {
	            System.out.println();
	            System.out.print("Type A to add data / Type D to delete data / Type V to view data / Type M to modify data: ");
	            char ans = input.nextLine().toLowerCase().charAt(0);
	            if (ans == 'v') {
	            	 System.out.println();
	                 System.out.println("View All Records : ");
	                 
	                 if (nbaStatsModify.isEmpty()) {
	                	System.out.println("Hashtable Empty!");                     
	                 }
	                 else {
	                	 @SuppressWarnings("rawtypes")
						Enumeration keys1 = nbaStatsModify.keys();
	            		  Enumeration values1 = nbaStatsModify.elements();
	            		  
	            		  while(keys1.hasMoreElements() || values1.hasMoreElements()) {
	            		  System.out.println(keys1.nextElement() + " " + values1.nextElement());
	            		  } 
	         		  }
	                 Date timeStamp = new Date(); 				
	   				System.out.println(timeStamp.toString());
	            }
	            // add data
	            if(ans == 'a') {
					 System.out.println();
					System.out.println("Add Player: ");
			        System.out.println("ENTER PLAYER NAME FOLLOWING THIS FORMAT: PLAYER NAME = PPG: x REB: x BLOCKS: x STEALS: x ");
			        Scanner input2 = new Scanner(System.in);
			        String ans2 = input2.nextLine();
			        
			        if (!ans2.contains("=") || !ans2.contains("PPG:") || !ans2.contains("REB:") || !ans2.contains("BLOCKS:") || !ans2.contains("STEALS:")) {
			        System.out.println("Invalid Format ");
			        }
			        	else {
			        		String[] seperate = ans2.split(" = ");
			        		String name = seperate[0];
			        		String stats = seperate[1];
			        		nbaStatsModify.put(name, stats);
			        		System.out.println("PLAYER ADDED!");
			        		Date timeStamp = new Date(); 				
	        				System.out.println(timeStamp.toString());
			        		
			        	}
			        System.out.println();
			        try {
						log myLog = new log("log.txt");
						myLog.l.info("Player added" + " " + ans2);

					} catch (Exception e) {

					}
				  }
	            // Modify data
	            	if(ans == 'm') {
	            		System.out.println();
	            		System.out.println("What player would you like to modify: (Full name)");
	            		Scanner input3 = new Scanner(System.in);
	            		String ans3 = input3.nextLine();
	            		
	            		if(!nbaStatsModify.containsKey(ans3)) {
	        				System.out.print("Player not in hashtable");
	        			}
	            		
	            		if(nbaStatsModify.containsKey(ans3)) {
	            			nbaStatsModify.remove(ans3);
	            			System.out.println("ENTER PLAYER NAME FOLLOWING THIS FORMAT: PLAYER NAME = PPG: x REB: x BLOCKS: x STEALS: x ");
	            			String ans4 = input3.nextLine();
	            			
	        		        if (!ans4.contains("=") || !ans4.contains("PPG:") || !ans4.contains("REB:") || !ans4.contains("BLOCKS:") || !ans4.contains("STEALS:")) {
	        		        System.out.println("Invalid Format ");
	        		        }
	        		        	else {
	        		        		String[] seperate = ans4.split(" = ");
	        		        		String name = seperate[0];
	        		        		String stats = seperate[1];
	        		        		nbaStatsModify.put(name, stats);
	        		        		System.out.println("PLAYER MODIFIED!");
	        		        		Date timeStamp = new Date(); 				
	                				System.out.println(timeStamp.toString());
	        		        	}
	            		}
	            		System.out.println();
	            		try {
	            			log myLog = new log("log.txt");
	            			myLog.l.info("Player modified" + " " + ans3);

	            		} catch (Exception e) {

	            		}
	            	}
	         		  if (ans == 'd') {
	         			//delete what is in hashtable
	         			  System.out.println();
	         			  System.out.println("DELETE PLAYER: ");
	         			  @SuppressWarnings("resource")
						Scanner input1 = new Scanner(System.in);
	         			  System.out.print("What player do you want to delete? (Full name): ");
	         			  String ans1 = input1.nextLine();
	         			
	         			  if(nbaStatsModify.containsKey(ans1)) {
	         				  nbaStatsModify.remove(ans1);
	         				  System.out.println("Player removed");
	         				 Date timeStamp = new Date(); 				
	        				System.out.println(timeStamp.toString());
	        				System.out.println();
	        				try {
	    	         			log myLog = new log("log.txt");
	    	         			myLog.l.info("Player deleted" + " " + ans1);

	    	         		} catch (Exception e) {

	    	         		}
	         				  
	         			  }
	         			  else
	         				  System.out.println("Player not in hashtable");
	         		  }
	         	
	         		 
	        }
	        else if ((view != 'x') && (view != 's'))
	            System.out.println("Invalid command: ");
	    } while (view != 'x');
		
	    input.close();	
	}
}
	
		
		

