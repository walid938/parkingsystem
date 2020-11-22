package com.parkit.parkingsystem.Dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;
import com.parkit.parkingsystem.integration.service.DataBasePrepareService;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;



class TicketDaoTest {
	 private static DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
	 private static TicketDAO ticketDAO;
	 private Ticket ticket;
	 private static DataBasePrepareService dataBasePrepareService;
	 private static ParkingSpotDAO parkingSpotDAO;
	

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		parkingSpotDAO = new ParkingSpotDAO();
        parkingSpotDAO.dataBaseConfig = dataBaseTestConfig;
        ticketDAO = new TicketDAO();
        ticketDAO.dataBaseConfig = dataBaseTestConfig;
        dataBasePrepareService = new DataBasePrepareService();
	}
	
	
		

	@Test
	void saveTicketTest () {
		
		Ticket ticket = new Ticket();
		Date inTime = new Date();
		inTime.setTime (System.currentTimeMillis() -( 60 * 60 * 1000) );
		
	    
	    ParkingSpot parkingSpot = new ParkingSpot(parkingSpotDAO.getNextAvailableSlot (ParkingType.CAR),ParkingType.CAR,true);	
		ticket.setId(122234);
		ticket.setPrice(15);
		ticket.setVehicleRegNumber("23-D-ZE");
		ticket.setPrice(22);
		ticket.setInTime(inTime);
		ticket.setParkingSpot(parkingSpot);
		
		assertTrue(ticketDAO.saveTicket(ticket));
		
	}
	
	
				
}
		

	

