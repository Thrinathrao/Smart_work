package com.techouts.csvworker.dao;

import java.util.List;

import com.techouts.csvworker.model.EmployeeModel;

public interface EmployeeDAO {

	public abstract boolean insertOrUpdate(List<EmployeeModel> data);
	
	public abstract boolean remove(String id);
	
}
