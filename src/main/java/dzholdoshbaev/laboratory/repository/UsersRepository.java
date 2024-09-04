package dzholdoshbaev.laboratory.repository;


import dzholdoshbaev.laboratory.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);


    @Transactional
    @Modifying
    @Query("""
    UPDATE Users u
    SET u.avatar = :avatar
    WHERE u.email = :email
    """)
    void updateUserPhoto(@Param("email") String email, @Param("avatar") String avatar);


    Optional<Users> findByResetPasswordToken(String resetPasswordToken);

    @Transactional
    @Modifying
    @Query("""
    UPDATE Users u
    SET u.password = :password,
        u.name = :name,
        u.email = :newEmail,
        u.surname = :surname,
        u.phoneNumber = :phoneNumber,
        u.age = :age
    WHERE u.email = :email
    """)
    void updateUsersByEmail(@Param("email") String email,
                            @Param("newEmail") String newEmail,
                            @Param("name") String name,
                            @Param("surname") String surname,
                            @Param("age") Long age,
                            @Param("password") String password,
                            @Param("phoneNumber") String phoneNumber);


    Boolean existsByEmail(String email);
}
