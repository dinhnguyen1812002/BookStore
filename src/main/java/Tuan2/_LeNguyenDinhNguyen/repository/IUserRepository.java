package Tuan2._LeNguyenDinhNguyen.repository;

import Tuan2._LeNguyenDinhNguyen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUserName(String username);
    @Modifying
    @Transactional
    @Query(value = "Insert into user_role (user_id,role_id)"+ "values(?1,?2)", nativeQuery = true)
    void addRoleToUser(Long userid, Long roleid);
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Long getUserIdByUserName(String username);
    @Query(value = "Select r.name FROM role r Inner Join user_roles ur "+ "ON r.id = ur.role_id where ur.user_id = ?1", nativeQuery = true)
    String[] getRoleOfUser (Long userId);
}
