package com.dao.bankingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dao.bankingsystem.entity.TransferType;

@Repository
public interface TransferTypeRepository extends JpaRepository<TransferType, String> {

}
