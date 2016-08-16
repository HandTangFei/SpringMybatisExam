package com.hand;

import com.hand.dto.Address;
import com.hand.service.AddressService;
import com.hand.service.CustomerService;


/**
 * Hello world!
 *
 */
public class App 
{
	

	public static void main( String[] args )
    {

    	AddressService addser = new AddressService();
        Address add = addser.addressIsExist(5) ;
//        if(add != null){ System.out.println(add.getAddress());
//        System.out.println(add.getLast_update());}
//        
        CustomerService cuser = new CustomerService();
        String[] strs = cuser.inputInfo();
        System.out.println("Before insert Customer Data");
        
        boolean bool = cuser.saveCustomer(strs);
        
        
        if(bool){
        	System.out.println("已经保存的数据如下：");
        	   
               	System.out.println("FirstName:"+strs[0]);
               	System.out.println("LastName:"+strs[1]);
               	System.out.println("Email:"+strs[2]);
               	System.out.println("Address:"+add.getAddress());
               
        }else{
        	System.out.println("保存失败");
        }
        
        

        
    }
}
