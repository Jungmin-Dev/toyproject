package com.toyproject.board.controller;

import com.toyproject.board.SessionConst;
import com.toyproject.board.domain.Login.LoginForm;
import com.toyproject.board.domain.member.Member;
import com.toyproject.board.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(LoginForm loginForm){
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm, BindingResult bindingResult
            , @RequestParam(defaultValue = "/") String redirectURL, HttpServletRequest request) {

        if(bindingResult.hasErrors())
            return "login/loginForm";

        Member loginMember = loginService.Login(loginForm.getLoginId(), loginForm.getPassword());

        if(loginMember == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
        // 로그인 성공 처리
        // custom 세션 관리자를 통해 세션을 생성하고, 회원 데이터 보관
        // true (default) : 세션이 있으면 기존 세션을 반환, 세션이 없으면 새로운 세션을 생성해서 반환
        // false : 세션이 있으면 기존 세션을 반환, 세션이 없으면, 새로운 세션을 생성하지 않고 null을 반환
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        // 세션에 로그인 회원정보 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        return "redirect:" + redirectURL;

    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
