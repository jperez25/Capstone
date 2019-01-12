package com.capstone.app.Services;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capstone.app.DAO.UserDAO;
import com.capstone.app.DAO.RoleDAO;

 
@Service	
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserDAO appUserDAO;
    
    @Autowired
    private RoleDAO RoleDAO;
 
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.capstone.app.Model.User appUser = (com.capstone.app.Model.User) this.appUserDAO.findUserAccount(userName);
 
        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
        System.out.println("Found User: " + appUser.getName());
 
     // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.RoleDAO.getRoleNames(appUser.getId());
        
        System.out.println(appUser.getId());
        
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
 
        UserDetails userDetails = (UserDetails) new User(appUser.getName(), //
        appUser.getPassword(), grantList);
 
        return userDetails;
    }
 
}
