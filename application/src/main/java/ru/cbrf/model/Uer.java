package ru.cbrf.model;

import javax.persistence.*;

/**
 * Created by ermolaev on 13.12.2017.
 */
@Entity
@Table(name = "uer", schema = "bnk")
public class Uer {
  private String vkey;
  private String uer;
  private String uername;

  @Id
  @Column(name = "vkey", nullable = false, length = 8)
  public String getVkey() {
    return vkey;
  }

  public void setVkey(String vkey) {
    this.vkey = vkey;
  }

  @Basic
  @Column(name = "uer", nullable = true, length = -1)
  public String getUer() {
    return uer;
  }

  public void setUer(String uer) {
    this.uer = uer;
  }

  @Basic
  @Column(name = "uername", nullable = true, length = 255)
  public String getUername() {
    return uername;
  }

  public void setUername(String uername) {
    this.uername = uername;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Uer uer1 = (Uer) o;

    if (vkey != null ? !vkey.equals(uer1.vkey) : uer1.vkey != null) return false;
    if (uer != null ? !uer.equals(uer1.uer) : uer1.uer != null) return false;
    if (uername != null ? !uername.equals(uer1.uername) : uer1.uername != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = vkey != null ? vkey.hashCode() : 0;
    result = 31 * result + (uer != null ? uer.hashCode() : 0);
    result = 31 * result + (uername != null ? uername.hashCode() : 0);
    return result;
  }


}
