package com.brownpoodle.login.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.brownpoodle.common.GoogleMailSend;
import com.brownpoodle.common.PasswordUtil;
import com.brownpoodle.login.service.LoginService;
import com.brownpoodle.login.vo.ID_AuthNumVO;
import com.brownpoodle.login.vo.SessionVO;
import com.brownpoodle.member.vo.MemberVO;

@Controller
public class LoginController {
	Logger logger = Logger.getLogger(LoginController.class);
	
	private LoginService loginService;

	@Autowired(required = false)
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage() {
		logger.info("LoginController loginPage() >>> : ");
		return "login/login";
	}
	
	@RequestMapping(value = "loginTry", method = RequestMethod.POST)
	public ModelAndView loginTry(MemberVO mvo,
								 HttpSession session)
										 throws Exception {
		logger.info("LoginController loginTry() >>> : ");
		ModelAndView mv = new ModelAndView();
		
		int nCnt = loginService.loginCheck(mvo);
		
		if(nCnt > 0) {
			SessionVO svo = new SessionVO();
			svo.setM_id(mvo.getM_id());
			svo.setM_name(mvo.getM_name());
			svo.setM_nick(mvo.getM_nick());
			session.setAttribute("m_id", svo.getM_id());
			session.setAttribute("m_nick", svo.getM_nick());
			mv.setViewName("login/loginSucc");
			
		}else {
			mv.setViewName("login/login");
		}
		return mv;
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mv = new ModelAndView("login/login");
		return mv;
	}
	
	
	@RequestMapping(value = "idFind", method = RequestMethod.GET)
	public String idFind() {
		logger.info("LoginController idFind() >>> : ");
		return "login/idFind";
	}
	
	
	@RequestMapping(value="idAuthEmailCheck", method = RequestMethod.GET)
	public ModelAndView idAuthEmailCheck(MemberVO mvo) {
		
		ModelAndView mv = new ModelAndView();
		int nCnt = loginService.idAuthEmailCheck(mvo);
		
		if(nCnt > 0) {
			
			String id_num = loginService.idAuthSeq().get(0).getId_num();
			String id_auth_num = PasswordUtil.randomPW(8);
			
			ID_AuthNumVO ivo = null;
			ivo = new ID_AuthNumVO();
			
			ivo.setId_num(id_num);
			ivo.setId_auth_num(id_auth_num);
			ivo.setM_email(mvo.getM_email());
			
			int authNcnt = loginService.idAuthInsert(ivo);
			
			if(authNcnt > 0) {
				
				String mailSubject = "ID찾기 인증번호";
				String sendMail = "kosmojbin@gmail.com";
				String sendPw = "whdqlsl12";
				String receiveMail = ivo.getM_email();
				String confirmNum = ivo.getId_auth_num(); 
				String sendMsg = "\t요청하신 인증번호는 ["+ confirmNum + "] 입니다.\n\t 인증번호 입력란에 입력하세요"; 
				
				
				GoogleMailSend gms = new GoogleMailSend();
				gms.googleMailSend(mailSubject, sendMail, sendPw, receiveMail, sendMsg);
				
				mv.addObject("authnum", ivo.getId_auth_num());
				mv.setViewName("login/idEmailCheck");
				
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "idAuthEmailIdFind")
	public ModelAndView idAuthEmailIdFind(MemberVO mvo, ID_AuthNumVO ivo) {
		
		ModelAndView mv = new ModelAndView();
		
		int nCnt = loginService.idAuthSelect(ivo);
		
		if(nCnt > 0) {
			List<MemberVO> iList = loginService.idAuthEmailIdFind(mvo);
			
			if(iList != null) {
				mv.addObject("iList", iList);
				mv.setViewName("login/idFindOK");
			}else {
				mv.setViewName("login/idFind");
			}
			
		}else {
			
		}
		return mv;
	}
	
	

}
