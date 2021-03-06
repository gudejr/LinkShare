package com.web.ls.model.repository;

import com.web.ls.model.entity.BoxInterest;
import com.web.ls.model.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoxInterestRepository extends JpaRepository<BoxInterest, Integer> {

    @Transactional
    void deleteByBoxid(int boxid);

    @Transactional
    void deleteByBoxidAndInterestId(Integer boxid, Integer interestId);

    @Query(value = "select a.`name` from interest a where a.interest_id = any (select b.interest_id from box_interest b where b.boxid = :boxid)", nativeQuery = true)
    List<String> findInterestNameByBoxid(@Param("boxid") Integer boxid);

    List<BoxInterest> findAllByInterestId(Integer interestId);
    
    boolean existsByBoxidAndInterestId(Integer boxid, Integer interestId);
    
    BoxInterest findByBoxidAndInterestId(Integer boxid, Integer interestId);
}