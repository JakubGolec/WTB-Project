package com.WTBProject.bookingBigTable.model;
import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.game.model.Game;
import com.WTBProject.user.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BookingBigTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDate;
    private Date endDate;


    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private BigTable bigTable;

    @OneToOne(fetch = FetchType.LAZY)
    private Game game;

    public BookingBigTable(Date startDate, Date endDate, User user, BigTable bigTable, Game game) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.bigTable = bigTable;
        this.game = game;
    }

    public BookingBigTable() {
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
