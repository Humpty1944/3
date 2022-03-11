package com.example.work;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/***
 * Работа с данными для промоакции
 */
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    @Query(
            value = "SELECT u.id, u.name, u.description FROM Promotion u ",
            nativeQuery = true)
    List<Promotion> findAllEmpty();
    @Query(
            value = "SELECT u.id, u.name, u.description FROM Promotion u ",
            nativeQuery = true)
    List<Promotion> findParticipant();
}
