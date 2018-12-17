package com.techouts.csvworker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.techouts.model.EmployeeModel;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String args[]) throws FileNotFoundException,
			IOException {
		System.out
				.println("Reading from CSV file using BufferedReader and String Split");
		List nations = readCSV();
		//print(nations);
	}

	/*
	 * Java program to read CVS file using BufferedReader and String split()
	 * method
	 */
	private static final String csvfile = "countries.csv";

	public static List readCSV() throws FileNotFoundException, IOException {
		List countries = new ArrayList<>();
		if (csvfile.endsWith(".csv")) {
			BufferedReader br = new BufferedReader(new FileReader(csvfile));
			String line = br.readLine(); // Reading header, Ignoring
			while ((line = br.readLine()) != null && !line.isEmpty()) {
				String[] fields = line.split(",");
				String name = fields[0];
				String Empid = fields[1];
				String Address = fields[2];
				EmployeeModel nation = new EmployeeModel(name, Empid, Address);
				countries.add(nation);
			}
			br.close();
		} else {

		}
		return countries;
	}

	/*public static void print(List countries) {
		System.out.println("========================");
		for (EmployeeModel country : countries) {
			System.out.println(country);
		}
		System.out.println("========================");
	}*/

}
