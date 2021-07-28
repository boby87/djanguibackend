package ftg.djagui.configuration.Security;

import ftg.djagui.CONSTANTE.RoleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration//Definir la classe comme classe de configuration
@EnableWebSecurity//Pour activer la securite du web
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

    @Qualifier("serviceuserdetails")
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;//il faut maitenant l'instantier et pour notre cas c'est dans la classe de demarage


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //cette methode permet de montrer à spring securite comment il va chercher les utilisateurs et les roles
        /*on va utiliser un systeme d'authentification basé sur les services et pour cella on va utiliser userdetailService
        par la suite on cree une classe qui va l'implementer
         */
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);//quand  on va hacher le  mot de pass saisi par utilisateur on va le comparer avec celui de la bd grace a cette fonction
    }

    protected void configure(HttpSecurity http) throws Exception {
        //ici on va definir les droits acces et les filtres

        http.csrf().disable()
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .authorizeRequests().antMatchers("/login/**", "/role/**","/membre/register", "/app-endpoint/**",
                "/api-docs/**", "/topic/**", "/app/**","/swagger-ui.html/**").permitAll()
        .and().authorizeRequests().antMatchers("/reunion/**", "/membre/**",
                "/annee/**","/classe/**","/matiere/**","/emploidutemps/**").hasAnyAuthority(RoleStatus.PRESIDENT)
        //.and().authorizeRequests().anyRequest().authenticated()
        .and().addFilter(new JWTauthentificationFilter(authenticationManager()))
                .addFilterBefore(new JWTauthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

}
