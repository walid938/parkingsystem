package com.parkit.parkingsystem.service;

import java.util.Date;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;

public class FareCalculatorService {
	
	private static TicketDAO ticketDAO;

	public void calculateFare(Ticket ticket){
        
    	if( (ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime())) ){
            throw new IllegalArgumentException("Out time provided is incorrect:"+ticket.getOutTime().toString());
        }
    	
 
    	
    	String vehicleRegNumber = ticket.getVehicleRegNumber();
    	
        double inHour = ticket.getInTime().getTime();
        double outHour =  ticket.getOutTime().getTime(); 
       
        
        //TODO: Some tests are failing here. Need to check if this logic is correct
        double duration = (outHour - inHour) / 3600000;
        
        
        if (duration < 0.5) ticket.setPrice(0);
        
        else { 
   
        	System.out.println("le stationnement est payant");
        	
            
            {
            switch (ticket.getParkingSpot().getParkingType()){
                case CAR: {
                    ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR);
                    break;
                }  
                case BIKE: {	
                    ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR);
                    break;
                    
               
                }
                
                default: throw new IllegalArgumentException("Unkown Parking Type");
            }
            
            
            
          
           Ticket getTicket = new Ticket ();
           
           		if (getTicket.getVehicleRegNumber()!=null && (getTicket.getOutTime().before.(getTicket);
            		{
            	
            		{
                    switch (ticket.getParkingSpot().getParkingType()){
                        case CAR: {
                            ticket.setPrice((duration * Fare.CAR_RATE_PER_HOUR )* 0.95);
                            break;
                        }  
                        case BIKE: {	
                            ticket.setPrice((duration * Fare.BIKE_RATE_PER_HOUR)* 0.95);
                            break;
                           
                                   }
                        
                        default: throw new IllegalArgumentException("Unkown Parking Type");
                    }
            	
            }
        }
        	
        }
       
        
    
        
    }
        
       
        
        	
        
	}
}
   