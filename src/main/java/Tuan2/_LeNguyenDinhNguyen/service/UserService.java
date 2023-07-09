package Tuan2._LeNguyenDinhNguyen.service;

import Tuan2._LeNguyenDinhNguyen.entity.User;
import Tuan2._LeNguyenDinhNguyen.repository.IUserRepository;
import Tuan2._LeNguyenDinhNguyen.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    public void save(User user)
    {
        userRepository.save(user);
        Long userId= userRepository.getUserIdByUserName(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("User");
        if(roleId !=0 && userId != 0){
            userRepository.addRoleToUser(userId,roleId);
        }

    }
}
