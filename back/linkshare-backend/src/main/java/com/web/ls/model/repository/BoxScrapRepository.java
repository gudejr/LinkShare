package com.web.ls.model.repository;

import com.web.ls.model.entity.BoxScrap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoxScrapRepository extends JpaRepository<BoxScrap, Integer> {

    void deleteByBoxid(int boxid);
    int countByBoxid(Integer boxid);
    List<BoxScrap> findAllByBoxidOrderByRegtime(Integer boxid);
    List<BoxScrap> findAllByUidOrderByRegtime(Integer uid);
}