package com.brownpoodle.login.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brownpoodle.login.vo.ID_AuthNumVO;
import com.brownpoodle.login.vo.PW_AuthNumVO;
import com.brownpoodle.member.vo.MemberVO;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	Logger logger = Logger.getLogger(LoginDAOImpl.class);
	
	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;

	@Override
	public int loginCheck(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("LoginDAOImpl loginCheck() >>> : ");
		return sqlSession.selectOne("loginCheck", mvo);
	}
	
	

	@Override
	public int idAuthEmailCheck(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("LoginDAOImpl idAuthEmailCheck() >>> : ");
		return sqlSession.selectOne("idAuthEmailCheck", mvo);
	}

	@Override
	public List<ID_AuthNumVO> idAuthSeq() {
		// TODO Auto-generated method stub
		logger.info("LoginDAOImpl idAuthSeq() >>> : ");
		return sqlSession.selectOne("idAuthSeq");
	}

	@Override
	public int idAuthInsert(ID_AuthNumVO ivo) {
		// TODO Auto-generated method stub
		logger.info("LoginDAOImpl idAuthInsert() >>> : ");
		return (Integer)sqlSession.insert("idAuthInsert", ivo);
	}

	@Override
	public int idAuthSelect(ID_AuthNumVO ivo) {
		// TODO Auto-generated method stub
		logger.info("LoginDAOImpl idAuthSelect() >>> : ");
		return sqlSession.selectOne("idAuthSelect", ivo);
	}

	@Override
	public List<MemberVO> idAuthEmailIdFind(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("LoginDAOImpl idAuthEmailIdFind() >>> : ");
		return sqlSession.selectList("idAuthEmailIdFind", mvo);
		
	}
	
	//-----------------------------------------------------------------------------

	@Override
	public int pwAuthEmailCheck(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("LoginDAOImpl pwAuthEmailCheck() >>> : ");
		return sqlSession.selectOne("pwAuthEmailCheck", mvo);
	}

	@Override
	public List<PW_AuthNumVO> pwAuthSeq() {
		// TODO Auto-generated method stub
		logger.info("LoginDAOImpl pwAuthSeq() >>> : ");
		return (List)sqlSession.selectList("pwAuthSeq");
	}

	@Override
	public int pwAuthInsert(PW_AuthNumVO pvo) {
		// TODO Auto-generated method stub
		logger.info("LoginDAOImpl pwAuthInsert() >>> : ");
		return sqlSession.insert("pwAuthInsert", pvo);
	}

	@Override
	public List<PW_AuthNumVO> pwAuthSelect(PW_AuthNumVO pvo) {
		// TODO Auto-generated method stub
		logger.info("LoginDAOImpl pwAuthSelect() >>> : ");
		return (List)sqlSession.selectList("pwAuthSelect", pvo);
	}

	@Override
	public List<PW_AuthNumVO> pwChange(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("LoginDAOImpl pwAuthEmailPwFind() >>> : ");
		return (List)sqlSession.selectList("pwChange", mvo);
	}

}
