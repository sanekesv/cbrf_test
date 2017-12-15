package ru.cbrf.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cbrf.service.LoadService;

@Controller
public class IndexController {

  @RequestMapping("/")
  public String welcome(Map<String, Object> model) {
    return "welcome";
  }

  @RequestMapping("/view/data")
  public String viewDataPage(){
    return "dataPage";
  }


}