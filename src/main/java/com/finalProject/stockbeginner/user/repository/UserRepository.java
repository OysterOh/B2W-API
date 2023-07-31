package com.finalProject.stockbeginner.user.repository;

<<<<<<< HEAD
import com.finalProject.stockbeginner.user.dto.response.CntByAgesDTO;
import com.finalProject.stockbeginner.user.dto.response.CntProfitByAgesDTO;
import com.finalProject.stockbeginner.user.dto.response.MbtiUserResponseDTO;
=======
import com.finalProject.stockbeginner.user.dto.response.*;
import com.finalProject.stockbeginner.user.entity.FavoriteStock;
>>>>>>> feat/jh
import com.finalProject.stockbeginner.user.entity.User;
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

<<<<<<< HEAD
//    @Query("SELECT " +
//            "new com.finalProject.stockbeginner.user.dto.response.AgesCountDTO(t.career, count) " +
//            "FROM " +
//            "(SELECT new com.finalProject.stockbeginner.user.dto.response.AgesCountDTO(u.career, r.profit) FROM User u LEFT JOIN Ranking r ON u.email = r.email) t ")
//    List<AgesCountDTO> countByAges();

//    @Query("SELECT new com.finalProject.stockbeginner.user.dto.response.AgesCountDTO(u.career, r.profit as count) FROM User u LEFT JOIN Ranking r ON u.email=r.email")
//    List<AgesCountDTO> joinRanking();

//    @Query(nativeQuery = true, value = "SELECT u.user_email as ages, count(*) as count FROM stock_user u LEFT JOIN ranking r ON u.user_email = r.email GROUP BY u.user_email")
//    List<CntByAgesDTO> getCntByAges();

    @Query(nativeQuery = true, value = "SELECT CASE " +
            "WHEN u.age BETWEEN 1 AND 19 THEN '미성년자' " +
            "WHEN u.age BETWEEN 20 AND 29 THEN '20대' " +
            "WHEN u.age BETWEEN 30 AND 39 THEN '30대' " +
            "WHEN u.age BETWEEN 40 AND 49 THEN '40대' " +
            "WHEN u.age BETWEEN 50 AND 59 THEN '50대' " +
            "WHEN u.age BETWEEN 60 AND 69 THEN '60대' " +
            "ELSE '나머지' END AS ages, count(*) AS count " +
            "FROM stock_user u GROUP BY ages")
    List<CntByAgesDTO> getCntByAges();

    @Query(nativeQuery = true, value = "SELECT CASE " +
            "WHEN u.age BETWEEN 1 AND 19 THEN '미성년자' " +
            "WHEN u.age BETWEEN 20 AND 29 THEN '20대' " +
            "WHEN u.age BETWEEN 30 AND 39 THEN '30대' " +
            "WHEN u.age BETWEEN 40 AND 49 THEN '40대' " +
            "WHEN u.age BETWEEN 50 AND 59 THEN '50대' " +
            "WHEN u.age BETWEEN 60 AND 69 THEN '60대' " +
            "ELSE '나머지' END AS ages, count(*) AS count, ROUND(AVG(r.profit)) AS profit " +
            "FROM ranking r LEFT JOIN stock_user u  ON u.user_email=r.email " +
            "GROUP BY ages")
    List<CntProfitByAgesDTO> getCntProfitByAges();
=======
    //연령 별 유저 수 (실패)
//    @Query("SELECT new com.finalProject.stockbeginner.user.dto.response.AgeUserResponseDTO(CASE " +
//            "WHEN age BETWEEN 1 AND 19 THEN '미성년자' " +
//            "WHEN age BETWEEN 20 AND 29 THEN '20대' " +
//            "WHEN age BETWEEN 30 AND 39 THEN '30대' " +
//            "WHEN age BETWEEN 40 AND 49 THEN '40대' " +
//            "WHEN age BETWEEN 50 AND 59 THEN '50대' " +
//            "WHEN age BETWEEN 60 AND 69 THEN '60대' " +
//            "ELSE '70세 이상' END AS ageGroup, " +
//            "COUNT(*) AS countUsers) " +
//            "FROM User " +
//            "GROUP BY ageGroup")
//    List<AgeUserResponseDTO> getAgeUser();

    // 경력별 유저 수
    @Query("SELECT new com.finalProject.stockbeginner.user.dto.response.CareerUserResponseDTO(COUNT(*), u.career) FROM User u GROUP BY u.career")
    List<CareerUserResponseDTO> getCareerUser();

    //mbti별 평균 손익
    @Query("SELECT new com.finalProject.stockbeginner.user.dto.response.MbtiAvgResponseDTO(u.mbti, ROUND(AVG(r.profit))) " +
            "FROM User u " +
            "RIGHT JOIN Ranking r " +
            "ON u.email = r.email " +
            "GROUP BY u.mbti")
    List<MbtiAvgResponseDTO> getMbtiProfit();

    //경력별 평균 손익
    @Query("SELECT new com.finalProject.stockbeginner.user.dto.response.CareerAvgResponseDTO(u.career, ROUND(AVG(r.profit))) " +
            "FROM User u " +
            "RIGHT JOIN Ranking r " +
            "ON u.email = r.email " +
            "GROUP BY u.career")
    List<CareerAvgResponseDTO> getCareerProfit();

>>>>>>> feat/jh

}

