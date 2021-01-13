package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.PromotionService;

@RestController
@RequestMapping(path = "/promotion")
public class PromotionApiController {
    @Autowired
    PromotionService promotionService;

    @GetMapping
    public Map<String, Object> promotionList() {
        List<Promotion> promotionList = promotionService.getPromotionList();
        int count = promotionList.size();
        Map<String, Object> map = new HashMap<>();
        map.put("promotionList", promotionList);
        map.put("count", count);
        return map;
    }
}