package ru.cbrf.model;

import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Created by ermolaev on 13.12.2017.
 */
@Entity
@Table(name = "pzn", schema = "bnk")
public class Pzn {
  private String vkey;
  private String pzn;
  private String imy;
  private String name;
  private Timestamp cbDate;
  private Timestamp ceDate;

  @Id
  @Column(name = "vkey", nullable = false, length = 8)
  public String getVkey() {
    return vkey;
  }

  public void setVkey(String vkey) {
    this.vkey = vkey;
  }

  @Basic
  @Column(name = "pzn", nullable = true, length = 2)
  public String getPzn() {
    return pzn;
  }

  public void setPzn(String pzn) {
    this.pzn = pzn;
  }

  @Basic
  @Column(name = "imy", nullable = true, length = 10)
  public String getImy() {
    return imy;
  }

  public void setImy(String imy) {
    this.imy = imy;
  }

  @Basic
  @Column(name = "name", nullable = true, length = 255)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "cb_date", nullable = true)
  public Timestamp getCbDate() {
    return cbDate;
  }

  public void setCbDate(Timestamp cbDate) {
    this.cbDate = cbDate;
  }

  @Basic
  @Column(name = "ce_date", nullable = true)
  public Timestamp getCeDate() {
    return ceDate;
  }

  public void setCeDate(Timestamp ceDate) {
    this.ceDate = ceDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pzn pzn1 = (Pzn) o;

    if (vkey != null ? !vkey.equals(pzn1.vkey) : pzn1.vkey != null) return false;
    if (pzn != null ? !pzn.equals(pzn1.pzn) : pzn1.pzn != null) return false;
    if (imy != null ? !imy.equals(pzn1.imy) : pzn1.imy != null) return false;
    if (name != null ? !name.equals(pzn1.name) : pzn1.name != null) return false;
    if (cbDate != null ? !cbDate.equals(pzn1.cbDate) : pzn1.cbDate != null) return false;
    if (ceDate != null ? !ceDate.equals(pzn1.ceDate) : pzn1.ceDate != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = vkey != null ? vkey.hashCode() : 0;
    result = 31 * result + (pzn != null ? pzn.hashCode() : 0);
    result = 31 * result + (imy != null ? imy.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (cbDate != null ? cbDate.hashCode() : 0);
    result = 31 * result + (ceDate != null ? ceDate.hashCode() : 0);
    return result;
  }

}
