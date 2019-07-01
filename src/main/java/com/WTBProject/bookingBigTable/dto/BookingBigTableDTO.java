package com.WTBProject.bookingBigTable.dto;


import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.game.model.Game;
import com.WTBProject.user.model.User;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;


public class BookingBigTableDTO {


    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private User user;
    private BigTable bigTable;
    private Game game;

    public BookingBigTableDTO(Long id, Date startDate, Date endDate, User user, BigTable bigTable, Game game) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.bigTable = bigTable;
        this.game = game;
    }

    public BookingBigTableDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigTable getBigTable() {
        return bigTable;
    }

    public void setBigTable(BigTable bigTable) {
        this.bigTable = bigTable;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
