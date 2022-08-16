package com.devcamp.tripssoda.controller;

import com.devcamp.tripssoda.dto.PartnerDto;
import com.devcamp.tripssoda.service.PartnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/partner")
public class PartnerController {
    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping("/reg")
    public String regPartner(HttpSession session) {
        session.setAttribute("userId","1");
        return "partner/reg_partner.mainTiles";
    }

    @PostMapping("/reg")
    public String regPartner(PartnerDto dto) {
        System.out.println("dto = " + dto);
        partnerService.regPartner(dto);

        //성공화면 or 마이페이지 등록리스트 나중에 만들어서 리턴값 변경하기
        return "redirect:/partner/reg";
    }
}