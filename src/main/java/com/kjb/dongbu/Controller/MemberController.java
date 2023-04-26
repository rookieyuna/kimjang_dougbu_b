package com.kjb.dongbu.Controller;

import com.kjb.dongbu.Model.Member;
import com.kjb.dongbu.Model.Product;
import com.kjb.dongbu.Model.Sdo.MemberCdo;
import com.kjb.dongbu.Model.Sdo.MemberUdo;
import com.kjb.dongbu.Service.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @GetMapping("/all")
    public List<Member> findAllMembers() {
        return memberService.findMembers();
    }

    @GetMapping("") //1. RequestParam으로 데이터 받는 방법 (인썸니아 테스트시 Multipart에서 데이터전송)
    public List<Member> findMembersByName(@RequestParam String name) {
        return memberService.findMembersByName(name);
    }

    @PutMapping("")
    public void modifyMember(@RequestBody MemberUdo memberUdo) {
        memberService.modifyMember(memberUdo);
    }

    @DeleteMapping("") //2. PathParam(주소쿼리문)으로 데이터 받는 방법
    public void removeMember(@PathParam("memCode") long memCode) {
        memberService.removeMember(memCode);
    }
}