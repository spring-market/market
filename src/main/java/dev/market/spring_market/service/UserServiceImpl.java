package dev.market.spring_market.service;

import dev.market.spring_market.dto.UserRequest;
import dev.market.spring_market.dto.UserResponse;
import dev.market.spring_market.entity.User;
import dev.market.spring_market.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
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
        User user = new User(userRequest.getUserEmail(),userRequest.getPassword(),userRequest.getNickname(), userRequest.getGender());
        User savedUser = userRepo.save(user);
        UserResponse userResponse = UserResponse.builder().userEmail(savedUser.getUserEmail()).nickname(savedUser.getNickname()).gender(savedUser.getGender()).build();
        return userResponse;
    }
}
