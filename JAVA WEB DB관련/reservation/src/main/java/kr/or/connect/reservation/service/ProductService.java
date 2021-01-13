package kr.or.connect.reservation.service;

import java.util.*;

import kr.or.connect.reservation.dto.Product;

public interface ProductService {
    public static final int MAX = 4;

    public List<Product> getProductList(int categoryId, int start);

}