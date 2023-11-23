package com.houselink.service;

import com.houselink.dto.UserDto;

public interface UserService {
    UserDto login(UserDto userDto) throws Exception;
    UserDto userInfo(String userId) throws Exception;
    void saveRefreshToken(String userId, String refreshToken) throws Exception;
    String getRefreshToken(String userId) throws Exception;
    void deleRefreshToken(String userId) throws Exception;
    Long signup(UserDto userDto) throws Exception;
    Long deleteUser(UserDto userDto);
}
