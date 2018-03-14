package pl.myprojects.project2.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

/* The EnableGlobalAuthentication annotation signals that the annotated class can be used to 
 * configure a global instance of AuthenticationManagerBuilder. 
 * 
 * The following annotations are annotated with EnableGlobalAuthentication

    EnableWebSecurity
    EnableWebMvcSecurity
    EnableGlobalMethodSecurity

Configuring AuthenticationManagerBuilder in a class without the EnableGlobalAuthentication annotation 
has unpredictable results.
https://docs.spring.io/autorepo/docs/spring-security/4.1.1.RELEASE/apidocs/org/springframework/security/config/annotation/authentication/configuration/EnableGlobalAuthentication.html
*/

@Configuration
@EnableGlobalAuthentication
public class SecurityConfiguration extends  WebSecurityConfigurerAdapter {
	
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
			http
				.authorizeRequests()
				.antMatchers("/picture/**").permitAll()
				.antMatchers("/webjars/**").permitAll()
				.antMatchers("/","/home","/about").permitAll()
				.antMatchers("/cat/**").hasRole("CAT")
				.antMatchers("/dog/**").hasRole("DOG")
				.anyRequest().authenticated() //Ensures that any request to our application requires the user to be authenticated 
				.and()
				.formLogin().loginPage("/login").permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
            	.withUser("cat").password("ilikecats").roles("CAT")
                .and()
                .withUser("dog").password("ilikedogs").roles("DOG");
    }
	
}
