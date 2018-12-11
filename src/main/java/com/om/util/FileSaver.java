package com.om.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	//1. Spring에서 제공하는 fileCopyUtils의 copy 메서드 사용
	public String saveFile(String realPath, MultipartFile multipartFile) throws Exception{
		String fileSystemName="";
		//1.저장할 경로명
		
		//2.저장할 파일명
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		fileSystemName= UUID.randomUUID().toString();
		String oname = multipartFile.getOriginalFilename();
		oname=oname.substring(oname.lastIndexOf('.'));//뒤에서부터 .의 인덱스 번호르 받아서 거기서부터 잘라서 가져오자 
		fileSystemName = fileSystemName+oname;
		System.out.println(fileSystemName);
		file = new File(realPath, fileSystemName);//이 객채의 정보를 저장하자
		
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileSystemName;
	}
	
	//2. OutPutStream 이용
	public String saveFile2(String realPath, MultipartFile multipartFile)throws Exception{
		
		String fileSystemName="";
		//1.저장할 경로명
		
		//2.저장할 파일명
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		fileSystemName= UUID.randomUUID().toString();
		String oname = multipartFile.getOriginalFilename();
		oname=oname.substring(oname.lastIndexOf('.'));//뒤에서부터 .의 인덱스 번호르 받아서 거기서부터 잘라서 가져오자 
		fileSystemName = fileSystemName+oname;
		file = new File(realPath, fileSystemName);//이 객채의 정보를 저장하자
		
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(multipartFile.getBytes());
		
		return fileSystemName;
	}
	
	//3.MultipartFile의 transferTo 메서드 사용
	public String saveFile3(String realPath, MultipartFile multipartFile)throws Exception{
		
		String fileSystemName="";
		//1.저장할 경로명
		
		//2.저장할 파일명
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		fileSystemName= UUID.randomUUID().toString();
		String oname = multipartFile.getOriginalFilename();
		oname=oname.substring(oname.lastIndexOf('.'));//뒤에서부터 .의 인덱스 번호르 받아서 거기서부터 잘라서 가져오자 
		fileSystemName = fileSystemName+oname;
		file = new File(realPath, fileSystemName);//이 객채의 정보를 저장하자
		
		multipartFile.transferTo(file);
		
		return fileSystemName;
	}

}
