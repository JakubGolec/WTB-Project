package com.WTBProject.bigtable.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BigTable {

    @Id
    private String id;
    private Boolean isTableBig;

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
