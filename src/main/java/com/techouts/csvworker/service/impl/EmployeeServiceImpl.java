package com.techouts.csvworker.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.techouts.csvworker.dao.EmployeeDAO;
import com.techouts.csvworker.model.EmployeeModel;
import com.techouts.csvworker.service.EmployeeService;
import com.techouts.csvworker.utility.FileUtility;

public class EmployeeServiceImpl implements EmployeeService {

	private String filePrefix;
	private String fileSuffix;
	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private FileUtility fileUtility;


	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public EmployeeServiceImpl(String filePrefix, String fileSuffix) {
		super();
		this.filePrefix = filePrefix;
		this.fileSuffix = fileSuffix;
	}




	public List<EmployeeModel> getEmpFromFile(String path) throws FileNotFoundException, IOException {
		BufferedReader reader = null;
		List<EmployeeModel> empList = null;
		File file = new File(path);
		String fileName = file.getName();

		if (file.isFile() && fileName.startsWith(filePrefix) && fileName.endsWith(fileSuffix)) {

			reader = fileUtility.readFile(path);
			if (reader != null) {
				empList = new ArrayList<EmployeeModel>();

				String line = reader.readLine(); // Reading header, Ignoring
				while ((line = reader.readLine()) != null && !line.isEmpty()) {
					EmployeeModel employee=new EmployeeModel();
					String[] fields = line.split(",");
					employee.setEmpID(fields[0]);
					employee.setFirstName(fields[1]);
					employee.setMiddleName(fields[2]);
					employee.setSurname(fields[3]);
					employee.setGender(fields[4]);
					employee.setMobile(fields[5]);
					employee.setAddressLine1(fields[6]);
					employee.setAddressLine2(fields[7]);
					employee.setAddressLine3(fields[8]);
					employee.setCity(fields[9]);
					employee.setState(fields[10]);
					employee.setCountry(fields[11]);
					employee.setPincode(Integer.parseInt(fields[12]));
					empList.add(employee);
				}
			}

		}
		if (reader != null) {
			reader.close();
		}
		return empList;
	}
}
