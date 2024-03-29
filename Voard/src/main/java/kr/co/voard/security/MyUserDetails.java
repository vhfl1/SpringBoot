package kr.co.voard.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kr.co.voard.repository.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Builder
public class MyUserDetails implements UserDetails{

	private static final long serialVersionUID = 1L;

	private UserEntity user;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 계정이 갖는 권한목록 리턴
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getGrade()));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// 계정이 갖는 비밀번호
		return user.getPass();
	}

	@Override
	public String getUsername() {
		// 계정이 갖는 아이디
		return user.getUid();
	}

	@Override
	public boolean isAccountNonExpired() {
		// 계정 만료 여부(true: 만료안됨, false:만료) 
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠금 여부(true: 잠금안됨, false:잠금)
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 계정 비밀번호 만료 여부(true: 만료안됨, false:만료) 
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 계정 활성화 여부(true: 활성화, false:비활성화)
		return true;
	}

}
