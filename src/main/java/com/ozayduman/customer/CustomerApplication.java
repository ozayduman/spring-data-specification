package com.ozayduman.customer;

import com.ozayduman.customer.repository.DataInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.AuditingConfig;

@SpringBootApplication
@Import(value = {AuditingConfig.class})
@EnableWebSecurity
public class CustomerApplication implements ApplicationListener<ApplicationReadyEvent> {

    private final DataInitializer dataInitializer;

    public CustomerApplication(DataInitializer dataInitializer) {
        this.dataInitializer = dataInitializer;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        dataInitializer.saveSampleData();
    }

    @Configuration
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/customer").hasAnyRole("ADMIN").anyRequest().authenticated()
                    .and().httpBasic();
            http.headers().frameOptions().disable();
        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {

            //User Role
            UserDetails theUser = User.withUsername("duman")
                    .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                    .password("ddd").roles("USER").build();

            //Manager Role
            UserDetails theManager = User.withUsername("ozay")
                    .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                    .password("ooo").roles("ADMIN").build();
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            manager.createUser(theUser);
            manager.createUser(theManager);
            auth.userDetailsService(manager);
        }
    }
}
