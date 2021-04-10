//package banger.demo.service;
//
//import banger.demo.Entity.Customer;
//import banger.demo.Repo.CustomerRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class UserDetail implements UserDetailsService {
//
//    @Autowired
//    private CustomerRepo customerRepo;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Customer user = customerRepo.findByUsername(username);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                new ArrayList<>());
//    }
//
//
//}
