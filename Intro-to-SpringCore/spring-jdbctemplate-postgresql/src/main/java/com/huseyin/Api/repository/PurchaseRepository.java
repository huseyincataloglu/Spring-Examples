package com.huseyin.Api.repository;

import com.huseyin.Api.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
        Purchase row = new Purchase();
        row.setId(r.getInt("id"));
        row.setPrice(r.getBigDecimal("price"));
        row.setProduct(r.getString("product"));
        return row;
    };

    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storePurchase(Purchase purchase){
        String sql = "INSERT INTO purchase(product,price) VALUES (?,?)";

        jdbcTemplate.update(sql,purchase.getProduct(),purchase.getPrice());
    }

    public List<Purchase> listAllPurchases() {
        String query = "SELECT * FROM purchase";
        return jdbcTemplate.query(query, purchaseRowMapper);
    }

    public List<Purchase> listAllPurchases(int id) {
        String query = "SELECT * FROM purchase WHERE id = ?";
        return jdbcTemplate.query(query, new Object[]{id}, purchaseRowMapper);
    }
    public void deletePurchase(int id){
        String sql = "DELETE FROM purchase WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
    public void deleteALlPurchases(){
        String sql = "DELETE FROM purchase";
        jdbcTemplate.update(sql);
    }




}
