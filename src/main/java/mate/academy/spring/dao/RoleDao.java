package mate.academy.spring.dao;

import mate.academy.spring.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDao {

    void add(Role role);

    Optional<Role> getRoleByName(String name);

    List<Role> getAllRoles();
}
