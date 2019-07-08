package com.WTBProject.bookingBigTable.dto;


import com.WTBProject.bigTable.dto.BigTableDTO;
import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.game.dto.GameDTO;
import com.WTBProject.game.model.Game;
import com.WTBProject.user.dto.UserDTO;
import com.WTBProject.user.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class BookingBigTableDTO {

  private Long id;

  private Date startDate;
  private Date endDate;
  private UserDTO userDTO;
  private BigTableDTO bigTableDTO;
  private GameDTO gameDTO;

  public BookingBigTableDTO(Date startDate, Date endDate, UserDTO userDTO, BigTableDTO bigTableDTO, GameDTO gameDTO) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.userDTO = userDTO;
    this.bigTableDTO = bigTableDTO;
    this.gameDTO = gameDTO;
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

  public UserDTO getUserDTO() {
    return userDTO;
  }

  public void setUserDTO(UserDTO userDTO) {
    this.userDTO = userDTO;
  }

  public BigTableDTO getBigTableDTO() {
    return bigTableDTO;
  }

  public void setBigTableDTO(BigTableDTO bigTableDTO) {
    this.bigTableDTO = bigTableDTO;
  }

  public GameDTO getGameDTO() {
    return gameDTO;
  }

  public void setGameDTO(GameDTO gameDTO) {
    this.gameDTO = gameDTO;
  }
}
