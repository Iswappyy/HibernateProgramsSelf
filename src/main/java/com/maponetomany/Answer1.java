package com.maponetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer1 {
	@Id
	@Column(name = "Answer_id")
	private int AnswerId;
	private String Answer;
   @ManyToOne
	private Question1 question;
	
	
	public Answer1(int answerId, String answer, Question1 question) {
		super();
		AnswerId = answerId;
		Answer = answer;
		this.question = question;
	}


	public Answer1() {
		super();
	}
	

	
	public int getAnswerId() {
		return AnswerId;
	}


	public void setAnswerId(int answerId) {
		AnswerId = answerId;
	}


	public String getAnswer() {
		return Answer;
	}


	public void setAnswer(String answer) {
		Answer = answer;
	}


	public Question1 getQuestion() {
		return question;
	}


	public void setQuestion(Question1 question) {
		this.question = question;
	}


	@Override
	public String toString() {
		return "Answer1 [AnswerId=" + AnswerId + ", Answer=" + Answer + ", question=" + question + "]";
	}


	
}
