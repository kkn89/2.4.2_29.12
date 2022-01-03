package jm.security.example.service;

import jm.security.example.dao.RoleDao;
import jm.security.example.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public List<Role> allRoles() {
        return roleDao.allRoles();
    }

    @Override
    @Transactional
    public void add(Role role) {
        roleDao.add(role);

    }

    @Override
    @Transactional
    public void update(Role role) {
        roleDao.update(role);

    }

    @Override
    @Transactional
    public Role getById(long id) {
        return roleDao.getById(id);
    }

    @Override
    @Transactional
    public Role getByName(String roleName) {
        return roleDao.getByName(roleName);
    }

    @Override
    public HashSet<Role> getRoleSet(String[] roleName) {
       return roleDao.getRoleSet(roleName);
    }
}
