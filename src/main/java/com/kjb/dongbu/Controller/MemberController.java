package com.kjb.dongbu.Controller;

import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Model.Sdo.MemberCdo;
import com.kjb.dongbu.Model.Sdo.MemberUdo;
import com.kjb.dongbu.Service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("")
    public long registerMember(@RequestBody MemberCdo memberCdo) {
        return memberService.registerMember(memberCdo);
    }

    @GetMapping("")
    public List<Member> findMembersByName(@RequestParam String name) {
        return memberService.findMembersByName(name);
    }

    @PutMapping("")
    public void modifyMember(@RequestBody MemberUdo memberUdo) {
        memberService.modifyMember(memberUdo);
    }
}
