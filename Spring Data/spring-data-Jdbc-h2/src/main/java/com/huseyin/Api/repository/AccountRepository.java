package com.huseyin.Api.repository;

import com.huseyin.Api.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account , Integer> {


    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountByName(@Param("name") String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(@Param("id") int id,@Param("amount") BigDecimal amount);

}
