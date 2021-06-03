package com.brownpoodle.login.vo;

public class SessionVO {

	private String m_id;
	private String m_name;
	private String m_nick;
	
	public SessionVO() {
	}

	public SessionVO(String m_id, String m_name, String m_nick) {
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_nick = m_nick;
	}

	public String getM_id() {
		return m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public String getM_nick() {
		return m_nick;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}

	
	
}
