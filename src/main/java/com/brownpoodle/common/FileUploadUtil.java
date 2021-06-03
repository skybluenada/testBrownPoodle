package com.brownpoodle.common;

import java.io.File;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUploadUtil {
	private Logger logger = Logger.getLogger(FileUploadUtil.class);

	public boolean uploadFile(MultipartHttpServletRequest request, String dirName) {
		String basepath = request.getSession().getServletContext()
				.getRealPath("resources" + File.separator + "img" + File.separator + dirName);
		System.out.println("basepath: " + basepath);

		File temp = new File(basepath);
		if (!temp.isDirectory()) {
			boolean r = temp.mkdirs();
			System.out.println("r : " + r);
		}

		try {
			Iterator<String> iterator = request.getFileNames();

			String uploadFileName = "";
			MultipartFile mFile = null;
			String orgFileName = ""; // 업로드한 파일명
			String uploadPath = "";

			while (iterator.hasNext()) {
				uploadFileName = iterator.next();
				mFile = request.getFile(uploadFileName);

				orgFileName = mFile.getOriginalFilename();
				System.out.println("orgFileName : " + orgFileName);

				uploadPath = basepath + File.separator + orgFileName;
				System.out.println("upload path :" + uploadPath);

				File f = FileRename.rename(new File(uploadPath));

				mFile.transferTo(f);
			} // while end

			return true;
		} catch (Exception e) {
			System.out.println("[ERROR] file upload error! -> " + e.getMessage());
		}

		return false;
	}
}
