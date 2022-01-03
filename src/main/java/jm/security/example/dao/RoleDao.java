package jm.security.example.dao;

import jm.security.example.model.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleDao {
    List<Role> allRoles();

    void add(Role role);

    void update(Role role);

    Role getById(long id);

    Role getByName(String roleName);

    HashSet<Role> getRoleSet(String[] roleName);
}
