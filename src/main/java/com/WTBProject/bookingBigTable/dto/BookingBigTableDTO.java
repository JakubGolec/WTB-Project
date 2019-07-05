package com.WTBProject.bookingBigTable.dto;


import com.WTBProject.bigTable.dto.BigTableDTO;
import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.game.model.Game;
import com.WTBProject.user.model.User;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;


public class BookingBigTableDTO {



    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private User user;
    private BigTableDTO bigTableDTO;
    private Game game;

    public BookingBigTableDTO(Date startDate, Date endDate, User user, BigTableDTO bigTableDTO, Game game) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.bigTableDTO = bigTableDTO;
        this.game = game;
    }

    public BookingBigTableDTO() {
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

    public BigTableDTO getBigTableDTO() {
        return bigTableDTO;
    }

    public void setBigTableDTO(BigTableDTO bigTableDTO) {
        this.bigTableDTO = bigTableDTO;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
