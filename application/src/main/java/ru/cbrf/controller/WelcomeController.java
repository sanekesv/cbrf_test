package ru.cbrf.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.cbrf.service.LoadService;

@Controller
public class WelcomeController {

  @Autowired
  private LoadService loadService;

  @RequestMapping("/")
  public String welcome(Map<String, Object> model) {
    return "welcome";
  }


  @RequestMapping("/load/dbf")
  public String loadDbf(Map<String, Object> map) {
    loadService.loadData();
    return "redirect:/";
  }
}