package com.WTBProject.bigTable.model;

import com.WTBProject.bookingBigTable.model.BookingBigTable;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "getAllBigTables", query = "Select bt from BigTable bt")
public class BigTable {

  @Id
  private String id;
  private Boolean isTableBig;

  @OneToMany(mappedBy = "bigTable")
  private List<BookingBigTable> bookingBigTable;

  public BigTable(String id, Boolean isTableBig) {
    this.id = id;
    this.isTableBig = isTableBig;
  }

  public BigTable() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Boolean getTableBig() {
    return isTableBig;
  }

  public void setTableBig(Boolean tableBig) {
    isTableBig = tableBig;
  }

//  public List<BookingBigTable> getBooking() {
//    return booking;
//  }
//
//  public void setBooking(List<BookingBigTable> booking) {
//    this.booking = booking;
//  }
}
