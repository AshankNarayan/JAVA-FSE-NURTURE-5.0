package com.cognizant.ormlearn.entity;

import javax.persistence.*;

@Entity
@Table(name = "quiz_option")
public class QuizOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "op_qt_id")
    private Question question;

    @Column(name = "op_text", length = 100, nullable = false)
    private String text;

    @Column(name = "op_is_correct", nullable = false)
    private boolean correct;

    @Column(name = "op_score", nullable = false)
    private double score;

    public QuizOption() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "QuizOption[id=" + id + ", text='" + text + "', correct=" + correct + ", score=" + score + "]";
    }
}
