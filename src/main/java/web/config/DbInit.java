package web.config;



import org.springframework.stereotype.Component;
import web.models.Role;
import web.models.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Component
public class DbInit {

    private  UserService userService;
    private  RoleService roleService;

    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void init() {
        Role role1 = new Role();
        Role role2 = new Role();

        role1.setRole("ROLE_ADMIN");
        role2.setRole("ROLE_USER");

        roleService.save(role1);
        roleService.save(role2);

        User user = new User();
        user.setUsername("Dopa");
        user.setPassword("1234");
        user.setName("Saykan");
        user.setLastName("Edilov");
        user.setAge(27);
        user.setEmail("edilov_st@mail.com");

        Set<Role> roles = new HashSet<>();
        roles.add(role1);
        roles.add(role2);
        user.setRoles(roles);

        userService.addUser(user);

        User user1 = new User();
        user1.setUsername("Doka");
        user1.setPassword("1234");
        user1.setName("Muslim");
        user1.setLastName("Isaev");
        user1.setAge(26);
        user1.setEmail("isaev_mv@mail.com");

        Set<Role> roles1 = new HashSet<>();
        roles1.add(role2);
        user1.setRoles(roles1);

        userService.addUser(user1);
    }
}
