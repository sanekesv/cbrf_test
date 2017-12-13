package ru.cbrf.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cbrf.model.Bnkseek;

@Controller
public class WelcomeController {

  private String message = "Hello World";

  @RequestMapping("/")
  public String welcome(Map<String, Object> model) {
//    File dbf = null;
//    try {
//      ClassPathResource classPathResource = new ClassPathResource("/static/dbf/BNKSEEK.DBF");
//      dbf = classPathResource.getFile();
//      System.out.println(dbf.getTotalSpace());
//    }
//    catch (IOException e) {
//      e.printStackTrace();
//    }
    model.put("message", this.message);
    return "welcome";
  }


  @RequestMapping("/load/dbf")
  public String loadDbf(Map<String, Object> map) {
    try {
      File dbf;// = new File("C:/Users/ermolaev/IdeaProjects/cbrf_test/application/src/main/resources/static/dbf/bnkseek.dbf");
      DBFReader reader = null;
      ClassPathResource classPathResource = new ClassPathResource("/static/dbf/bnkseek.dbf");
      dbf = classPathResource.getFile();
      reader = new DBFReader(new FileInputStream(dbf));
      int numberOfFields = reader.getFieldCount();
      for (int i = 0; i < numberOfFields; i++) {

        DBFField field = reader.getField(i);

        // do something with it if you want
        // refer the JavaDoc API reference for more details
        //
        System.out.println(field.getName());
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
return "welcome";
  }
}