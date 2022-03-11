package com.example.work;
import org.springframework.data.jpa.repository.JpaRepository;
/***
 * Работа с данными для участниками
 */
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
