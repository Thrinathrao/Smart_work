package com.techouts.csvworker.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.log4j.Logger;

public class FileUtility {

	private static final Logger LOG=Logger.getLogger(FileUtility.class);
	
	public BufferedReader readFile(String path) throws FileNotFoundException{
		BufferedReader bufferedReader = null;
		File file=new File(path);
		if(file.exists() && file.isFile()){  
			FileReader fileReader=new FileReader(file);
			bufferedReader=new BufferedReader(fileReader);
		}
		return bufferedReader;
	}
	
	public void createDir(String path){ 
		File file=new File(path);
		LOG.debug("File already exists : "+file.exists());
		if(!file.exists()){
			file.mkdirs();
			LOG.debug("File/Directory created accordingly: "+file.getAbsolutePath());
		}
	}
}
