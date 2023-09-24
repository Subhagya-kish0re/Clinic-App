//package com.example.ClinicApp.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//    //    AUTHORIZATION
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/","/doctor/findalldoctors","/product/{name}").permitAll()
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("user/{name}","/user/all ","/user/**").authenticated()
//                .and().formLogin()
//                .and().build();
//    }
//
////    @Bean
////    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
////        UserDetails ADMIN= User.withUsername("Subhagya")
////                .password(passwordEncoder.encode("1234"))
////                .roles("ADMIN")
////                .build();
////        UserDetails USER=User.withUsername("user1")
////                .password(passwordEncoder.encode("user@1234"))
////                .roles("ADMIN")
////                .build();
////        return new InMemoryUserDetailsManager(ADMIN,USER);
////    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new UserInfoUserDetailsService();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        return daoAuthenticationProvider;
//    }
//}
