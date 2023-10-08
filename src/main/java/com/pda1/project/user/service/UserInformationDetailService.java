package com.pda1.project.user.service;

import com.pda1.project.domain.UserInformation.UserInformation;
import com.pda1.project.domain.UserInformation.UserInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserInformationDetailService implements UserDetailsService {

    private final UserInformationRepository userInformationRepository;

    public UserInformation getUserInformation(String account) {
        return userInformationRepository.findByAccount(account).get();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInformation> user = userInformationRepository.findByAccount(username);
        /* 디버깅 모드를 통해 여기까지 user의 Authorities()가 있음을 확인함 */

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found with account: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.get().getAccount(), user.get().getPassword(), user.get().getAuthorities());
    }
}
