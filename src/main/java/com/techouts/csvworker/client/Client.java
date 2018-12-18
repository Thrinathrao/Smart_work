package com.techouts.csvworker.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techouts.csvworker.model.EmployeeModel;
import com.techouts.csvworker.service.EmployeeService;
/**
 * Hello world!
 *
 */
import com.techouts.csvworker.utility.FileUtility;
public class Client {
	
	private static final Logger LOG=Logger.getLogger(Client.class);
	
	public static void main(String args[]) throws FileNotFoundException, IOException {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeService employeeService=(EmployeeService)context.getBean("employeeService");
		List<EmployeeModel> list=employeeService.getEmpFromFile("C:\\Users\\TO-OW-18\\Desktop\\csvfile\\Employee.csv");
		for(EmployeeModel emp : list){
			LOG.info(emp);
		}
	}
}
