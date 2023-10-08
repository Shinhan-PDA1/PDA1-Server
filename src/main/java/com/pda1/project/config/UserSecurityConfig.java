package com.pda1.project.config;

import com.pda1.project.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] PUBLIC_URI = {
        "/v1/users/register",
        "/v1/users/login",
        "/v1/admins/register",
        "/v1/admins/login"
    };

    private static final String[] ADMIN_URI = {
//            "/v1/서비스명/admin/**" 이렇게 지어서 서비스명 하위 도메인은 ROLE_ADMIN만 접근하게 설정
    };

    private static final String[] USER_URI = {
//            "/v1/서비스명/user/**" 이렇게 지어서 서비스명 하위 도메인은 ROLE_USER만 접근하게 설정

    };

    @Autowired
    private JwtFilter adminJwtFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* 맨 아래 configure를 하기 전에 먼저 실행되는 함수 */
    /* PUBLIC_URI에 모든 접근을 허용하기 위해 검증을 ignoring */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers(PUBLIC_URI);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // 세션 사용 X
                .authorizeRequests() // 요청에 대한 사용 권한 체크
//                .antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll() // options 메소드로 호출하는 모든 접근 허용, JWT 토큰 검사가 불가능
                .antMatchers("/v1/admins/**").hasRole("ADMIN")
                .antMatchers("/v1/users/**").hasAnyRole("USER")
                .antMatchers(ADMIN_URI).hasAnyRole("ADMIN")
                .antMatchers(USER_URI).hasRole("USER")
                .antMatchers(HttpMethod.POST).authenticated().and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);

        http.addFilterBefore(adminJwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
