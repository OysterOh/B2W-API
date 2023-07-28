package com.finalProject.stockbeginner.user.repository;

import com.finalProject.stockbeginner.user.dto.response.MbtiUserResponseDTO;
import com.finalProject.stockbeginner.user.entity.FavoriteStock;
import com.finalProject.stockbeginner.user.entity.User;
import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    // 이메일로 회원정보 조회
    Optional<User> findByEmail(String email);

    // 이메일 중복 체크
    boolean existsByEmail(String email);


    // 닉네임 중복 체크
    boolean existsByNick(String nick);

    List<User> findAllByOrderByMoneyDesc();


    boolean existsByKakaoId(long kakaoId);

    User findByPhoneNumber(String phoneNumber);

    void delete(User user);

    // mbti 유저 수
    @Query("SELECT new com.finalProject.stockbeginner.user.dto.response.MbtiUserResponseDTO(COUNT(*), u.mbti) FROM User u GROUP BY u.mbti")
    List<MbtiUserResponseDTO> getMbtiUser();

}

