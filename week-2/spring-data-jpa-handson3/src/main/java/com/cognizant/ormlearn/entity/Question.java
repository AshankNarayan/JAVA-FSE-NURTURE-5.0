package com.cognizant.ormlearn.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qt_id")
    private int id;

    @Column(name = "qt_text", length = 255, nullable = false)
    private String text;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<QuizOption> options;

    public Question() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<QuizOption> getOptions() {
        return options;
    }

    public void setOptions(List<QuizOption> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Question[id=" + id + ", text='" + text + "']";
    }
}
