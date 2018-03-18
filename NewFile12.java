import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class NewFile12 {
	
	
	
	static void validate(File f1) throws InvalidFileException{
		if(f1.exists()) {
			System.out.println("file is valid and the files name with path on console are: ");
			
		}
		else {
			System.out.println("file is invalid");
			System.out.println("Use a valid file");
		}
	
 	}
		
		
	static ArrayList<File> files  = new ArrayList<File>();
	

	public static void path(File f) {
		File f1[] = f.listFiles();
		for(File f2:f1) {
			if(f2.isDirectory()) {
				path(f2);
			}
			else {
			//	System.out.println("File name :" + f2.getName() + " File Path: " + f2.getAbsolutePath());
			         files.add(f2.getAbsoluteFile());	
			}
			}
		}

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the file name which contains both source and destination files:  ");
		String path = sc.nextLine();
		File f1 = new File(path);
		
		try {
			validate(f1);
			
		}catch(Exception ex) {
			System.out.println("Exception in path:" + ex);
		}
		
	     	sc.close();	
				try (FileReader fr1 = new FileReader(f1);
					BufferedReader br1 = new BufferedReader(fr1);){
					
					String source = br1.readLine();
					String destination = br1.readLine();
					
					File f2;
					 f2 = new File(source);
						if(f2.isDirectory()) {
							path(f2);
						
							
							}
						else {
							 f2 = new File(destination);
							FileWriter fw1 = new FileWriter(f2,true);
							BufferedWriter bw1 = new BufferedWriter(fw1);
							bw1.write(source);
							bw1.flush();
							bw1.close();
								}
						}catch(Exception e) {
					System.out.println("exception occur");
				}
				 System.out.println( files ); //output on console
				
				 try (FileReader fr2 = new FileReader(f1);
					BufferedReader br2 = new BufferedReader(fr2);){
					
			 		String source = br2.readLine();
					String destination = br2.readLine();
					
					
					FileWriter fw2 = new FileWriter(destination);
					BufferedWriter bw2 = new BufferedWriter(fw2);
				
					
					for(int i=0;i<files.size();i++) {
							//	System.out.println(files.get(i));
								File f = files.get(i);
							    bw2.write(f.getName() + " , ");
							    
								bw2.write(f.getAbsolutePath());
								bw2.newLine();
								bw2.flush();
								
							}
					bw2.close();
					
					}catch(Exception e) {
					System.out.println(" error in csvfilewritter  ");
				}
				
				}
}


