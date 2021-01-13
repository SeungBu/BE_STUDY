package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.CategoryService;

import java.util.*;

@RestController
@RequestMapping(path = "/category")
public class CategoryApiController {
	 @Autowired
	    CategoryService categoryService;

	    @GetMapping
	    public Map<String, Object> categoryList() {
	        List<Category> categoryList = categoryService.getCategoryList();
	        Map<String, Object> map = new HashMap<>();
	        map.put("categoryList", categoryList);
	        return map;
	    }
}
