package com.vber.sp_fae_client_orders_oauth2.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.vber.sp_fae_client_orders_oauth2.util.rsJSONConversion;

@Repository
public class ClientOrdersRepositoryJdbc {

  private org.slf4j.Logger LOG = LoggerFactory.getLogger(ClientOrdersRepositoryJdbc.class);

  @Autowired
  private JdbcTemplate jdbcTemplate;
  private SimpleJdbcCall simpleJdbcCall;

  public String vClientOrders() {
    return jdbcTemplate.query("SELECT * FROM v_client_orders_camel",  new VTopEventsExtractor());
  }

  private static final class VTopEventsExtractor implements ResultSetExtractor<String> {
    @Override
    public String extractData(ResultSet resultSet) throws SQLException {
      return rsJSONConversion.convertResultSetToJSONArray(resultSet);
    }
  }
  
  
  
}
