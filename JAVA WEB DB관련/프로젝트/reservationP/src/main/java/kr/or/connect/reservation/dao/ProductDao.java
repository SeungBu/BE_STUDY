package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.DaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Product;

@Repository
public class ProductDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

    public ProductDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Product> selectAllProductList(int categoryId, int start, int limit) {
        Map<String, Integer> params = new HashMap<>();
        if (categoryId == 6) {
            params.put("start", start);
            params.put("limit", limit);
            return jdbc.query(SELECT_ALL_PRODUCT_LIST, params, rowMapper);
        }
        params.put("CATEGORY_ID", categoryId);
        params.put("start", start);
        params.put("limit", limit);
        return jdbc.query(SELECT_PRODUCT_LIST_BY_CATEGORY_ID, params, rowMapper);
    }
}