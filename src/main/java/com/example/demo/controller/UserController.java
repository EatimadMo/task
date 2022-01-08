package com.example.demo.controller;


import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    ArrayList<Product> product=new ArrayList<>();

}
