package com.houselink.controller;

import com.houselink.dto.UserDto;
import com.houselink.service.UserService;
import com.houselink.util.JWTUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final JWTUtil jwtUtil;

    @Value("${houselink.admin}")
    private String Admin;


    @ApiOperation(value = "회원가입", notes = "회원가입")
    @PostMapping("/signup")
    public ResponseEntity<Long> signUp(@Valid @RequestBody UserDto userDto) throws Exception {
        return new ResponseEntity<>(userService.signup(userDto), HttpStatus.OK);
    }

    @ApiOperation(value = "로그인", notes = "아이디와 비밀번호를 이용하여 로그인 처리.")
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(
            @Valid @RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) UserDto userDto) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        HttpStatus status = HttpStatus.ACCEPTED;
        String accessToken = "";
        String refreshToken = "";
        String role  = "user";
        try {
            UserDto loginUser = userService.login(userDto);
            if (loginUser != null) {
                accessToken = jwtUtil.createAccessToken(loginUser.getUserId());
                refreshToken = jwtUtil.createRefreshToken(loginUser.getUserId());
                Boolean isAdmin = userService.userInfo(userDto.getUserId()).getIsAdmin();
                if(isAdmin){
                    role = "admin";
                }
                log.debug("access token : {}", accessToken);
                log.debug("refresh token : {}", refreshToken);

//				발급받은 refresh token을 DB에 저장.
                userService.saveRefreshToken(loginUser.getUserId(), refreshToken);

//				JSON으로 token 전달.
                resultMap.put("access-token", accessToken);
                resultMap.put("refresh-token", refreshToken);


            } else {
                resultMap.put("message", "아이디 또는 패스워드를 확인해주세요.");
                status = HttpStatus.UNAUTHORIZED;
                return new ResponseEntity<Map<String, Object>>(resultMap, status);
            }


        } catch (Exception e) {
            log.debug("로그인 에러 발생 : {}", e);
            resultMap.put("message", e.getMessage());
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .header("RefreshToken", "Bearer " + refreshToken)
                .header("role",role)
                .build();

    }

    @ApiOperation(value = "회원 조회", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getInfo(@RequestHeader("Authorization") String token,HttpServletRequest request) {
//		logger.debug("userId : {} ", userId);
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        if (jwtUtil.checkToken(request.getHeader("Authorization"))) {
            log.info("사용 가능한 토큰!!!");
            try {
//				로그인 사용자 정보.
                String userId = jwtUtil.getUserId(token);
                UserDto userDto = userService.userInfo(userId);
                resultMap.put("userInfo", userDto);
                status = HttpStatus.OK;
            } catch (Exception e) {
                log.error("정보조회 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            log.error("사용 불가능 토큰!!!");
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @ApiOperation(value = "로그아웃", notes = "회원 정보를 담은 Token을 제거한다.", response = Map.class)
    @PostMapping("/logout")
    public ResponseEntity<?> removeToken(@RequestHeader("Authorization") String token) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            String userId = jwtUtil.getUserId(token);
            userService.deleRefreshToken(userId);
            status = HttpStatus.OK;
        } catch (Exception e) {
            log.error("로그아웃 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);

    }

    @ApiOperation(value = "Access Token 재발급", notes = "만료된 access token을 재발급받는다.", response = Map.class)
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody UserDto userDto, HttpServletRequest request)
            throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        String token = request.getHeader("refreshToken");

        log.debug("token : {}, userDto : {}", token, userService);
        if (jwtUtil.checkToken(token)) {
            if (token.equals(userService.getRefreshToken(userDto.getUserId()))) {
                String accessToken = jwtUtil.createAccessToken(userDto.getUserId());
                log.debug("token : {}", accessToken);
                log.debug("정상적으로 액세스토큰 재발급!!!");
                resultMap.put("access-token", accessToken);
                status = HttpStatus.CREATED;
            }
        } else {
            log.debug("리프레쉬토큰도 사용불가!!!!!!!");
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }


}
