package com.brownpoodle.login.dao;

import java.util.List;

import com.brownpoodle.login.vo.ID_AuthNumVO;
import com.brownpoodle.login.vo.PW_AuthNumVO;
import com.brownpoodle.member.vo.MemberVO;

public interface LoginDAO {
	public int loginCheck(MemberVO mvo);	// 로그인 체크 - ID,PW DB와 대조 맞으면 로그인 성공
	
	public int idAuthEmailCheck(MemberVO mvo);	// 인증번호 이메일 체크 - 이름, 이메일로 DB 조회 성공시 인증번호
	public List<ID_AuthNumVO> idAuthSeq();// 인증번호 SEQ - 인증번호 생성로직
	public int idAuthInsert(ID_AuthNumVO ivo);// 인증번호 입력 - 생성된 인증번호 DB에 Insert
	public int idAuthSelect(ID_AuthNumVO ivo);// Insert한 인증번호 조회
	public List<MemberVO> idAuthEmailIdFind(MemberVO mvo); //이메일로 아이디 찾기
	
	
	public int pwAuthEmailCheck(MemberVO mvo);//인증번호 이메일 체크 - 아이디, 이메일로 DB 조회 성공시 인증번호
	public List<PW_AuthNumVO> pwAuthSeq();//비밀번호 인증번호 SEQ - 인증번호 생성로직
	public int pwAuthInsert(PW_AuthNumVO pvo);	//비밀번호 인증번호 입력 - 생성된 인증번호 DB에 Insert
	public List<PW_AuthNumVO> pwAuthSelect(PW_AuthNumVO pvo);	//Insert한 인증번호 조회
	public List<PW_AuthNumVO> pwChange(MemberVO mvo);	//비밀번호 인증번호 + 아이디로 비밀번호 찾기
}
