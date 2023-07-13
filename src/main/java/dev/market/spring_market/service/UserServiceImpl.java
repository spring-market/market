package dev.market.spring_market.service;

import dev.market.spring_market.dto.LoginReq;
import dev.market.spring_market.dto.LoginRes;
import dev.market.spring_market.dto.UserRequest;
import dev.market.spring_market.dto.UserResponse;
import dev.market.spring_market.entity.User;
import dev.market.spring_market.repository.UserRepo;
import dev.market.spring_market.utils.JwtService;
import dev.market.spring_market.utils.SHA256;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    private final JwtService jwtService;
    @Override
    public UserResponse findById(Long userId) {
        System.out.println("서비스 실행");
        Optional<User> user = userRepo.findById(userId);
        if(!user.isPresent()){
            throw new IllegalArgumentException();
        }
        User getUser = user.get();
        UserResponse userResponse = UserResponse.builder().userEmail(getUser.getUserEmail()).nickname(getUser.getNickname()).gender(getUser.getGender()).build();
        return userResponse;

    }

    @Override

    public UserResponse deleteUser(Long userId) {
        User user = userRepo.getReferenceById(userId);

        User user1 = new User(user.getUserId(), user.getUserEmail(), user.getPassword(), user.getNickname(), user.getGender(), 0,user.getCreatedAt());
        System.out.println(user1.getStatus());
        User user2 =userRepo.save(user1);
        System.out.println(user2.getStatus());

        UserResponse userResponse = UserResponse.builder().userEmail(user1.getUserEmail()).nickname(user1.getNickname()).gender(user1.getGender()).build();
        return userResponse;

    }

    @Override
    public UserResponse registerUser(UserRequest userRequest) {

        String pwd;
        try{
            pwd=SHA256.encrypt(userRequest.getPassword());
        }
        catch (Exception e){
            e.printStackTrace();
            throw new IllegalStateException();
        }
        User user = new User(userRequest.getUserEmail(),pwd,userRequest.getNickname(), userRequest.getGender());
        User savedUser = userRepo.save(user);
        UserResponse userResponse = UserResponse.builder().userEmail(savedUser.getUserEmail()).nickname(savedUser.getNickname()).gender(savedUser.getGender()).build();
        return userResponse;
    }

    @Override

    public LoginRes login(Long userId, @RequestBody LoginReq loginReq) {
        User user = userRepo.getReferenceById(userId);
        String pwd = SHA256.encrypt(loginReq.getPassword());
        if(user.getUserEmail().equals(loginReq.getUserEmail()) && pwd.equals(user.getPassword())){
           String jwt = jwtService.createJwt(user.getUserId());

            LoginRes loginRes = LoginRes.builder().userEmail(user.getUserEmail()).userId(user.getUserId()).jwt(jwt).nickname(user.getNickname()).gender(user.getGender()).build();
            return loginRes;
        }
        else{
            throw new IllegalStateException();
        }
    public UserResponse updateUser(Long userId, UserRequest userRequest) {
        User user1 = userRepo.getReferenceById(userId);
       User user = new User(userId,userRequest.getUserEmail(),userRequest.getPassword(),userRequest.getNickname(), userRequest.getGender(),user1.getCreatedAt());
        User updateUser = userRepo.save(user);
        UserResponse userResponse = UserResponse.builder().userEmail(updateUser.getUserEmail()).nickname(updateUser.getNickname()).gender(updateUser.getGender()).build();

        return userResponse;

    }
}
