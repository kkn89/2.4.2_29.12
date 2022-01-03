package jm.security.example.dao;

import jm.security.example.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RoleDaoImpl() {
    }

    @Override
    public List<Role> allRoles() {
        return entityManager.createQuery("FROM Role", Role.class).getResultList();
    }

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role getById(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getByName(String roleName) {
        TypedQuery<Role> query = entityManager.createQuery(
                "SELECT role FROM Role role WHERE role.role = :role", Role.class);
        return query
                .setParameter("role", roleName)
                .getSingleResult();
    }
    @Override
    public HashSet<Role> getRoleSet(String[] roleName) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roleName) {
            roleSet.add(getByName(role));
        }
        return (HashSet) roleSet;
    }

}
