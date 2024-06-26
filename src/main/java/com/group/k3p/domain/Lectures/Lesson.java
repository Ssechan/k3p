package com.group.k3p.domain.Lectures;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group.k3p.domain.quiz.Quiz;
import com.group.k3p.domain.user.UserLesson;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본 키.

    private String title; // 강의 제목
    private String subject; // 강의 주제
    private String url; // 강의 URL

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course; // 강의가 속한 코스

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonBackReference
    private Quiz quiz; // 강의와 관련된 퀴즈

    @OneToMany(mappedBy = "lesson")
    @JsonManagedReference
    private List<UserLesson> userLessons;

    // 기본 생성자
    public Lesson() {
    }

    // 사용자 정의 생성자, Getter 및 Setter 생략
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<UserLesson> getUserLessons() {
        return userLessons;
    }

    public void setUserLessons(List<UserLesson> userLessons) {
        this.userLessons = userLessons;
    }
}
