package ru.cbrf.model;

import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Created by ermolaev on 13.12.2017.
 */
@Entity
@Table(name = "bnkseek", schema = "bnk")
public class Bnkseek {
  private String vkey;
  private String real;
  private String pznCode;
  private String uerCode;
  private String rgnCode;
  private String ind;
  private String tnpCode;
  private String nnp;
  private String adr;
  private String rkc;
  private String namep;
  private String namen;
  private String newnum;
  private String newks;
  private String permfo;
  private String srok;
  private String at1;
  private String at2;
  private String telef;
  private String regn;
  private String okpo;
  private Timestamp dtIzm;
  private String cks;
  private String ksnp;
  private Timestamp dateIn;
  private Timestamp dateCh;
  private String vkeydel;
  private Timestamp dtIzmr;
  private Pzn pzn;
  private Uer uer;
  private Reg reg;
  private Tnp tnp;

  @Id
  @Column(name = "vkey", nullable = false, length = 8)
  public String getVkey() {
    return vkey;
  }

  public void setVkey(String vkey) {
    this.vkey = vkey;
  }

  @Basic
  @Column(name = "real", nullable = true, length = 4)
  public String getReal() {
    return real;
  }

  public void setReal(String real) {
    this.real = real;
  }

  @Basic
  @Column(name = "pzn", nullable = true, length = 2)
  public String getPznCode() {
    return pznCode;
  }

  public void setPznCode(String pznCode) {
    this.pznCode = pznCode;
  }

  @Basic
  @Column(name = "uer", nullable = true, length = 2)
  public String getUerCode() {
    return uerCode;
  }

  public void setUerCode(String uerCode) {
    this.uerCode = uerCode;
  }

  @Basic
  @Column(name = "rgn", nullable = true, length = 2)
  public String getRgnCode() {
    return rgnCode;
  }

  public void setRgnCode(String rgnCode) {
    this.rgnCode = rgnCode;
  }

  @Basic
  @Column(name = "ind", nullable = true, length = 6)
  public String getInd() {
    return ind;
  }

  public void setInd(String ind) {
    this.ind = ind;
  }

  @Basic
  @Column(name = "tnp", nullable = true, length = -1)
  public String getTnpCode() {
    return tnpCode;
  }

  public void setTnpCode(String tnpCode) {
    this.tnpCode = tnpCode;
  }

  @Basic
  @Column(name = "nnp", nullable = true, length = 25)
  public String getNnp() {
    return nnp;
  }

  public void setNnp(String nnp) {
    this.nnp = nnp;
  }

  @Basic
  @Column(name = "adr", nullable = true, length = 30)
  public String getAdr() {
    return adr;
  }

  public void setAdr(String adr) {
    this.adr = adr;
  }

  @Basic
  @Column(name = "rkc", nullable = true, length = 9)
  public String getRkc() {
    return rkc;
  }

  public void setRkc(String rkc) {
    this.rkc = rkc;
  }

  @Basic
  @Column(name = "namep", nullable = true, length = 45)
  public String getNamep() {
    return namep;
  }

  public void setNamep(String namep) {
    this.namep = namep;
  }

  @Basic
  @Column(name = "namen", nullable = true, length = 30)
  public String getNamen() {
    return namen;
  }

  public void setNamen(String namen) {
    this.namen = namen;
  }

  @Basic
  @Column(name = "newnum", nullable = true, length = 9)
  public String getNewnum() {
    return newnum;
  }

  public void setNewnum(String newnum) {
    this.newnum = newnum;
  }

  @Basic
  @Column(name = "newks", nullable = true, length = 9)
  public String getNewks() {
    return newks;
  }

  public void setNewks(String newks) {
    this.newks = newks;
  }

  @Basic
  @Column(name = "permfo", nullable = true, length = 6)
  public String getPermfo() {
    return permfo;
  }

  public void setPermfo(String permfo) {
    this.permfo = permfo;
  }

  @Basic
  @Column(name = "srok", nullable = true, length = 2)
  public String getSrok() {
    return srok;
  }

  public void setSrok(String srok) {
    this.srok = srok;
  }

  @Basic
  @Column(name = "at1", nullable = true, length = 7)
  public String getAt1() {
    return at1;
  }

  public void setAt1(String at1) {
    this.at1 = at1;
  }

  @Basic
  @Column(name = "at2", nullable = true, length = 7)
  public String getAt2() {
    return at2;
  }

  public void setAt2(String at2) {
    this.at2 = at2;
  }

  @Basic
  @Column(name = "telef", nullable = true, length = 25)
  public String getTelef() {
    return telef;
  }

  public void setTelef(String telef) {
    this.telef = telef;
  }

  @Basic
  @Column(name = "regn", nullable = true, length = 9)
  public String getRegn() {
    return regn;
  }

  public void setRegn(String regn) {
    this.regn = regn;
  }

  @Basic
  @Column(name = "okpo", nullable = true, length = 8)
  public String getOkpo() {
    return okpo;
  }

  public void setOkpo(String okpo) {
    this.okpo = okpo;
  }

  @Basic
  @Column(name = "dt_izm", nullable = true)
  public Timestamp getDtIzm() {
    return dtIzm;
  }

  public void setDtIzm(Timestamp dtIzm) {
    this.dtIzm = dtIzm;
  }

  @Basic
  @Column(name = "cks", nullable = true, length = 6)
  public String getCks() {
    return cks;
  }

  public void setCks(String cks) {
    this.cks = cks;
  }

  @Basic
  @Column(name = "ksnp", nullable = true, length = 20)
  public String getKsnp() {
    return ksnp;
  }

  public void setKsnp(String ksnp) {
    this.ksnp = ksnp;
  }

  @Basic
  @Column(name = "date_in", nullable = true)
  public Timestamp getDateIn() {
    return dateIn;
  }

  public void setDateIn(Timestamp dateIn) {
    this.dateIn = dateIn;
  }

  @Basic
  @Column(name = "date_ch", nullable = true)
  public Timestamp getDateCh() {
    return dateCh;
  }

  public void setDateCh(Timestamp dateCh) {
    this.dateCh = dateCh;
  }

  @Basic
  @Column(name = "vkeydel", nullable = true, length = 8)
  public String getVkeydel() {
    return vkeydel;
  }

  public void setVkeydel(String vkeydel) {
    this.vkeydel = vkeydel;
  }

  @Basic
  @Column(name = "dt_izmr", nullable = true)
  public Timestamp getDtIzmr() {
    return dtIzmr;
  }

  public void setDtIzmr(Timestamp dtIzmr) {
    this.dtIzmr = dtIzmr;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Bnkseek bnkseek = (Bnkseek) o;

    if (vkey != null ? !vkey.equals(bnkseek.vkey) : bnkseek.vkey != null) return false;
    if (real != null ? !real.equals(bnkseek.real) : bnkseek.real != null) return false;
    if (pznCode != null ? !pznCode.equals(bnkseek.pznCode) : bnkseek.pznCode != null) return false;
    if (rgnCode != null ? !rgnCode.equals(bnkseek.rgnCode) : bnkseek.rgnCode != null) return false;
    if (ind != null ? !ind.equals(bnkseek.ind) : bnkseek.ind != null) return false;
    if (tnpCode != null ? !tnpCode.equals(bnkseek.tnpCode) : bnkseek.tnpCode != null) return false;
    if (nnp != null ? !nnp.equals(bnkseek.nnp) : bnkseek.nnp != null) return false;
    if (adr != null ? !adr.equals(bnkseek.adr) : bnkseek.adr != null) return false;
    if (rkc != null ? !rkc.equals(bnkseek.rkc) : bnkseek.rkc != null) return false;
    if (namep != null ? !namep.equals(bnkseek.namep) : bnkseek.namep != null) return false;
    if (namen != null ? !namen.equals(bnkseek.namen) : bnkseek.namen != null) return false;
    if (newnum != null ? !newnum.equals(bnkseek.newnum) : bnkseek.newnum != null) return false;
    if (newks != null ? !newks.equals(bnkseek.newks) : bnkseek.newks != null) return false;
    if (permfo != null ? !permfo.equals(bnkseek.permfo) : bnkseek.permfo != null) return false;
    if (srok != null ? !srok.equals(bnkseek.srok) : bnkseek.srok != null) return false;
    if (at1 != null ? !at1.equals(bnkseek.at1) : bnkseek.at1 != null) return false;
    if (at2 != null ? !at2.equals(bnkseek.at2) : bnkseek.at2 != null) return false;
    if (telef != null ? !telef.equals(bnkseek.telef) : bnkseek.telef != null) return false;
    if (regn != null ? !regn.equals(bnkseek.regn) : bnkseek.regn != null) return false;
    if (okpo != null ? !okpo.equals(bnkseek.okpo) : bnkseek.okpo != null) return false;
    if (dtIzm != null ? !dtIzm.equals(bnkseek.dtIzm) : bnkseek.dtIzm != null) return false;
    if (cks != null ? !cks.equals(bnkseek.cks) : bnkseek.cks != null) return false;
    if (ksnp != null ? !ksnp.equals(bnkseek.ksnp) : bnkseek.ksnp != null) return false;
    if (dateIn != null ? !dateIn.equals(bnkseek.dateIn) : bnkseek.dateIn != null) return false;
    if (dateCh != null ? !dateCh.equals(bnkseek.dateCh) : bnkseek.dateCh != null) return false;
    if (vkeydel != null ? !vkeydel.equals(bnkseek.vkeydel) : bnkseek.vkeydel != null) return false;
    if (dtIzmr != null ? !dtIzmr.equals(bnkseek.dtIzmr) : bnkseek.dtIzmr != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = vkey != null ? vkey.hashCode() : 0;
    result = 31 * result + (real != null ? real.hashCode() : 0);
    result = 31 * result + (pznCode != null ? pznCode.hashCode() : 0);
    result = 31 * result + (rgnCode != null ? rgnCode.hashCode() : 0);
    result = 31 * result + (ind != null ? ind.hashCode() : 0);
    result = 31 * result + (tnpCode != null ? tnpCode.hashCode() : 0);
    result = 31 * result + (nnp != null ? nnp.hashCode() : 0);
    result = 31 * result + (adr != null ? adr.hashCode() : 0);
    result = 31 * result + (rkc != null ? rkc.hashCode() : 0);
    result = 31 * result + (namep != null ? namep.hashCode() : 0);
    result = 31 * result + (namen != null ? namen.hashCode() : 0);
    result = 31 * result + (newnum != null ? newnum.hashCode() : 0);
    result = 31 * result + (newks != null ? newks.hashCode() : 0);
    result = 31 * result + (permfo != null ? permfo.hashCode() : 0);
    result = 31 * result + (srok != null ? srok.hashCode() : 0);
    result = 31 * result + (at1 != null ? at1.hashCode() : 0);
    result = 31 * result + (at2 != null ? at2.hashCode() : 0);
    result = 31 * result + (telef != null ? telef.hashCode() : 0);
    result = 31 * result + (regn != null ? regn.hashCode() : 0);
    result = 31 * result + (okpo != null ? okpo.hashCode() : 0);
    result = 31 * result + (dtIzm != null ? dtIzm.hashCode() : 0);
    result = 31 * result + (cks != null ? cks.hashCode() : 0);
    result = 31 * result + (ksnp != null ? ksnp.hashCode() : 0);
    result = 31 * result + (dateIn != null ? dateIn.hashCode() : 0);
    result = 31 * result + (dateCh != null ? dateCh.hashCode() : 0);
    result = 31 * result + (vkeydel != null ? vkeydel.hashCode() : 0);
    result = 31 * result + (dtIzmr != null ? dtIzmr.hashCode() : 0);
    return result;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pzn", referencedColumnName = "pzn", insertable = false, updatable = false)
  public Pzn getPzn() {
    return pzn;
  }

  public void setPzn(Pzn pzn) {
    this.pzn = pzn;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "uer", referencedColumnName = "uer", insertable = false, updatable = false)
  public Uer getUer() {
    return uer;
  }

  public void setUer(Uer uer) {
    this.uer = uer;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rgn", referencedColumnName = "rgn", insertable = false, updatable = false)
  public Reg getReg() {
    return reg;
  }

  public void setReg(Reg reg) {
    this.reg = reg;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tnp", referencedColumnName = "tnp", insertable = false, updatable = false)
  public Tnp getTnp() {
    return tnp;
  }

  public void setTnp(Tnp tnp) {
    this.tnp = tnp;
  }
}
