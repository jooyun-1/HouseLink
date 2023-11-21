package com.houselink.service;

import com.houselink.dto.HouseDto;
import com.houselink.dto.UserDto;
import com.houselink.exception.AlreadyExistAptCode;
import com.houselink.exception.AlreadyExistAptNo;
import com.houselink.exception.NotAdminException;
import com.houselink.mapper.HouseMapper;
import com.houselink.mapper.UserMapper;
import com.houselink.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService{
    private final JWTUtil jwtUtil;
    private final HouseMapper houseMapper;
    private final UserMapper userMapper;
    @Override
    public Long getAptCode(String houseName) {
        return houseMapper.findAptCodeByHouseName(houseName);
    }

    @Override
    public Long createHouse(String token, HouseDto houseDto) throws Exception {
        String userId = jwtUtil.getUserId(token);
        //해당 아파트 코드에 대한 아파트가 있으면 예외 던짐
        Long aptCount = houseMapper.findAptByAptCode(houseDto.getAptCode());
        if(aptCount>0){
            throw new AlreadyExistAptCode();
        }
        //해당 아파트 번호 있으면 예외 던짐
        Long aptNo = houseMapper.findAptByAptNo(houseDto.getNo());
        if(aptNo>0){
            throw new AlreadyExistAptNo();
        }
        Boolean isAdmin = userMapper.userInfo(userId).getIsAdmin();
        if(isAdmin){
            return houseMapper.createHouse(houseDto);
        }else{
            throw new NotAdminException();
        }
    }

    @Override
    public Long updateHouse(String token, HouseDto houseDto) throws Exception{
        String userId = jwtUtil.getUserId(token);
        Boolean isAdmin = userMapper.userInfo(userId).getIsAdmin();

//        //해당 아파트 코드에 대한 아파트가 있으면 예외 던짐
//        Long aptCount = houseMapper.findAptByAptCode(houseDto.getAptCode());
//        if(aptCount>0){
//            throw new AlreadyExistAptCode();
//        }
//        //해당 아파트 번호 있으면 예외 던짐
//        Long aptNo = houseMapper.findAptByAptNo(houseDto.getNo());
//        if(aptNo>0){
//            throw new AlreadyExistAptNo();
//        }

        if(isAdmin){
            return houseMapper.updateHouse(houseDto);
        }else{
            throw new NotAdminException();
        }
    }

    @Override
    public Long deleteHouse(String token, HouseDto houseDto) throws Exception{
        String userId = jwtUtil.getUserId(token);
        Boolean isAdmin = userMapper.userInfo(userId).getIsAdmin();
        if(isAdmin){
            return houseMapper.deleteHouse(houseDto);
        }else{
            throw new NotAdminException();
        }
    }
}
