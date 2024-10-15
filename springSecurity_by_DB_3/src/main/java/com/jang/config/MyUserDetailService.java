package com.jang.config;

import com.jang.model.User;
import com.jang.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService
{

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> user = userRepository.findByUserName(username);
        if(user.isPresent())
        {
          var userObj =user.get();
          return org.springframework.security.core.userdetails.User.builder()
                  .username(userObj.getUserName())
                  .password(userObj.getPassword())
                  .roles(userObj.getRole())
                  .build();

        }
        else
        {
            throw new UsernameNotFoundException(username);
        }

    }
}
