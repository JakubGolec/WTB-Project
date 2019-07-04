package com.WTBProject.bigTable.dto;

public class BigTableDTO {

  public BigTableDTO(String id, Boolean isTableBig) {
    this.id = id;
    this.isTableBig = isTableBig;
  }

  public BigTableDTO() {
  }

  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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
