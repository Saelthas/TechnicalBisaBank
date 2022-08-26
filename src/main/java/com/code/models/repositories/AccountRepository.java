package com.code.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.code.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	@Modifying
	@Query(value="UPDATE ACCOUNT SET STATUS=true WHERE ID=:id", nativeQuery=true)
	public void statusAccountActive(@Param("id") Long id);
	@Modifying
	@Query(value="UPDATE ACCOUNT SET STATUS=false WHERE ID=:id", nativeQuery=true)
	public void statusAccountHold(@Param("id") Long id);
}
