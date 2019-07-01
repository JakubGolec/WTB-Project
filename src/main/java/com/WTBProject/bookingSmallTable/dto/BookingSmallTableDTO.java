package com.WTBProject.bookingSmallTable.dto;

import com.WTBProject.game.model.Game;
import com.WTBProject.smallTable.dto.SmallTableDTO;
import com.WTBProject.smallTable.model.SmallTable;
import com.WTBProject.user.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookingSmallTableDTO {


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private User user;
    private SmallTableDTO smallTableDTO;
    private Game game;

    public BookingSmallTableDTO(Date startDate, Date endDate, User user, SmallTableDTO smallTableDTO, Game game) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.smallTableDTO = smallTableDTO;
        this.game = game;
    }

    public BookingSmallTableDTO() {
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

    public SmallTableDTO getSmallTable() {
        return smallTableDTO;
    }

    public void setSmallTable(SmallTable smallTable) {
        this.smallTableDTO = smallTableDTO;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
