package com.WTBProject.game.model;


import org.springframework.data.annotation.Id;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean isBigTableRequired;

    public Game(String name, Boolean isBigTableRequired) {
        this.name = name;
        this.isBigTableRequired = isBigTableRequired;
    }

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getBigTableRequired() {
        return isBigTableRequired;
    }

    public void setBigTableRequired(Boolean bigTableRequired) {
        isBigTableRequired = bigTableRequired;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isBigTableRequired=" + isBigTableRequired +
                '}';
    }
}
