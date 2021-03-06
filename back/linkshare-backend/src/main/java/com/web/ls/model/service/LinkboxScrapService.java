package com.web.ls.model.service;

import com.web.ls.model.dto.linkbox.BoxScrapCreateRequest;
import com.web.ls.model.entity.BoxScrap;
import com.web.ls.model.repository.BoxScrapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkboxScrapService {

    @Autowired
    BoxScrapRepository boxScrapRepository;

    public void createBoxScrap(BoxScrapCreateRequest request) {
    	if(!boxScrapRepository.existsByBoxidAndUid(request.getBoxid(), request.getUid())) {
    		BoxScrap boxScrap = request.toEntity();
    		boxScrapRepository.save(boxScrap);
    	}
    }

    public void deleteBoxScrap(int uid, int boxid) {
    	BoxScrap boxScrap = boxScrapRepository.findByBoxidAndUid(boxid, uid);
    	if(boxScrap != null) {
    		boxScrapRepository.delete(boxScrap);
    	}
    }

    public List<BoxScrap> searchBoxScrapListByBoxid(Integer boxId) {
        return boxScrapRepository.findAllByBoxidOrderByRegtime(boxId);
    }

    public List<BoxScrap> searchBoxScrapListByUid(Integer uid) {
        return boxScrapRepository.findAllByUidOrderByRegtime(uid);
    }
    
    public boolean checkScrapUser(Integer boxid, Integer uid) {
    	return boxScrapRepository.existsByBoxidAndUid(boxid, uid);
    }
}
