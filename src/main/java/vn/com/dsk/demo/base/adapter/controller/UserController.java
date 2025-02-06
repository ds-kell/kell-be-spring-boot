package vn.com.dsk.demo.base.adapter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.dsk.demo.base.application.services.UserService;
import vn.com.dsk.demo.base.application.usecases.GetUserUseCase;
import vn.com.dsk.demo.base.shared.wrappers.ResponseUtils;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class UserController {

    private final UserService userService;

    private final GetUserUseCase getUserUseCase;

    @GetMapping("private/user/info")
    public ResponseEntity<?> getUserInfo(){
        return ResponseUtils.ok(getUserUseCase.execute());
    }

    @GetMapping("private/user/test")
    public String getTest(){
        return "BTT-19-11-2001";
    }
}