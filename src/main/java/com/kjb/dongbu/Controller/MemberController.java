package com.kjb.dongbu.Controller;

import com.kjb.dongbu.Model.Cdo.MemberCdo;
import com.kjb.dongbu.Service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/")
    public long registerMember(@RequestBody MemberCdo memberCdo) {
        return memberService.registerMember(memberCdo);
    }
}
