package dev.market.spring_market.service;

import dev.market.spring_market.dto.UserResponse;
import dev.market.spring_market.entity.User;
import dev.market.spring_market.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
}
