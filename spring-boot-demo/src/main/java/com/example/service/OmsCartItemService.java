package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class OmsCartItemService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Object find(String id) {
        String sql = "SELECT * FROM oms_cart_item WHERE id='" + id + "'";
        Map<String, Object> result = jdbcTemplate.queryForMap(sql);
        return result;
    }
}
