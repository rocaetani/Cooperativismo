package com.example.cooperativism.repository;

import com.example.cooperativism.domain.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingRepository extends JpaRepository<Voting,Integer> { }
