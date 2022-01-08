package com.example.demo.controller;




import com.example.demo.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/products")
public class ProductController {

    ArrayList<Product> products = new ArrayList<>();

    @GetMapping
    public ArrayList<Product> getProduct() {
        return products;
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {

        if (!checkProduct(product)) {
            return ResponseEntity.status(400).body( "Please send all fields");
        }

        products.add(product);
        return ResponseEntity.status(200).body("Product added");
    }
    @PostMapping("/quantity/add")
    public ResponseEntity<String> addQuantity(int id, int amount){
        if(id <= 0 || amount <= 0)
        {
            return ResponseEntity.status(400).body("send all fields");
        }
        if(ProductExist(id))
        {
            for(int i=0; i<products.size();i++)
            {
                if(products.get(i).getId() == id)
                    products.get(i).addAmount(amount);
            }
            return ResponseEntity.status(200).body("quantity added");
        }
        else
            return ResponseEntity.status(400).body("no product for this id");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> removeProduct(Product product){
        if(!checkProduct(product)){
            return ResponseEntity.status(400).body("Please send all the fields");
        }
        if(!ProductExist(product.getId()))
            return ResponseEntity.status(400).body("Product Does Not Exist!");
        for(int i=0; i<products.size();i++)
        {
            if(products.get(i).getId() == product.getId())
            {
                if(products.get(i).getAmount() == 0)
                {
                    products.remove(product);
                }
                else
                {
                    return ResponseEntity.status(400).body(" Amount More Than Zero You Can Not Delete it!");
                }
            }
        }
        return ResponseEntity.status(400).body("delete");
    }
    @DeleteMapping("/deleteTheQuantity")
    public ResponseEntity<String> deleteQuantity(@PathVariable int id, int amount){
        if(id <= 0 || amount <= 0)
        {
            return ResponseEntity.status(400).body("Please send all the fields");
        }
        if(!ProductExist(id))
            return ResponseEntity.status(400).body("No Product for this id");

        for(int i=0; i<products.size();i++)
        {
            if(products.get(i).getId() == id)
            {
                if(products.get(i).getAmount() >= amount)
                {
                    products.get(i).removeAmount(amount);
                    return ResponseEntity.status(200).body("Quantity Removed from The Product");
                }
                else
                {
                    return ResponseEntity.status(400).body("Quantity is Less to be Removed ");
                }
            }
        }
        return ResponseEntity.status(200).body("delete");
    }

    public boolean checkProduct(Product product) {
        if (product.getId() == 0 ||
                product.getName() == null
                || product.getYearOfMake() == null
                || product.getAmount() == 0) {
            return false;
        }
        return true;
    }
    public boolean ProductExist(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId())
                return true;
        }
        return false;
    }
}










//
//import com.example.demo.model.Product;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//
//
//@RestController
//@RequestMapping("/products")
//public class ProductController {
//
//    ArrayList<Product> products = new ArrayList<>();
//
//    @GetMapping
//    public ArrayList<Product> getTheProduct() {
//        return products;
//    }
//
//    @PostMapping
//    public ResponseEntity<String> addTheProduct(@RequestBody Product product) {
//
//        if (!checkProduct(product)) {
//            return ResponseEntity.status(400).body("Please send all the fields");
//        }
////        if (ProductExist(product.getId()))
////            return ResponseEntity.status(400).body("Product exist");
//        products.add(product);
//        return ResponseEntity.status(200).body("Product added");
////    }
////    @PostMapping("/quantity")
////    public String addQuantity(int id, int amount){
////        if(id <= 0 || amount <= 0)
////        {
////            return "Please send all the fields";
////        }
//
//        @PostMapping("/quantity/add")
//        public ResponseEntity<String> addQuantity ( int id, int amount){
//            if (id <= 0 || amount <= 0) {
//                return ResponseEntity.status(400).body("send all fields");
//            }
//            if (ProductExist(id)) {
//                for (int i = 0; i < products.size(); i++) {
//                    if (products.get(i).getId() == id)
//                        products.get(i).addAmount(amount);
//                }
//                return ResponseEntity.status(200).body("quantity added");
//            } else
//                return ResponseEntity.status(400).body("no product for this id");
//        }
//
//
////        if(ProductExist(id))
////        {
////            for(int i=0; i<products.size();i++)
////            {
////                if(products.get(i).getId() == id)
////                    products.get(i).addAmount(amount);
////            }
////            return ResponseEntity.status(200).body("Quantity added for The Product");
////        }
////        else
////            return ResponseEntity.status(400).body("There is No  Product With this ID!");
////    }
//        @DeleteMapping("/deleteproduct")
//        public ResponseEntity<String> removeProduct (Product product){
//            if (!checkProduct(product)) {
//                return ResponseEntity.status(400).body("Please send all the fields");
//            }
//            if (!ProductExist(product.getId()))
//                return ResponseEntity.status(400).body("Product Does Not Exist!");
//            for (int i = 0; i < products.size(); i++) {
//                if (products.get(i).getId() == product.getId()) {
//                    if (products.get(i).getAmount() == 0) {
//                        products.remove(product);
//                    } else {
//                        return ResponseEntity.status(400).body(" Amount More Than Zero You Can Not Delete this product!");
//                    }
//                }
//            }
//            return ResponseEntity.status(400).body("delete");
//        }
//        @DeleteMapping("/deletethequantity")
//        public ResponseEntity<String> deleteQuantity ( @PathVariable int id, int amount){
//            if (id <= 0 || amount <= 0) {
//                return ResponseEntity.status(400).body("Please send all the fields");
//            }
//            if (!ProductExist(id))
//                return ResponseEntity.status(400).body("there is No Product for this id");
//
//            for (int i = 0; i < products.size(); i++) {
//                if (products.get(i).getId() == id) {
//                    if (products.get(i).getAmount() >= amount) {
//                        products.get(i).removeAmount(amount);
//                        return ResponseEntity.status(200).body("Quantity Removed from The Product");
//                    } else {
//                        return ResponseEntity.status(400).body("Quantity is Less to be Removed ");
//                    }
//                }
//            }
//            return ResponseEntity.status(200).body("delete");
//        }
//
//        public boolean checkProduct (Product product){
//            if (product.getId() == 0 ||
//                    product.getName() == null
//                    || product.getYearOfMake() == null
//                    || product.getAmount() == 0) {
//                return false;
//            }
//            return true;
//        }
//        public boolean ProductExist ( int id){
//            for (int i = 0; i < products.size(); i++) {
//                if (id == products.get(i).getId())
//                    return true;
//            }
//            return false;
//        }
//    }

//
//    public boolean checkProduct(Product product) {
//        if (product.getId() == 0 ||
//                product.getName() == null
//                || product.getYearOfMake() == null
//                || product.getAmount() == 0) {
//            return false;
//        }
//        return true;
//    }
//    public boolean ProductExist(int id) {
//        for (int i = 0; i < products.size(); i++) {
//            if (id == products.get(i).getId())
//                return true;
//        }
//        return false;
//    }
//    @PostMapping("/Quantity")
//    public ResponseEntity<String> addQuantity(RequestBody Product id, int amount){
//        if(id <= 0 || amount <= 0)
//        {
//            return "Please send all the fields";
//        }
//        if(ProductExist(id))
//        {
//            for(int i=0; i<products.size();i++)
//            {
//                if(products.get(i).getId() == id)
//                    products.get(i).addAmount(amount);
//            }
//            return "Quantity added for The Product";
//        }
//        else
//            return "There is No  Product With this ID!";
//    }













//import com.example.demo.model.Product;
//import com.example.demo.model.ProductAction;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//
//@RestController
//@RequestMapping("/product")
//public class ProductController {
//
//    ArrayList<Product> products = new ArrayList<>();
//
//
//
//    @GetMapping
//    public ArrayList<Product> getProducts(){return products;}
//
//
//
//    @PostMapping
//    public ResponseEntity<String> addProduct(@RequestBody Product product){
//
//        if(!checkproducts(product)){
//            return ResponseEntity.status(400).body("Please send all the fields");
//        }
//        products.add(product);
//        return ResponseEntity.status(200).body("Product added");
//    }
//    @PostMapping("/quantity")
//    public ResponseEntity<String> quantityAvailable(@RequestBody ProductAction action) {
//        if (action.getId() == null) {
//            return ResponseEntity.status(400).body("no id for you");
//
//        }
//        for (int i = 0; i < products.size(); i++) {
//            Product u = products.get(i);
//
//            if (u.getId().equals(action.getId())) {
//                return ResponseEntity.status(400).body("there is nooooo id");
//            }
//            return ResponseEntity.status(200).body("pro id confirmed");
//        }
//        return ResponseEntity.status(400).body("Invalid ID");
//    }
//
//    public boolean checkproducts (Product product){
//        if(product.getId()==null||
////                product.getUsername()==null
////                || product.getyearOfMake() ==null
////                || product.getamount()==null)
//        {
//            return false;
//        }
//        return  true;
//    }
//}
//



