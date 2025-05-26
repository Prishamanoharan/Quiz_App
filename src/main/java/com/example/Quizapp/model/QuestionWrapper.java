package com.example.Quizapp.model;
public class QuestionWrapper {

    private Integer id;
    private String category;
    private String difficultylevel;
    private String option1;
    private String option2;
    private String option3;
    private String ans;
    private String title;

   
    public QuestionWrapper(Integer id, String category, String difficultylevel,
                           String option1, String option2, String option3,
                           String title, String ans) {
        super();
        this.id = id;
        this.category = category;
        this.difficultylevel = difficultylevel;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.ans = ans;
        this.title = title;
    }

    // Getters and setters

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

    public String getDifficultylevel() {
        return difficultylevel;
    }

    public void setDifficultylevel(String difficultylevel) {
        this.difficultylevel = difficultylevel;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
