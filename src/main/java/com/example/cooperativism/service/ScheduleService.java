package com.example.cooperativism.service;

import com.example.cooperativism.domain.Schedule;
import com.example.cooperativism.domain.Vote;
import com.example.cooperativism.domain.Voting;
import com.example.cooperativism.exception.*;
import com.example.cooperativism.repository.ScheduleRepository;
import com.example.cooperativism.repository.VoteRepository;
import com.example.cooperativism.repository.VoteVerifierRepository;
import com.example.cooperativism.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private VotingRepository votingRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private VoteVerifierRepository voteVerifierRepository;

    @Autowired
    private AssociateService associateService;


    public Schedule createSchedule(String topic){
        Schedule schedule = new Schedule(topic);
        scheduleRepository.saveAndFlush(schedule);
        return schedule;
    }

    public Schedule startVoting(int id, long minutes){
        if(minutes == 0){
            minutes = 1;
        }
        LocalTime time = LocalTime.now();
        time = time.plusMinutes(minutes);

        Voting voting = new Voting(time);

        Schedule schedule = findSchedule(id);
        votingAlreadyOpen(schedule.getVoting());

        schedule.setVoting(voting);
        votingRepository.saveAndFlush(voting);
        scheduleRepository.saveAndFlush(schedule);
        return schedule;
    }

    public void vote(int idSchedule, int idAssociate, boolean choice){
        Schedule schedule = findSchedule(idSchedule);

        Voting voting = schedule.getVoting();
        votingIsValid(voting);
        votingAlreadyClosed(voting);

        VerifyVote(voting, idAssociate);

        Vote vote = new Vote(choice,idAssociate);
        voting.getVotes().add(vote);
        if(vote.isChoice()){
            voting.setCounterYes(voting.getCounterYes() + 1);
        }
        else{
            voting.setCounterNo(voting.getCounterNo() + 1);
        }

        votingRepository.saveAndFlush(voting);
    }

    public Schedule findSchedule(int id){
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if(optionalSchedule.isEmpty()){

            throw new NotFoundException("Pauta não encontrada.");
        }
        Schedule schedule = optionalSchedule.get();
        return schedule;
    }

    public String getScheduleResult(int idSchedule){
        Schedule schedule = findSchedule(idSchedule);
        Voting voting = schedule.getVoting();
        votingIsValid(voting);
        votingNotFinished(voting);
        if(voting.getCounterYes() > voting.getCounterNo()){
            return "Sim";
        }else if(voting.getCounterYes() < voting.getCounterNo()){
            return "Não";
        }
        return "Empate";
    }

    public void votingIsValid(Voting voting){
        if(voting == null){
            throw new VotingNotOpenException("Votação ainda não está aberta para a pauta.");
        }
    }

    public void votingAlreadyClosed(Voting voting){
        if(LocalTime.now().isAfter(voting.getTimeMinutes())){
            throw new VotingExpiredException("Votação já encerrada.");
        }
    }

    public void votingNotFinished(Voting voting){
        if(LocalTime.now().isBefore(voting.getTimeMinutes())){
            throw new VotingNotFinishedException("Votação ainda não foi encerrada.");
        }
    }

    public void votingAlreadyOpen(Voting voting){
        if(voting != null){
            throw new VotingAlreadyOpenException("Votação já foi aberta.");
        }
    }

    public void VerifyVote(Voting voting, int idAssociate){
        votingIsValid(voting);
        if(voteVerifierRepository.VerifiyOtherVote(idAssociate,voting.getId())) {
            throw new AssociateAlreadyVoteException("Este associado já votou nesta pauta.");
        }
    }

    public void voteWithCPF(int idSchedule, int idAssociate, boolean choice, String cpf){
        if(!associateService.verifyCPF(cpf)){
            throw new CpfUnableException("Cpf não é valido.");
        }
        vote(idSchedule,idAssociate,choice);
    }






}
