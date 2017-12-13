package ru.cbrf.model;

import javax.persistence.*;

/**
 * Created by ermolaev on 13.12.2017.
 */
@Entity
@Table(name = "reg", schema = "bnk")
public class Reg {
  private String vkey;
  private String rgn;
  private String name;
  private String center;
  private String namet;

  @Id
  @Column(name = "vkey", nullable = false, length = 8)
  public String getVkey() {
    return vkey;
  }

  public void setVkey(String vkey) {
    this.vkey = vkey;
  }

  @Basic
  @Column(name = "rgn", nullable = true, length = 2)
  public String getRgn() {
    return rgn;
  }

  public void setRgn(String rgn) {
    this.rgn = rgn;
  }

  @Basic
  @Column(name = "name", nullable = true, length = 100)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "center", nullable = true, length = 100)
  public String getCenter() {
    return center;
  }

  public void setCenter(String center) {
    this.center = center;
  }

  @Basic
  @Column(name = "namet", nullable = true, length = 100)
  public String getNamet() {
    return namet;
  }

  public void setNamet(String namet) {
    this.namet = namet;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Reg reg = (Reg) o;

    if (vkey != null ? !vkey.equals(reg.vkey) : reg.vkey != null) return false;
    if (rgn != null ? !rgn.equals(reg.rgn) : reg.rgn != null) return false;
    if (name != null ? !name.equals(reg.name) : reg.name != null) return false;
    if (center != null ? !center.equals(reg.center) : reg.center != null) return false;
    if (namet != null ? !namet.equals(reg.namet) : reg.namet != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = vkey != null ? vkey.hashCode() : 0;
    result = 31 * result + (rgn != null ? rgn.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (center != null ? center.hashCode() : 0);
    result = 31 * result + (namet != null ? namet.hashCode() : 0);
    return result;
  }

}
