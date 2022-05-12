package com.ashspell.movie.common;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.ashspell.movie.common.FileManagerService;

public class FileManagerService {

	
public final static String FILE_UPLOAD_PATH = "C:\\Users\\오상곤\\Desktop\\springworkspace\\movietime\\upload\\images";
	
	
	private static Logger logger = LoggerFactory.getLogger(FileManagerService.class);
	
	
	// 파일 저장 후 접근 경로 리턴
	public static String saveFile(int userId, MultipartFile file) {
		
		if(file == null) {
			
			logger.error("FileManagerService-saveFile : 파일 없음");
			
			
			
			return null;
		}
		
		// 파일 경로
		// 파일 이름이 겹치는 것을 방지하기 위해 사용자 별로 폴더를 구분한다
		// 같은 사용자가 같은 파일이름 겹치는것을 방지하기위해 현재시간을 폴더이름에 포함시킨다
		// UNIX time : 1970년 1월 1일 0시0분0초 기준으로 현재 몇 millisecond 초가 지났는지
		// /images/6_24358234/asdf.jpg
		
		String directoryName = userId + "_" + System.currentTimeMillis() + "/";
		
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		// 디렉토리 생성
		File directory = new File(filePath);
		if(directory.mkdir() == false) {
			// 디렉토리 생성 에러
			logger.error("FileManagerService-saveFile : 디렉토리 생성 에러");
			return null;
		}
		
		// 파일 저장
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());
			Files.write(path, bytes);
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			logger.error("FileManagerService-saveFile : 파일 저장 실패");
			return null;
		}
		
		// <img src = "/images/6_24358234/test.png">
		
		return "/images/" + directoryName + file.getOriginalFilename();
		
		
	}
		// 파일 삭제 
		public static boolean removeFile(String filePath) {
			
			if(filePath == null) {
				logger.error("FileManagerService-removeFile : 파일 없음");
				
				return false;
			}
			
			
			String realFilePath = FILE_UPLOAD_PATH + filePath.replace("/images/", "");
			
			// 파일 삭제 
			Path path = Paths.get(realFilePath);
			// 파일이 있는지 확인
			if(Files.exists(path)) {
				try {
					Files.delete(path);
				} catch (IOException e) {
					logger.error("FileManagerService-removeFile : 파일 삭제 실패");
					e.printStackTrace();
					return false;
				}
			}
			
			
			path = path.getParent();
			
			// 디렉토리 존재 여부 확인
			if(Files.exists(path)) {
				try {
					Files.delete(path);
				} catch (IOException e) {
					logger.error("FileManagerService-removeFile : 디렉토리 삭제 실패");
					e.printStackTrace();
					return false;
				}
			}
			return true;
		}

}