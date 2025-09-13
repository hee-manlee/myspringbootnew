package lx.edu.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lx.edu.springboot.security.MyUserDetails;
import lx.edu.springboot.vo.UserVO;

@Service
public class CustomUserDetailService implements UserDetailsService {
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.equals("USER") || username.equals("ADMIN")) {
			// 여기서 user.getPassword() 는 DB 평문 그대로 반환됨
			UserVO vo = new UserVO();
			vo.setPassword(username);
			
			// roles 조회 & 설
			List<String> roles = new ArrayList<String>();
			roles.add("ROLE_" + username);
			vo.setRoles(roles);
			
			return new MyUserDetails(vo);
		}
		throw new UsernameNotFoundException("User not found: " + username);
	}
}