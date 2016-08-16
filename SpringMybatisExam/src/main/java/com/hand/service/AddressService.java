package com.hand.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dto.Address;
import com.hand.serviceInter.AddressInter;


public class AddressService {

   	private static ApplicationContext ctx;
	static
	{
		ctx = new ClassPathXmlApplicationContext("config/ApplicationContext.xml");
	}
	
	public Address addressIsExist(int id){
		Address address = null;
		try {
    		AddressInter addressMapper =  (AddressInter) ctx.getBean("addressMapper");
    		address = addressMapper.getAddressById(id);
			if(address == null){
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return address;
	}

}
