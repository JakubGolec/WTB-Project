package com.WTBProject.bigTable.dto;

public class BigTableDTO {


    private Boolean isTableBig;

    public BigTableDTO(Boolean isTableBig) {
        this.isTableBig = isTableBig;
    }

    public Boolean getTableBig() {
        return isTableBig;
    }

    public void setTableBig(Boolean tableBig) {
        isTableBig = tableBig;
    }


}
