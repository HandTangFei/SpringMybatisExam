package com.hand.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dto.Customer;
import com.hand.serviceInter.CustomerInter;

public class CustomerService {

   	private static ApplicationContext ctx;
	static
	{
		ctx = new ClassPathXmlApplicationContext("config/ApplicationContext.xml");
	}
	
	
	
	@SuppressWarnings("resource")
	public String[] inputInfo(){
		String[] strs = new String[4];
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入FirstName(first_name)：");
		String m=sc.next();
		strs[0] = m;

		sc=new Scanner(System.in);
		System.out.println("请输入LastName(last_name)：");
		m=sc.next();
		strs[1] = m;

		sc=new Scanner(System.in);
		System.out.println("请输入Email(email)：");
		m=sc.next();
		strs[2] = m;

		sc=new Scanner(System.in);
		System.out.println("请输入Address ID：");
		m=sc.next();
		int id = Integer.parseInt(m);
		while(new AddressService().addressIsExist(id) == null){
			System.out.println("你输入的Address ID不存在，请重新输入：");
			m=sc.next();
			id = Integer.parseInt(m);
		}
		strs[3] = m;
		sc.close();
		return strs;

	}

	public boolean saveCustomer(String[] strs){
		boolean bool = false;
		Customer customer = new Customer();
		try {
			customer.setStore_id(1);
			customer.setActive(1);
			customer.setFirst_name(strs[0]);
			customer.setLast_name(strs[1]);
			customer.setEmail(strs[2]);
			customer.setAddress_id(Integer.parseInt(strs[3]));
			Date now = new Date(); 
//			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			customer.setCreate_date(format.format(now));
			customer.setLast_update(format.format(now));
			
    		CustomerInter customerMapper =  (CustomerInter) ctx.getBean("customerMapper");
    		customerMapper.addCustomer(customer);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	public Customer getCustomer(){
		Customer customer = new Customer();
		try {
    		CustomerInter customerMapper =  (CustomerInter) ctx.getBean("customerMapper");
    		customer = customerMapper.getCustomer();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return customer;
	}

}
