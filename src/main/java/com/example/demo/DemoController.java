package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @GetMapping("/")
  public ResponseEntity<String> hello() {
    return ResponseEntity.ok("Hello World!");
  }

  @GetMapping("/menus")
  public ResponseEntity<List<Map<String, Object>>> menus() {
    List<Map<String, Object>> menus = jdbcTemplate.queryForList("SELECT * FROM lunch_menu");
    return ResponseEntity.ok(menus);
  }
}
