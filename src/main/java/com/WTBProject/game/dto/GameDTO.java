package com.WTBProject.game.dto;

public class GameDTO {
    private Long id;
    private String name;
    private Boolean isBigTableRequired;

    public GameDTO(Long id, String name, Boolean isBigTableRequired) {
        this.id = id;
        this.name = name;
        this.isBigTableRequired = isBigTableRequired;
    }

    public GameDTO(String name, Boolean isBigTableRequired) {
        this.name = name;
        this.isBigTableRequired = isBigTableRequired;
    }

    public GameDTO() {
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
        return "GameDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isBigTableRequired=" + isBigTableRequired +
                '}';
    }
}
