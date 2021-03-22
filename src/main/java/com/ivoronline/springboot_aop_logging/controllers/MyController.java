package com.ivoronline.springboot_aop_logging.controllers;

import com.ivoronline.springboot_aop_logging.log.LogExecutionTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @LogExecutionTime
  @ResponseBody
  @RequestMapping("/Hello")
  public String hello() {
    return "Hello from Controller";
  }

}
