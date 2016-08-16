package com.hand;

import java.util.Scanner;

import com.hand.dto.Address;
import com.hand.dto.Customer;
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
//		Address add = addser.addressIsExist(5) ;
      
		CustomerService cuser = new CustomerService();
		String[] strs = cuser.inputInfo();
		System.out.println("Before insert Customer Data");

		boolean bool = cuser.saveCustomer(strs);


		if(bool){
			Customer customer = cuser.getCustomer();
			Address add = new Address();
			if(customer != null){
				add = addser.addressIsExist(customer.getAddress_id());
				System.out.println("已经保存的数据如下：");
				System.out.println("ID："+customer.getCustomer_id());
				System.out.println("FirstName:"+customer.getFirst_name());
				System.out.println("LastName:"+customer.getLast_name());
				System.out.println("Email:"+customer.getEmail());
				System.out.println("Address:"+add.getAddress());
			}

		}else{
			System.out.println("保存失败");
		}
		
		
		System.out.println("\nAfter Insert Customer Data\n");
		System.out.println("请输入要删除的Customer的ID：");
		Scanner sc = new Scanner(System.in);
		
		
		
	}
}
