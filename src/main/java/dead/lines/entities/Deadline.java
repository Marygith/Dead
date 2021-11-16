package dead.lines.entities;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "deadline")
public class Deadline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "spaceId")
    private Integer spaceId;

    @Column(name = "name")
    private String name;

    @Column(name = "importance")
    private Integer importance = 1;

    @Column(name = "color")
    private String color = "a8a7a8";

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description = "-";

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
