package com.cursos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {




    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select usuario_email,usuario_senha, usuario_ativado from usuarios where usuario_email = ?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT u.usuario_email, r.role FROM usuarios u JOIN roles r ON u.roles_id = r.id WHERE u.usuario_email = ?");


        return jdbcUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    //Filtros
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/cursos/list/**").permitAll()
                        .requestMatchers("/cursos/display/**").permitAll()
                        .requestMatchers("/pessoas/mostrarFormCadastrarPessoa").permitAll()
                        .requestMatchers("/pessoas/save").permitAll()
                        .requestMatchers("/vagas/list").permitAll()
                        .requestMatchers("/empresas/**").hasRole("ADMIN")
                        .requestMatchers("/cursos/mostrarFormCadastrarCurso").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        )

                        .formLogin(form ->
                                form
                                        .loginPage("/showMyLoginPage")
                                        .loginProcessingUrl("/authenticateTheUser")
                                        .permitAll()
                                        .defaultSuccessUrl("/home", true)
                        ).logout(logout -> logout.permitAll()


                        );

        return http.build();
    }

}
