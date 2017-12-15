package ru.cbrf.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.cbrf.dao.BnkseekDao;
import ru.cbrf.model.*;
import ru.cbrf.service.LoadService;

/**
 * Created by ermolaev on 15.12.2017.
 */
@Controller
@RequestMapping(value = "/load")
public class LoaderController {

  @Autowired
  private LoadService loadService;

  @RequestMapping(value = "/dbf", method = RequestMethod.POST)
  @ResponseBody
  public String loadDbf(Map<String, Object> map) {
    try {
      loadService.loadData();
    }
    catch (Exception e) {
      return "{\"status\":" + e.getMessage() + "}";
    }
//    try {
//      Thread.sleep(5*1000); // 5sec
//    }
//    catch (InterruptedException e) {
//      e.printStackTrace();
//    }
    return "{\"status\":\"Ok\"}";
  }

  @RequestMapping(value = "/pzn", method = RequestMethod.GET)
  @ResponseBody
  public List<Pzn> getAllPzn(){
    return loadService.getAllPzn();
  }

  @RequestMapping(value = "/reg", method = RequestMethod.GET)
  @ResponseBody
  public List<Reg> getAllReg(){
    return loadService.getAllReg();
  }

  @RequestMapping(value = "/tnp", method = RequestMethod.GET)
  @ResponseBody
  public List<Tnp> getAllTnp(){
    return loadService.getAllTnp();
  }

  @RequestMapping(value = "/uer", method = RequestMethod.GET)
  @ResponseBody
  public List<Uer> getAllUer(){
    return loadService.getAllUer();
  }

//  @RequestMapping(value = "/bnkseek", method = RequestMethod.GET)
//  @ResponseBody
//  public Page<Bnkseek> getAllBnkseek(@RequestParam int page){
//
//    return loadService.getAllBnkseek(page);
//  }

  @RequestMapping(value = "/bnkseek", method = RequestMethod.GET)
  @ResponseBody
  public Page<Bnkseek> getBnkseekByNamep(@RequestParam(required=false) String rkc, @RequestParam(required=false) String reg, @RequestParam(required=false) String pzn, @RequestParam(defaultValue = "0") int page){
    return loadService.getBnkseekByNamep(rkc, reg, pzn, page);
  }
}
