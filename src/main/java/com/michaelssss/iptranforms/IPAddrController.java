package com.michaelssss.iptranforms;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "IPAddr")
public class IPAddrController {

  @RequestMapping(value = "transform")
  public Response transform(@RequestBody Request request) {
    Response response = new Response();
    try {
      IPAddr ipAddr = IPAddr.newInstance(request.getAddr());
      response.setResult(ipAddr.getInteger());
    } catch (RuntimeException e) {
      response.setResult(e.getMessage());
    }
    return response;
  }
}
