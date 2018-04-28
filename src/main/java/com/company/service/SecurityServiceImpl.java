package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService{

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    UserDetailsService userDetailsService;
/*

    @Autowired
    private AuthenticationManager authenticationManager;
*/

    @Override
    public String findLoggedInEmail() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails){
            return ((UserDetails) userDetails).getUsername();
        }
        return null;
    }

    @Override
    public void autologin(String email, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        UsernamePasswordAuthenticationToken userPassAuthToken = new UsernamePasswordAuthenticationToken(userDetails,
                password, userDetails.getAuthorities());

//        authenticationManager.authenticate(userPassAuthToken);
        if (userPassAuthToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(userPassAuthToken);

        }
    }
}
