package ftg.lounk.configuration.Security;

import ftg.lounk.Utilisateur.Metier.MetierMembre;
import ftg.lounk.Utilisateur.Model.Membres;
import ftg.lounk.Utilisateur.Service.ServiceMembre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service("serviceuserdetails")
public class ServiceUserDetails implements UserDetailsService {
    @Autowired
    MetierMembre metierMembre;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Membres membres=metierMembre.findByUsernameOrEmailOrPhone(s);
        if (membres==null)throw new RuntimeException("L'utilisateur n'a pas été identifié");
        Collection<GrantedAuthority> authorities=new ArrayList<>();//on a une collection de role
        membres.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRole()));
        });
        return new User(membres.getTelephone(),membres.getPassword(),authorities);
    }
}
