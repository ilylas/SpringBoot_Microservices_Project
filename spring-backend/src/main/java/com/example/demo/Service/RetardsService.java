package com.example.demo.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Retards;
import com.example.demo.repository.EmployeeRepositoy;
import com.example.demo.repository.RetardsRepository;

@Service
public class RetardsService {
	
	private final RetardsRepository repository;
	
	private int tab[]=new int[500];
	private String tab2[]=new String[500];
	private int k=0;
	private int j=0;

    RetardsService(RetardsRepository repository) {
        this.repository = repository;
    } 
	@SuppressWarnings("resource")
	public List<Retards> saveRetardsInDB(String mois) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		String fileemploye= "src/main/java/fichieremploye.csv";
		String file ="src/main/java/InOutData 2023-"+mois+".csv";
		
		List<Retards> retards= new ArrayList<>();
		//String tab[]=new String[200];
        //int total = 0 ;
        //int totalS2 = 0 ; 
    	BufferedReader readeremploye =null ;
    	BufferedReader readerdecembre =null ;
    	
    	String lineemploye = "";
    	String linedecembre = "";
        
    	readeremploye = new BufferedReader(new FileReader(fileemploye));

        readerdecembre = new BufferedReader(new FileReader(file));
        String startTimeStr = "08:00:00";
        String startTimeStr2 = "14:00:00";
        
        String endTimeStr ="";
        
		while((lineemploye = readeremploye.readLine()) != null) {
        
			String[] rowemploye=lineemploye.split(","); 
			
			String [] partsEmp = rowemploye[0].split("\\|");
			
			String mat = partsEmp[0];
			
			String matriculeEmp = rowemploye[0].substring(0,rowemploye[0].indexOf("|"));
			
			System.out.println("\n-----------------------------"+matriculeEmp+"----------------------------------------\n");
			
			readerdecembre = new BufferedReader(new FileReader(file));
	        int total = 0;
	        int totalS2 =0;
	        int totalminutes =0;
	        int totalsecondes =0;
			
	        while ((linedecembre = readerdecembre.readLine()) != null ) {

		            String[] rowdecembre=linedecembre.split(",");
		
		            if(rowdecembre[0].split("\\|")[1].equals(mat)&&rowdecembre[0].split("\\|")[3].equals("C/In")&&rowdecembre[0].split("\\|")[2].equals("2")) {
		            	String[] timeParts = rowdecembre[0].split(":");
		                int hour=Integer.parseInt(timeParts[0].substring(11));
		                int minute = Integer.parseInt(timeParts[1]);
		                int second = Integer.parseInt(timeParts[2].substring(0,2));	
		                endTimeStr=rowdecembre[0].split("\\|")[0].substring(11,19);
		                
		                /*--------------------------------------Matin--------------------------------------------*/
		
		
			            Duration retard = Duration.between(LocalTime.parse(startTimeStr),LocalTime.parse(endTimeStr));
			            long heures = retard.toHours();
		                
		                long minutes = (retard.toMinutes()%60);
		                
		                long seconds = (retard.toSeconds()%60);
		            	//if(((hour>8||minute>0||second>0)||(hour>8&&minute>0&&second>0))&&(hour<=12)) {
		                if(LocalTime.parse(endTimeStr).compareTo(LocalTime.parse(startTimeStr))>0&&hour<=12) {
				            	//System.out.println(rowdecembre[0].split("\\|")[0].substring(11,19));
				            	endTimeStr=rowdecembre[0].split("\\|")[0].substring(11,19);
				            	System.out.println("Heure de retard : "+endTimeStr);
				            	
				                if (!endTimeStr.isEmpty()) {

				                    totalminutes+=minutes;
				                    totalsecondes+=seconds;
				                    
				                    //System.out.println("totalminutes ="+totalminutes);
				                    //System.out.println("totalsecondes ="+totalsecondes);
		
				                    while(totalsecondes>=60) {
				                    	totalminutes++;
				                    	totalsecondes=totalsecondes-60;
				                    }
				                    while(totalminutes>=60) {
				                    	heures++;
				                    	totalminutes=totalminutes-60;	
				                    }
		
				                    //System.out.println("minute ="+totalminutes);
				                    //System.out.println("seconds ="+totalsecondes);
				                    //System.out.println("heures ="+heures);
				                  
				                }
				                else {
				                	System.out.println("End time is not available.");
				                }
		
			    	            System.out.println("retard matin : "+retard+" avec "+heures+" heures "+minutes+" minutes "+seconds+"secondes");
			    	            
			    	            total += heures;
			    	            
		            	}
		            	
		                /*-------------------------------Midi--------------------------------------------*/
		                
		            	//else if(((hour>14||minute>0||second>0)||(hour>14&&minute>0&&second>0))&&(hour<=18)) {
		                  
		                else if(LocalTime.parse(endTimeStr).compareTo(LocalTime.parse(startTimeStr2))>0&&hour<=18) {
			            	//System.out.println(rowdecembre[0].split("\\|")[0].substring(11,19));
		                	endTimeStr=rowdecembre[0].split("\\|")[0].substring(11,19);
			            	System.out.println("Heure de retard : "+endTimeStr);
		    	            Duration retardS2 = Duration.between(LocalTime.parse(startTimeStr2),LocalTime.parse(endTimeStr));
		    	            long heuresS2 = retardS2.toHours();
		                    
		                    long minutesS2 = retardS2.toMinutes()%60;
		                    
		                    long secondsS2 = retardS2.toSeconds()%60;
			            	
			                if (!endTimeStr.isEmpty()) {
			    	            
			                    totalminutes+=minutes;
			                    totalsecondes+=seconds;
			                    
			                    //System.out.println("totalminutes ="+totalminutes);
			                    //System.out.println("totalsecondes ="+totalsecondes);
		
			                    while(totalsecondes>=60) {
			                    	totalminutes++;
			                    	totalsecondes=totalsecondes-60;
			                    }
			                    while(totalminutes>=60) {
			                    	heuresS2++;
			                    	totalminutes=totalminutes-60;	
			                    }
		
			                    //System.out.println("minute ="+minutesS2);
			                    //System.out.println("seconds ="+secondsS2);
			                    //System.out.println("heures ="+heuresS2);
			                    
			                }			                
			                else {
			                	System.out.println("End time is not available.");
			                }  
		    	            System.out.println("retard apres midi : "+retardS2+" avec "+heuresS2+" heures "+minutesS2+" minutes "+secondsS2+"secondes");
		
		    	            totalS2 += heuresS2;
		                }
		                
		            }
				}
				System.out.println("\ntotal de nombres d'heures de retard dans la séance S1 : "+total);
	            System.out.println("total de nombres d'heures de retard dans la séance S2 : "+totalS2);
				System.out.println("Total des heures de retard = "+(total+totalS2)+" heures avec "+totalminutes+" minutes "+totalsecondes+" secondes pour l'employe de matricule "+mat);		
				retards.add(new Retards(matriculeEmp, (totalS2+total),total,totalS2));

		}
    	
        return retards;

	}

}
