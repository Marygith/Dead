package dead.lines.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer implements UserDetails {
//    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    @Id
    @Column(name = "id_customer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_customer")
    private String name;

/*    @Column(name = "mail_customer")
    private String mail;*/

    @Column(name = "login_customer")
    private String username;

    @Column(name = "password_customer")
    private String password;

    @Column(name = "code")
    private Integer code = -1;

    @Column(name = "isUser")
    private boolean isUser = false;

    @Column(name = "isAdmin")
    private boolean isAdmin = false;

    @Column(name = "spaceId")
    private Integer spaceId = 0;


 /*   @CollectionTable(name = "customer_role", joinColumns = @JoinColumn(name = "id_customer"))
    @Enumerated(EnumType.STRING)*/
/*    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;*/


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public void setusername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Set<Role> getRoles() {
        Set<Role> roles = new HashSet<Role>();
        if(isUser()) {roles.add(Role.USER);}
        if(isAdmin()) {roles.add(Role.ADMIN);}
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        if(roles.contains(Role.USER)) {setUser(true);}
        if(roles.contains(Role.ADMIN)) {setAdmin(true);}
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }
}
