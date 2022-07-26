package kg.itacademy.onlinequeue.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT t.login, t.password, t.is_active FROM user_company t WHERE t.login = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.login, r.name_role " +
                                "FROM users_roles ur " +
                                "INNER JOIN user_company u " +
                                "   on ur.user_id = u.id " +
                                "INNER JOIN company_roles r " +
                                "   on ur.role_id = r.id " +
                                "WHERE u.login = ? AND u.is_active = true"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()

                .antMatchers(HttpMethod.GET, "/api/company/getAll").permitAll()
                .antMatchers(HttpMethod.POST, "/api/company/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/company/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/company/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/company/getByCompanyName").permitAll()

                .antMatchers(HttpMethod.GET, "/api/branch/getAllBranch").permitAll()
                .antMatchers(HttpMethod.POST, "/api/branch/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/branch/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/branch/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/branch/getByBranchName").permitAll()

                .antMatchers(HttpMethod.GET, "/api/usluga/getAllUsluga").permitAll()
                .antMatchers(HttpMethod.POST, "/api/usluga/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/usluga/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/usluga/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/usluga/getByUslugaName").permitAll()

                .antMatchers(HttpMethod.POST, "/api/ticket/create").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/api/ticket/update").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/api/ticket/delete").hasRole("USER")

                .antMatchers("/api/user/sign-in").permitAll()
                .antMatchers("/api/user/sign-up").permitAll()
                .antMatchers("/api/role/create").permitAll()

                .and()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}



