package Tuan2._LeNguyenDinhNguyen.repository;

import Tuan2._LeNguyenDinhNguyen.entity.Role;
import Tuan2._LeNguyenDinhNguyen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r where r.name= ?1")
    Long getRoleIdByName(String name);


}
