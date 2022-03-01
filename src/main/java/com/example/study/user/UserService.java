package com.example.study.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 전체 목록 조회
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    // 상세 조회
    public User getUser(Long id){
        return userRepository.findById(id).orElseGet(User::new);
    }

    // 유저 등록
    @Transactional
    public User save(User user) {
        // id == null
        return userRepository.save(user);
    }

    // 유저 수정
    @Transactional
    public User modify(User user) {
        // id == 있음
        return userRepository.save(user);
    }

    // 유저 삭제
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
