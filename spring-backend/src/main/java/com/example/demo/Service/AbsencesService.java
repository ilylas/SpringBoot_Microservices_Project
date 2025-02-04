package com.example.demo.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.mapping.Set;
import org.springframework.stereotype.Service;

import com.example.demo.model.Absence;
import com.example.demo.model.Retards;

@Service
public class AbsencesService {
	    	String fileemploye= "src/main/java/fichieremploye.csv";
	    	String fileOctober= "src/main/java/InOutData 2023-October.csv";
	    	String fileDecembre= "src/main/java/InOutData 2023-Decembre.csv";
	    	String fileNovembre= "src/main/java/InOutData 2023-Novembre.csv";

	    	BufferedReader readeremploye =null ;
	    	BufferedReader readerdecembre =null ;
	    	
	    	String lineemploye = "";
	    	String lineDecembre = "";
	    	

	        String[] joursFeriers = {"2023-12-17", "2023-03-20", "2023-05-01", "2023-04-21", "2023-04-22", "2023-07-25", "2023-06-29", "2023-07-19", "2023-10-08"};

	        String[] days = {"2023-12-01", "2023-12-02", "2023-12-03", "2023-12-04", "2023-12-05", "2023-12-06", "2023-12-07", "2023-12-08", "2023-12-09", "2023-12-10", "2023-12-11", "2023-12-12", "2023-12-13", "2023-12-14", "2023-12-15", "2023-12-16", "2023-12-17", "2023-12-18", "2023-12-19", "2023-12-20", "2023-12-21", "2023-12-22", "2023-12-23", "2023-12-24", "2023-12-25", "2023-12-26", "2023-12-27", "2023-12-28", "2023-12-29", "2023-12-30", "2023-12-31"};
	       

		    public List<Absence> calculernbJoursAbsences(String mois)throws NumberFormatException, IOException {
				String file ="src/main/java/InOutData 2023-"+mois+".csv";

		    	/*
		    	switch(mois) {
					case "Novembre","11","novembre","NOVEMBRE":mois=fileNovembre;
					case "Octobre","10","octobre","OCTOBRE":mois=fileOctober;
					case "Decembre","12","decembre","DECEMBRE":mois=fileDecembre;
		    	}*/
		    	
		    	List<Absence> absences= new ArrayList<>();
				readeremploye = new BufferedReader(new FileReader(fileemploye));
		        readerdecembre = new BufferedReader(new FileReader(file));
		        // Création d'un tableau de LocalDate
		        LocalDate[] jours = new LocalDate[days.length];
	            LocalDate [] tabAbsences =new LocalDate[31];	     
	            LocalDateTime[] tabpresences =new LocalDateTime[500];
	            LocalDateTime[] tab =new LocalDateTime[31];
	            //absences.removeAll(absences);
	            String[] tabJours =new String[500];
	            String [] dates =new String[500];
		        // Conversion des chaînes en LocalDate
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        for (int i = 0; i < jours.length; i++) {
		        	jours[i] = LocalDate.parse(days[i], formatter);
		        }
					
		        	while((lineemploye = readeremploye.readLine()) != null) {

						String[] rowemploye=lineemploye.split(","); 
						
						String [] partsEmp = rowemploye[0].split("\\|");
						
						String mat = partsEmp[0];
						
						String matriculeEmp = rowemploye[0].substring(0,rowemploye[0].indexOf("|"));
						
						System.out.println("\n----------------------------------------------------------"+matriculeEmp+"----------------------------------------\n");

				        readerdecembre = new BufferedReader(new FileReader(file));

			            double nbAbsences = 0.0;
			            tabAbsences =new LocalDate[31];
			            tabpresences =new LocalDateTime[500];
			            tab =new LocalDateTime[31];
			            tabJours =new String[500];
			            dates =new String[500];
			            
			            LocalDateTime dateTime=null;
			            int j=0;
			            int k=0;
			            int h=0;
			            int n=0;
			            double nbPDemiSeances=0.0;
			            int nbweekend=0;
				        
			            while ((lineDecembre = readerdecembre.readLine()) != null) {
			                String[] rowDecembre = lineDecembre.split(",");
			                if (rowDecembre[0].split("\\|")[1].equals(mat)&& !rowDecembre[0].contains("Date/Temps|Matricul")) {
			                    dateTime = parseDateTime(rowDecembre[0]);
			                    
			                    if (!containsDate(tabpresences, dateTime)&& (isFirstSession(dateTime)) || (isSecondSession(dateTime))) {
			                        tabpresences[j++] = dateTime;
			                    } 
			                    
			                    if (!containsDate(tab, dateTime)) {
			                        tab[h++] = dateTime;
			                    } 
			                    
			                    if (!Arrays.asList(dates).contains(dateTime.toString())) {
			                        dates[n++] = dateTime.toString().substring(0,10);
			                    } 

			                }
			            }
			            
			            
			            
			            for(int joup=0;joup<jours.length;joup++) {
				            	if(isWeekend(jours[joup])) {
				            		nbweekend+=1;
				            	}
			            }
			            		            

			            for (LocalDate jour : jours) {
			                boolean presenceFound = false;
			                for (int m = 0; m < h; m++) {
			                    if (jour.getDayOfMonth() == tab[m].getDayOfMonth() || isWeekend(jour) || Arrays.asList(joursFeriers).contains(tab[m].toString())) {
			                        presenceFound = true;
			                        break;
			                    }
		    		                    
			                }

			                if ((!presenceFound)) {
			                    tabAbsences[k++] = jour;
			                    nbAbsences+=1;
			                    


			                }

			            }
			            String s1="";
			            String s2="";
			            for(LocalDate jour:jours) {
			            	boolean S1=false;
			            	boolean S2=false;
			            	for(int i=0;i<tabpresences.length&&tabpresences[i]!=null;i++) {
			            		if(jour.getDayOfMonth()==tabpresences[i].getDayOfMonth() &&isFirstSession(tabpresences[i]) ) {
			            			S1=true;
			            		}
			            		else if(jour.getDayOfMonth()==tabpresences[i].getDayOfMonth() &&isSecondSession(tabpresences[i])) {
			            			S2=true;
			            		}
			            	}
			            	if((!S1 && S2)||(S1 && !S2)){
			            		nbPDemiSeances+=0.5;
			            	}
			            	if(!S1 && S2){
			            		s1="Oui";
			            		s2="Non";
			            	}
			            	else if (S1 && !S2){
			            		s2="Oui";
			            		s1="Non";
			            	}
			            }
			            
			               
		                for(int i=0;i<tabpresences.length && tabpresences[i]!=null;i++) {
		                	tabJours[i]=tabpresences[i].toString().substring(8,10);
		                }
		                
		              
		                System.out.println("tableau de jours de presences = "+Arrays.toString(tabpresences));
			            System.out.println("tableau de jours d'absences (sans les weekends et les jours feriers ) = "+Arrays.toString(tabAbsences));

			            System.out.println("Nombre de jours d'absence pour l'employe de matricule " +mat + ": " + (nbPDemiSeances+nbAbsences)+"dans le mois"+mois);
			            absences.add(new Absence(mat,Arrays.asList(tabAbsences),(nbPDemiSeances+nbAbsences),s1,s2));
		        	}
					return absences;
		        		
		        	
		        	}

		    private static boolean containsDate(LocalDateTime[] array, LocalDateTime date) {
		        for (int i = 0; i < array.length; i++) {
		            if (array[i] != null && array[i].toLocalDate().isEqual(date.toLocalDate())) {
		                return true;
		            }
		        }
		        return false;
		    }
		    
		    private static LocalDateTime parseDateTime(String dateTimeString) {
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        return LocalDateTime.parse(dateTimeString.substring(0, 19), formatter);
		    }


		    private static boolean isFirstSession(LocalDateTime dateTime) {
		    	LocalTime debutS1 = LocalTime.of(8, 0);
		    	LocalTime finS1 = LocalTime.of(12, 30);

		        return (dateTime.toLocalTime().isAfter(debutS1) || dateTime.toLocalTime().equals(debutS1) ) && ( dateTime.toLocalTime().isBefore(finS1)
		        		|| dateTime.toLocalTime().equals(finS1));
		        
		    }

		    private static boolean isSecondSession(LocalDateTime dateTime) {
		    	LocalTime debutS2 = LocalTime.of(14, 0);
		    	LocalTime finS2 = LocalTime.of(18, 0);

		        return (dateTime.toLocalTime().isAfter(debutS2) || dateTime.toLocalTime().equals(debutS2) ) && ( dateTime.toLocalTime().isBefore(finS2)
		        		|| dateTime.toLocalTime().equals(finS2));

		    }

		    //fonction pour weekend
		    public static boolean isWeekend(LocalDate date) {
		        DayOfWeek dayOfWeek = date.getDayOfWeek();
		        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
		    }
		   
		    /*
		     * méthode 2
		    private static boolean isWeekend(LocalDateTime date) {
		        return date.getDayOfWeek().getValue() >= 6; // 6 is Saturday, 7 is Sunday
		    }*/
		    
		    

		



}
