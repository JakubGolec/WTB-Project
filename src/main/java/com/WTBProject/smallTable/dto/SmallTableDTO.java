package com.WTBProject.smallTable.dto;

public class SmallTableDTO {


    private Boolean isTableBig;

    public SmallTableDTO(Boolean isTableBig) {
        this.isTableBig = isTableBig;
    }

    public Boolean getTableBig() {
        return isTableBig;
    }

    public void setTableBig(Boolean tableBig) {
        isTableBig = tableBig;
    }


}
