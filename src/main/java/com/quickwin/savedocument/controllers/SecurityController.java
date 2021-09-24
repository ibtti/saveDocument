package com.quickwin.savedocument.controllers;

import com.quickwin.savedocument.security.JwtUtil;
import com.quickwin.savedocument.security.MyUserDetailsService;
import com.quickwin.savedocument.security.models.AuthenticationRequest;
import com.quickwin.savedocument.security.models.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping ("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try{
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(authenticationRequest.getPassword(),authenticationRequest.getPassword()));

        } catch (BadCredentialsException e){
            throw new Exception("Username or password incorrect",e);
        }
        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUserNames());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
