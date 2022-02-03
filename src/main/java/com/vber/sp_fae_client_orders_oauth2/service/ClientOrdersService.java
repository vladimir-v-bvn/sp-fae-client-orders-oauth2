package com.vber.sp_fae_client_orders_oauth2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vber.sp_fae_client_orders_oauth2.repository.ClientOrdersRepositoryJdbc;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ClientOrdersService {

  private final ClientOrdersRepositoryJdbc clientOrdersRepositoryJdbc;

  public String vClientOrders() {
    return clientOrdersRepositoryJdbc.vClientOrders();
  }

}
