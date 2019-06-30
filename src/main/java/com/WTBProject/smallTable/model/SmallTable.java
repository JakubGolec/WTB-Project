package com.WTBProject.smallTable.model;

import com.WTBProject.bookingSmallTable.model.BookingSmallTable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SmallTable {

    @Id
    private String id;
    private Boolean isTableBig;

    @OneToOne(mappedBy = "smallTable")
    private BookingSmallTable bookingSmallTable;

    public SmallTable(String id, Boolean isTableBig) {
        this.id = id;
        this.isTableBig = isTableBig;
    }

    public SmallTable() {
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
