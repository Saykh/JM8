package web.dao;

import web.models.Role;
import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();

    void save(Role role);

}
