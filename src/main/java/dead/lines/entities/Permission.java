package dead.lines.entities;

import javax.persistence.*;

@Entity
@Table(name = "permissiontowatch")
public class Permission {

    @Id
    @Column(name = "permissionId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "spaceId")
    private Integer spaceId;

    @Column(name = "userId")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
