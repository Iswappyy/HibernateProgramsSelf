package com.persistentlifecycle;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Student2 {
	@Id
	private int sid ; 
	private String sname;
	private Certificate2 certi;
	
	public Student2(int sid, String sname, Certificate2 certi) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.certi = certi;
	}
	public Student2() {
		super();
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Certificate2 getCerti() {
		return certi;
	}
	public void setCerti(Certificate2 certi) {
		this.certi = certi;
	}
	@Override
	public String toString() {
		return "Student2 [sid=" + sid + ", sname=" + sname + ", certi=" + certi + "]";
	}
	
	

}
