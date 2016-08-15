package com.hand;

import com.hand.dto.Address;
import com.hand.service.AddressService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println(System.getProperty("user.dir"));
    	AddressService addser = new AddressService();
        Address add = addser.addressIsExist(5) ;
        if(add != null){ System.out.println(add.getAddress());}
    }
}
