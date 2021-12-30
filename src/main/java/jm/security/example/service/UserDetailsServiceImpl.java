package jm.security.example.service;

import jm.security.example.dao.UserDao;
import jm.security.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

    @Service
    @Transactional
    public class UserDetailsServiceImpl implements UserDetailsService {

        private UserService userService;

        @Autowired
        public UserDetailsServiceImpl(UserService userService) {
            this.userService = userService;
        }

        public User findByUsername(String username) {
            return userService.getUserByName(username);
        }
        // «Пользователь» – это просто Object. В большинстве случаев он может быть
        //  приведен к классу UserDetails.
        // Для создания UserDetails используется интерфейс UserDetailsService, с единственным методом:
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException(String.format("User '%s' not found", username));
            }
            return user;
        }
}
