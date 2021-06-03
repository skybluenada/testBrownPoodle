package com.brownpoodle.kosmobp;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.brownpoodle.common.CommonUtil;
import com.brownpoodle.common.FileUploadUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	Logger logger = Logger.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "test/hello";
	}

	@RequestMapping(value = "gofiletest", method = RequestMethod.GET)
	public String goFilePage(Model model) {
		logger.info("파일 업로드페이지로 이동하는 함수 진입! ");

		return "test/fileTest";
	}
	
	/*
	@RequestMapping(value = "/filetest.bp", method = RequestMethod.POST)
	public String fileTest(MultipartHttpServletRequest request) {
		if(request != null) {
			//file upload location
			
			System.out.println("request.getContextPath() :" +request.getContextPath());
			
			String basepath = request.getSession().getServletContext().getRealPath("resources/img/");
			System.out.println(basepath);
//			if(new File(basepath).isDirectory()) {
//				logger.info("basepath >>> : " + basepath);
				
				//=============== upload file to path ===============//
				Iterator<String> names = request.getFileNames();
				Map<String, MultipartFile> map = request.getFileMap();
				String key = null;
				
				logger.info("단일 파일 업로드 메소드 호출, 길이 >>> : " + map.size());
				
				while(names.hasNext()) {
					String name = names.next();
					MultipartFile mpf = map.get(name);
					
					if(!mpf.isEmpty()) {
						logger.info("name >>> : " + name);
						int pos = mpf.getOriginalFilename().lastIndexOf(".");
						String extension = mpf.getOriginalFilename().substring(pos + 1);
						logger.info("extension >>> : " + extension);
						
//						key = getUUIDKey(basepath, extension); //create key					
						File file = new File(basepath + "//" + name);
						FileOutputStream fos = null;
						try {
							fos = new FileOutputStream(file);
							fos.write(mpf.getBytes());
													
							fos.close();
							fos = null;
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							if(fos != null)	{
								try	{
									fos.close();
									fos = null;
								} catch (Exception ignore) {}		
							}
						}
					} else {
						//업로드된 파일이 없을 경우 업로드를 하지 않고 null값 반환
						key = null;
						System.out.println("파일 업로드 안됨 ");
					}
				} // while end
//			} // if end
		}
		return "test/fileTestOK";
	}*/


	@RequestMapping(value = "filetest", method = RequestMethod.POST)
	public String fileTest(MultipartHttpServletRequest request, Model model) {
		logger.info("파일 업로드 controller 진입!!!");
		FileUploadUtil fu = new FileUploadUtil();
		
		boolean result = fu.uploadFile(request, "boardimg");
		System.out.println(result);
		if (result) {
			model.addAttribute("message", "file upload complete!");
		}
//		System.out.println("file name: "+ request.getFileNames());
//		String basepath = request.getSession().getServletContext().getRealPath("resources/img/");
//
//			try {
//				System.out.println("try ~ catch문 진입! ");
//				Iterator<String> iterator = request.getFileNames();
//				
//		        String uploadFileName;
//		        MultipartFile mFile = null;
//		        String orgFileName = ""; //진짜 파일명
//		        String sysFileName = ""; //변환된 파일명
//		        
////		        ArrayList<String> list = new ArrayList<String>();
//		        
//		        while(iterator.hasNext()) {
//		            uploadFileName = iterator.next();
//		            mFile = request.getFile(uploadFileName);
//		            
//		            orgFileName = mFile.getOriginalFilename();    
//		            System.out.println(orgFileName);
//		            
//		            if(orgFileName != null && orgFileName.length() != 0) { //sysFileName 생성
//		                System.out.println("if문 진입");
//		                
//		                try {
//		                    System.out.println("try 진입");
//		                    mFile.transferTo(new File("/Users/daseul/Downloads/" + orgFileName));
//		                    
//		                }catch(Exception e){
//		                	System.out.println("error !!!!!!");
//		                }
//		            }//if
//		        }//while
//		        
////		        model.addAttribute("list", list);
//				
//			} catch (Exception ex) {
//				request.setAttribute("message", "There was an error: " + ex.getMessage());
//			}
			
		return "test/fileTestOK";
	}

}