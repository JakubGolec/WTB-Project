package com.WTBProject.bigTable.model;

import com.WTBProject.bookingBigTable.model.BookingBigTable;

import javax.persistence.*;

@Entity
public class BigTable {

    @Id
    private String id;
    private Boolean isTableBig;

    @OneToOne(mappedBy = "bigTable")
    private BookingBigTable booking;

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
}
