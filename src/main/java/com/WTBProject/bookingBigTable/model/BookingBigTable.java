package com.WTBProject.bookingBigTable.model;

import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.game.model.Game;
import com.WTBProject.user.model.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "BookingBigTable.getReservationsForTheTable", query = "Select bbt.startDate, bbt.endDate from BookingBigTable bbt where bbt.id = :id")
public class BookingBigTable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Date startDate;
  private Date endDate;


  @ManyToOne(cascade = CascadeType.PERSIST)
  private User user;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private BigTable bigTable;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Game game;

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
