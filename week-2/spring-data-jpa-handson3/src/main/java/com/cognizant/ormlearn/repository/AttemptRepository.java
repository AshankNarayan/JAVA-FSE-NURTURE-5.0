package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.entity.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    // Hands-on 3: Fetch quiz attempt details using HQL with extensive left join fetch
    @Query("SELECT DISTINCT a FROM Attempt a " +
           "LEFT JOIN FETCH a.user u " +
           "LEFT JOIN FETCH a.attemptQuestions aq " +
           "LEFT JOIN FETCH aq.question q " +
           "LEFT JOIN FETCH q.options o " +
           "LEFT JOIN FETCH aq.attemptOptions ao " +
           "LEFT JOIN FETCH ao.quizOption qo " +
           "WHERE u.id = :userId AND a.id = :attemptId")
    Optional<Attempt> getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
