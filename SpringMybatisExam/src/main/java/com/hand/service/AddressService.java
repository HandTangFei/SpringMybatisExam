package com.hand.service;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.hand.dto.Address;
import com.hand.serviceInter.AddressInter;


public class AddressService {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static{
		try{
			reader = Resources.getResourceAsReader("config/ApplicationContext.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Address addressIsExist(int id){
		SqlSession session = sqlSessionFactory.openSession();
		Address address = null;
		try {
			AddressInter addressInter = session.getMapper(AddressInter.class);
			address = addressInter.getAddressById(id);
			if(address == null){
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return address;
	}

}
