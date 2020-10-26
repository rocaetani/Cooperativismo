package com.example.cooperativism.repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class VoteVerifierRepository {


    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public boolean VerifiyOtherVote(int idAssociate, int idVoting){
        String sql = "SELECT count(*) " +
                     "  FROM vote " +
                     "  JOIN voting_votes " +
                     "    ON vote.id = voting_votes.votes_id " +
                     " where vote.id_associate = ? " +
                     "   and voting_votes.voting_id = ?";
        int count = (Integer) entityManager.createNativeQuery(sql).setParameter(1,idAssociate).setParameter(2,idVoting).getSingleResult();
        if(count > 0){
            return true;
        }
        return false;
    }
}
