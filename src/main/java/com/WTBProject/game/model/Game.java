package com.WTBProject.game.model;

import javax.persistence.*;


@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Boolean isBigTableRequired;

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

}
