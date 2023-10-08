package com.pda1.project.admin.service;

import com.pda1.project.domain.Admin.Admin;
import com.pda1.project.domain.Admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminDetailService implements UserDetailsService {

    private final AdminRepository adminRepository;

    public Admin getUserInformation(String account) {
        return adminRepository.findByAccount(account).get();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> admin = adminRepository.findByAccount(username);
        /* 디버깅 모드를 통해 여기까지 user의 Authorities()가 있음을 확인함 */

        if (!admin.isPresent()) {
            throw new UsernameNotFoundException("User not found with account: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                admin.get().getAccount(), admin.get().getPassword(), admin.get().getAuthorities());
    }
}
