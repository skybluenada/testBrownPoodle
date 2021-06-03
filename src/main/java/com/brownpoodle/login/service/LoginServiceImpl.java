package com.brownpoodle.login.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brownpoodle.login.dao.LoginDAO;
import com.brownpoodle.login.vo.ID_AuthNumVO;
import com.brownpoodle.login.vo.PW_AuthNumVO;
import com.brownpoodle.member.vo.MemberVO;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	Logger logger = Logger.getLogger(LoginServiceImpl.class);
	
	private LoginDAO loginDAO;
	
	public LoginServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired(required = false)
	public LoginServiceImpl(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	
	@Override
	public int loginCheck(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("LoginServiceImpl loginCheck() >>> : ");
		return loginDAO.loginCheck(mvo);
	}

	@Override
	public int idAuthEmailCheck(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("LoginServiceImpl idAuthEmailCheck() >>> : ");
		return loginDAO.idAuthEmailCheck(mvo);
	}

	@Override
	public List<ID_AuthNumVO> idAuthSeq() {
		// TODO Auto-generated method stub
		logger.info("LoginServiceImpl idAuthSeq() >>> : ");
		return loginDAO.idAuthSeq();
	}

	@Override
	public int idAuthInsert(ID_AuthNumVO ivo) {
		// TODO Auto-generated method stub
		logger.info("LoginServiceImpl idAuthInsert() >>> : ");
		return loginDAO.idAuthInsert(ivo);
	}

	@Override
	public int idAuthSelect(ID_AuthNumVO ivo) {
		// TODO Auto-generated method stub
		logger.info("LoginServiceImpl idAuthSelect() >>> : ");
		return loginDAO.idAuthSelect(ivo);
	}

	@Override
	public List<MemberVO> idAuthEmailIdFind(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("LoginServiceImpl idAuthEmailIdFind() >>> : ");
		return loginDAO.idAuthEmailIdFind(mvo);
	}

	//------------------------------------------------------------------------------
	
	@Override
	public int pwAuthEmailCheck(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("LoginServiceImpl pwAuthEmailCheck() >>> : ");
		return loginDAO.pwAuthEmailCheck(mvo);
	}

	@Override
	public List<PW_AuthNumVO> pwAuthSeq() {
		// TODO Auto-generated method stub
		logger.info("LoginServiceImpl pwAuthSeq() >>> : ");
		return loginDAO.pwAuthSeq();
	}

	@Override
	public int pwAuthInsert(PW_AuthNumVO pvo) {
		// TODO Auto-generated method stub
		logger.info("LoginServiceImpl pwAuthInsert() >>> : ");
		return loginDAO.pwAuthInsert(pvo);
	}

	@Override
	public List<PW_AuthNumVO> pwAuthSelect(PW_AuthNumVO pvo) {
		// TODO Auto-generated method stub
		logger.info("LoginServiceImpl pwAuthSelect() >>> : ");
		return loginDAO.pwAuthSelect(pvo);
	}

	@Override
	public List<PW_AuthNumVO> pwChange(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("LoginServiceImpl pwAuthEmailPwFind() >>> : ");
		return loginDAO.pwChange(mvo);
	}

}
