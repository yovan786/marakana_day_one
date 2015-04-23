package com.yovan.contacts.listener;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.yovan.contacts.entity.Address;
import com.yovan.contacts.repository.AddressRepository;

@WebListener
public class SetupListener implements ServletContextListener {


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent)  { 
    	
    }
    
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
    	AddressRepository addressRepository = new AddressRepository();
    	try {
			addressRepository.init();
			Address address = new Address("Surath", "Quatre-Bornes", "Plaines-Wilhems", "12345");
			addressRepository.save(address);
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
}
