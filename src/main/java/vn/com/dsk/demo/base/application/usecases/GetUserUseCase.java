package vn.com.dsk.demo.base.application.usecases;

import org.springframework.stereotype.Service;
import vn.com.dsk.demo.base.adapter.dto.UserDto;
import vn.com.dsk.demo.base.application.services.UserService;
import vn.com.dsk.demo.base.shared.common.UseCaseNoParam;

@Service
public class GetUserUseCase implements UseCaseNoParam<UserDto> {

    private final UserService userService;

    public GetUserUseCase(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto execute() {
        return userService.getUserInfo();
    }
}