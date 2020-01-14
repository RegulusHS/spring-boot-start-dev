package com.example.controller;

import com.example.service.OmsCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/omsCartItem")
public class OmsCartItemController {
    @Autowired
    private OmsCartItemService omsCartItemService;

    @GetMapping("/findById/{id}")
    private Object findById(@PathVariable String id) {
        return omsCartItemService.find(id);
    }
}
