package com.go.together.Mapper;

import com.go.together.Dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper {
    //유저 회원가입
    public int insert(UserDto userDto);

    // 아이디로 회원 가져오기.
    public UserDto selectById(UserDto userDto);

    //아이디찾기
    public String findUserId(UserDto userDto);

    //비밀번호 찾기
    public int findUserPassword(UserDto userDto);

    //비밀번호 바꾸기
    public int updatePw(UserDto userDto);

    //유저 아이디 중복확인
    public int checkUserId(UserDto userDto);

    public int update(UserDto userDto);

    //유저 정보 리스트로 모두 가져오기 . 마이페이지쪽 정보
    public UserDto userListAll(UserDto userDto);

//   CODE 저장
    public void saveVerificationCode(UserDto userDto);


}
