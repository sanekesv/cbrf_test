package ru.cbrf.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.Date;

import com.linuxense.javadbf.DBFReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.cbrf.dao.*;
import ru.cbrf.model.*;

/**
 * Created by ermolaev on 14.12.2017.
 */
@Service
public class LoadService {

  @Value("${dbf.full.path}")
  private String path = "Hello World";

  @Autowired
  private BnkseekDao bnkseekDao;
  @Autowired
  private PznDao pznDao;
  @Autowired
  private RegDao regDao;
  @Autowired
  private TnpDao tnpDao;
  @Autowired
  private UerDao uerDao;

  public void loadData() {
//    try {
//      loadPzn();
//      loadReg();
//      loadTnp();
//      loadUer();
//      loadBnkseek();
//    }
//    catch (IOException e) {
//      e.printStackTrace();
//    }
  }

  private void loadPzn() throws FileNotFoundException {
    File dbf = new File(path + "/cbrf_test/application/src/main/resources/static/dbf/PZN.DBF");
    DBFReader reader;
    reader = new DBFReader(new FileInputStream(dbf), Charset.forName("IBM866"));
    Object[] row;

    while ((row = reader.nextRecord()) != null) {
      Pzn pzn = getPznModel(row);
      pznDao.save(pzn);
    }
  }

  private Pzn getPznModel(Object[] row) {
    Pzn pzn = new Pzn();
    pzn.setVkey(convertToString(row[0]));
    pzn.setPzn(convertToString(row[1]));
    pzn.setImy(convertToString(row[2]));
    pzn.setName(convertToString(row[3]));
    Date cbDate = (Date) row[4];
    if (cbDate != null)
      pzn.setCbDate(new Timestamp(cbDate.getTime()));
    Date ceDate = (Date) row[5];
    if (ceDate != null)
      pzn.setCbDate(new Timestamp(ceDate.getTime()));
    return pzn;
  }

  private void loadReg() throws FileNotFoundException {
    File dbf = new File(path + "/cbrf_test/application/src/main/resources/static/dbf/REG.DBF");
    DBFReader reader;
    reader = new DBFReader(new FileInputStream(dbf), Charset.forName("IBM866"));
    Object[] row;

    while ((row = reader.nextRecord()) != null) {
      Reg reg = getRegModel(row);
      regDao.save(reg);
    }
  }

  private Reg getRegModel(Object[] row) {
    Reg reg = new Reg();
    reg.setVkey(convertToString(row[0]));
    reg.setRgn(convertToString(row[1]));
    reg.setName(convertToString(row[2]));
    reg.setCenter(convertToString(row[3]));
    reg.setNamet(convertToString(row[4]));
    return reg;
  }

  private void loadTnp() throws FileNotFoundException {
    File dbf = new File(path + "/cbrf_test/application/src/main/resources/static/dbf/TNP.DBF");
    DBFReader reader;
    reader = new DBFReader(new FileInputStream(dbf), Charset.forName("IBM866"));
    Object[] row;

    while ((row = reader.nextRecord()) != null) {
      Tnp tnp = getTnpModel(row);
      tnpDao.save(tnp);
    }
  }

  private Tnp getTnpModel(Object[] row) {
    Tnp tnp = new Tnp();
    tnp.setVkey(convertToString(row[0]));
    tnp.setTnp(convertToString(row[1]));
    tnp.setFullname(convertToString(row[2]));
    tnp.setShortname(convertToString(row[3]));
    return tnp;
  }

  private void loadUer() throws FileNotFoundException {
    File dbf = new File(path + "/cbrf_test/application/src/main/resources/static/dbf/UER.DBF");
    DBFReader reader;
    reader = new DBFReader(new FileInputStream(dbf), Charset.forName("IBM866"));
    Object[] row;

    while ((row = reader.nextRecord()) != null) {
      Uer uer = getUerModel(row);
      uerDao.save(uer);
    }
  }

  private Uer getUerModel(Object[] row) {
    Uer tnp = new Uer();
    tnp.setVkey(convertToString(row[0]));
    tnp.setUer(convertToString(row[1]));
    tnp.setUername(convertToString(row[2]));
    return tnp;
  }

  private void loadBnkseek() throws FileNotFoundException {
    File dbf = new File(path + "/cbrf_test/application/src/main/resources/static/dbf/BNKSEEK.DBF");
    DBFReader reader;
    reader = new DBFReader(new FileInputStream(dbf), Charset.forName("IBM866"));
    Object[] row;

    while ((row = reader.nextRecord()) != null) {
      Bnkseek bnkseek = getBnkseekModel(row);
      bnkseekDao.save(bnkseek);
    }
  }

  private Bnkseek getBnkseekModel(Object[] row) {
    Bnkseek bnkseek = new Bnkseek();
    bnkseek.setVkey(convertToString(row[0]));
    bnkseek.setReal(convertToString(row[1]));
    bnkseek.setPznCode(convertToString(row[2]));
    bnkseek.setUerCode(convertToString(row[3]));
    bnkseek.setRgnCode(convertToString(row[4]));
    bnkseek.setInd(convertToString(row[5]));
    bnkseek.setTnpCode(convertToString(row[6]));
    bnkseek.setNnp(convertToString(row[7]));
    bnkseek.setAdr(convertToString(row[8]));
    bnkseek.setRkc(convertToString(row[9]));
    bnkseek.setNamep(convertToString(row[10]));
    bnkseek.setNamen(convertToString(row[11]));
    bnkseek.setNewnum(convertToString(row[12]));
    bnkseek.setNewks(convertToString(row[13]));
    bnkseek.setPermfo(convertToString(row[14]));
    bnkseek.setSrok(convertToString(row[15]));
    bnkseek.setAt1(convertToString(row[16]));
    bnkseek.setAt2(convertToString(row[17]));
    bnkseek.setTelef(convertToString(row[18]));
    bnkseek.setRegn(convertToString(row[19]));
    bnkseek.setOkpo(convertToString(row[20]));
    Date dtIzm = (Date) row[21];
    if (dtIzm != null)
      bnkseek.setDtIzm(new Timestamp(dtIzm.getTime()));
    bnkseek.setCks(convertToString(row[22]));
    bnkseek.setKsnp(convertToString(row[23]));
    Date dateIn = (Date) row[24];
    if (dateIn != null)
      bnkseek.setDateIn(new Timestamp(dateIn.getTime()));
    Date date = (Date) row[25];
    if (date != null)
      bnkseek.setDateCh(new Timestamp(date.getTime()));
    bnkseek.setVkeydel(convertToString(row[26]));
    Date dtIzmr = (Date) row[27];
    if (dtIzmr != null)
      bnkseek.setDtIzmr(new Timestamp(dtIzmr.getTime()));
    return bnkseek;
  }

  private String convertToString(Object o) {
    String s = (String) o;
    if(s.equals(""))
      return null;
    return s;
  }
}
