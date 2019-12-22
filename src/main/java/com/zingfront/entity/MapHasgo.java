package com.zingfront.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MapHasgo {

  private long id;
  private String date;
  private String memo;
  private String province;
  private Date createTime;
  private long userid;
  private BigDecimal posX;
  private BigDecimal posY;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }


  public BigDecimal getPosX() {
    return posX;
  }

  public void setPosX(BigDecimal posX) {
    this.posX = posX;
  }


  public BigDecimal getPosY() {
    return posY;
  }

  public void setPosY(BigDecimal posY) {
    this.posY = posY;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
