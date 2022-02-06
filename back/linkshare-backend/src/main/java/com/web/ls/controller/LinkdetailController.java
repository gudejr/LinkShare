package com.web.ls.controller;

import com.web.ls.model.dto.BasicResponse;
import com.web.ls.model.dto.linkbox.LinkboxCreateRequest;
import com.web.ls.model.dto.linkdetail.LinkDetailUpdateRequest;
import com.web.ls.model.dto.linkdetail.LinkdetailRequest;
import com.web.ls.model.service.LinkdetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/linkdetail")
@Api("링크 정보 컨트롤러")
public class LinkdetailController {

    @Autowired
    LinkdetailService linkdetailService;

    @PostMapping
    @ApiOperation(value = "링크 생성하기")
    public Object createLink(@RequestBody @Valid LinkdetailRequest request) {
        final BasicResponse result = new BasicResponse();
        linkdetailService.createLink(request);
        result.msg = "success";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation(value = "링크 삭제하기")
    public Object deleteLink(@PathVariable("linkid") @ApiParam(value = "삭제할 링크의 아이디",
            required = true) Integer linkid) {
        final BasicResponse result = new BasicResponse();
        linkdetailService.deleteLink(linkid);
        result.msg = "success";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "링크 정보 전체 조회하기")
    public Object searchAllLinks(@PathVariable("boxid") @ApiParam(value = "링크 정보 조회할 박스 아이디",
        required = true) Integer boxid) {
        final BasicResponse result = new BasicResponse();
        result.object = linkdetailService.searchLinkList(boxid);
        result.msg = "success";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "링크 정보 수정하기")
    public Object updateLink(@RequestBody @Valid LinkDetailUpdateRequest request) {
        final BasicResponse result = new BasicResponse();
        linkdetailService.updateLink(request);
        result.msg = "success";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
