package com.example.work;

import org.springframework.data.jpa.repository.JpaRepository;
/***
 * Работа с данными для результатов
 */
public interface ResultRepository extends JpaRepository<Result, Long> {
}
