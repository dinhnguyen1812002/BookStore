package Tuan2._LeNguyenDinhNguyen.service;

import Tuan2._LeNguyenDinhNguyen.entity.CustomUserDetail;
import Tuan2._LeNguyenDinhNguyen.entity.User;
import Tuan2._LeNguyenDinhNguyen.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null)
            throw  new UsernameNotFoundException("Không thấy user");
        return new CustomUserDetail(user, userRepository);
    }
}
