package com.example.Quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity


public class Questions {
	   
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	private String category;
    public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getDifficultylevel() {
		return difficultylevel;
	}
	public void setDifficultylevel(String difficultylevel) {
		this.difficultylevel = difficultylevel;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}

	private String option1;
    private String option2;
    private String option3;
    private String difficultylevel;
    private String ans;
    public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}

	private String ques;
	private String Title;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
}
