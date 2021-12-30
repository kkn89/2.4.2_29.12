package jm.security.example.service;

import jm.security.example.model.Role;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
@Service
public interface RoleService {
    List<Role> allRoles();
    void add(Role role);

    void update(Role role);

    Role getById(long id);

    Role getByName(String roleName);

    public HashSet getRoleSet(String[] role);


}
