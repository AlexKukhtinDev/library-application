package mate.academy.spring.config;
import mate.academy.spring.security.CustomUserDetailService;
import mate.academy.spring.security.PrintInfoSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomUserDetailService customUserDetailService;
    @Bean
    public CustomUserDetailService userDetailsService() {
        return new CustomUserDetailService();
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("ADMIN");

        auth.authenticationProvider(authProvider());
        auth.userDetailsService(customUserDetailService);
    }

    @Autowired
    public AuthenticationSuccessHandler getCustomSuccessHandler() {
        return new PrintInfoSuccessHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.authenticationProvider(authProvider());
        auth.userDetailsService(customUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/registration").permitAll()
                .antMatchers("/book/add").hasRole("ADMIN")
                .antMatchers("/book/delete/{bookId}").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .logout();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
