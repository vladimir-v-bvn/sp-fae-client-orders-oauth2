package com.vber.sp_fae_client_orders_oauth2.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vber.sp_fae_client_orders_oauth2.service.ClientOrdersService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@CrossOrigin("*")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8180"})
@RestController
@RequestMapping("/api/v1/clientorders")
public class ClientOrdersController {

  @Autowired
  ClientOrdersService clientOrdersService;

  @GetMapping()
  @RolesAllowed({"app-user", "app-admin"})
  public ResponseEntity<String> vClientOrders() {
  //log.info(userordersService.vClientOrders());
    return ResponseEntity.status(HttpStatus.OK).header("Custom-Header", "").body(clientOrdersService.vClientOrders());
  }

  @GetMapping("/u")
  @RolesAllowed({"app-user"})
  public String u() {
    log.info("app-user only");
    return "app-user only";
  }

  @GetMapping("/a")
  @RolesAllowed({"app-admin"})
  public String a() {
    log.info("app-admin only");
    return "app-admin only";
  }
  
//@PostMapping("/x")
//public Map<String, Object> addX(@RequestBody XDto xDto, @RequestHeader Map<String, String> headers) {
  //headers.forEach((key, value) -> LOG.info(String.format("Header '%s' = %s", key, value)));
  //return eventsService.x(xDto);
//}

}
