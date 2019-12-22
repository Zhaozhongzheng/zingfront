package com.zingfront.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MapPlango {

  private long id;
  private String content;
  private long userid;
  private Date createTime;
  private BigDecimal posX;
  private BigDecimal posY;
  private String province;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
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

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }
}
