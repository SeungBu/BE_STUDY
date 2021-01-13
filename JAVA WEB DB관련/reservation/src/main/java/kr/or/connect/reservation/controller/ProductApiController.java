package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

import java.util.*;

@RestController
@RequestMapping(path = "/product")
public class ProductApiController {
    @Autowired
    ProductService productService;

    @GetMapping
    public Map<String, Object> productList(@RequestParam(name = "categoryId", required = false, defaultValue = "6") int categoryId,
                                           @RequestParam(name = "start", required = false, defaultValue = "0") int start) {
        List<Product> productList = productService.getProductList(categoryId, start);
        Map<String, Object> map = new HashMap<>();
        map.put("productList", productList);
        map.put("totalCount", productList.size());
        return map;
    }
}