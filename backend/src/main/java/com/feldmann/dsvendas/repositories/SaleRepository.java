package com.feldmann.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.feldmann.dsvendas.dto.SaleSucessDTO;
import com.feldmann.dsvendas.dto.SaleSumDTO;
import com.feldmann.dsvendas.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT new com.feldmann.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))  "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.feldmann.dsvendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited),SUM(obj.deals))  "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSucessDTO> sucessGroupedBySeller();
}