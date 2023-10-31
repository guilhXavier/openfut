package br.com.gtx.openfut.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.gtx.openfut.domain.entity.AppUser;
import br.com.gtx.openfut.repository.AppUserRepository;
import br.com.gtx.openfut.security.AppUserDetails;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = appUserRepository.findByName(username);

        if (appUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found.");
        }

        return new AppUserDetails(appUser.get());
    }

}
