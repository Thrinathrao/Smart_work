package com.techouts.csvworker.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.techouts.csvworker.model.EmployeeModel;

public interface EmployeeService {
public abstract List<EmployeeModel> getEmpFromFile(String path) throws FileNotFoundException, IOException;
}
