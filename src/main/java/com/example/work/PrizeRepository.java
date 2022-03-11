package com.example.work;

import org.springframework.data.jpa.repository.JpaRepository;
/***
 * Работа с данными для призов
 */
public interface  PrizeRepository extends JpaRepository<Prize, Long> {
}
