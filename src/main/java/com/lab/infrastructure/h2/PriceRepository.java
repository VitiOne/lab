package com.lab.infrastructure.h2;


import com.lab.infrastructure.h2.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Prices,Long> {


    @Query("SELECT p FROM prices p WHERE " +
            "p.brandId = :brandId AND " +
            "p.productId = :productId AND " +
            "(:dateTime BETWEEN p.startDate AND p.endDate) " +
            "order by p.priority desc")
    List<Prices> price(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("dateTime") LocalDateTime dateTime);
}
