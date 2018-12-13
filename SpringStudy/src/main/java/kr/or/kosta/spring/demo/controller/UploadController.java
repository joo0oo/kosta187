package kr.or.kosta.spring.demo.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload form .. ");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		log.info("upload form action..");
		
		String uploadFolder="C:\\upload";
		
		for (MultipartFile multipartFile : uploadFile) {
			log.info("-----------------------------------------------------------");
			log.info("upload file name : "+multipartFile.getOriginalFilename());
			log.info("upload file size : "+multipartFile.getSize());
			
			File saveFile= new File(uploadFolder, multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(saveFile); //업로드된 파일을 uploadFolder 경로에 저장
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax");
	}
	
	@PostMapping("/uploadAjaxAction")
	public void uploadAjaxPost(MultipartFile[] uploadFile) {
		log.info("update ajax post............");
		String uploadFolder="C:\\upload";
		for(MultipartFile multipartFile : uploadFile) {
			log.info("-----------------------------------------------------------");
			log.info("upload file name : "+multipartFile.getOriginalFilename());
			log.info("upload file size : "+multipartFile.getSize());
			
			String uploadFileName= multipartFile.getOriginalFilename();
			log.info("only file name : "+uploadFileName);
			
			File saveFile= new File(uploadFolder, uploadFileName);
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}
}
