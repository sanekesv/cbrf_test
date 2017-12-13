package ru.cbrf.model;

import javax.persistence.*;

/**
 * Created by ermolaev on 13.12.2017.
 */
@Entity
@Table(name = "tnp", schema = "bnk")
public class Tnp {
  private String vkey;
  private String tnp;
  private String fullname;
  private String shortname;

  @Id
  @Column(name = "vkey", nullable = false, length = 8)
  public String getVkey() {
    return vkey;
  }

  public void setVkey(String vkey) {
    this.vkey = vkey;
  }

  @Basic
  @Column(name = "tnp", nullable = true, length = -1)
  public String getTnp() {
    return tnp;
  }

  public void setTnp(String tnp) {
    this.tnp = tnp;
  }

  @Basic
  @Column(name = "fullname", nullable = true, length = 255)
  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  @Basic
  @Column(name = "shortname", nullable = true, length = 15)
  public String getShortname() {
    return shortname;
  }

  public void setShortname(String shortname) {
    this.shortname = shortname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Tnp tnp1 = (Tnp) o;

    if (vkey != null ? !vkey.equals(tnp1.vkey) : tnp1.vkey != null) return false;
    if (tnp != null ? !tnp.equals(tnp1.tnp) : tnp1.tnp != null) return false;
    if (fullname != null ? !fullname.equals(tnp1.fullname) : tnp1.fullname != null) return false;
    if (shortname != null ? !shortname.equals(tnp1.shortname) : tnp1.shortname != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = vkey != null ? vkey.hashCode() : 0;
    result = 31 * result + (tnp != null ? tnp.hashCode() : 0);
    result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
    result = 31 * result + (shortname != null ? shortname.hashCode() : 0);
    return result;
  }

}
