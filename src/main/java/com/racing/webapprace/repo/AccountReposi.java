package com.racing.webapprace.repo;

import com.racing.webapprace.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountReposi extends CrudRepository<Account, Integer> {

//    @Query("from Account a where a.email = ?")
//    Account queryByEmail(String email);
//
//    List<Account> findByFirstNameLike(String email);

}
