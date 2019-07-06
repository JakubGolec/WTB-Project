package com.WTBProject.bookingSmallTable.model;
import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.game.model.Game;
import com.WTBProject.smallTable.model.SmallTable;
import com.WTBProject.user.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BookingSmallTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDate;
    private Date endDate;


    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private SmallTable smallTable;

    @OneToOne(fetch = FetchType.LAZY)
    private Game game;


    public BookingSmallTable(Date startDate, Date endDate, User user, SmallTable smallTable, Game game) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.smallTable = smallTable;
        this.game = game;
    }

    public BookingSmallTable() {
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

    public SmallTable getSmallTable() {
        return smallTable;
    }

    public void setSmallTable(SmallTable smallTable) {
        this.smallTable = smallTable;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
