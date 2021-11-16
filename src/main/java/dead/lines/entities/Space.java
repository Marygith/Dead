package dead.lines.entities;


import javax.persistence.*;

@Entity
@Table(name = "space")
public class Space {

    @Id
    @Column(name = "spaceId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "colorLight")
    private String colorLight = "FFFFFF";

    @Column(name = "colorDark")
    private String colorDark = "073340";

    @Column(name = "link")
    private String link = "/";


    public Integer getSpaceId() {
        return id;
    }

    public void setSpaceId(Integer id) {
        this.id = id;
    }

    public String getColorLight() {
        return colorLight;
    }

    public void setColorLight(String colorLight) {
        this.colorLight = colorLight;
    }

    public String getColorDark() {
        return colorDark;
    }

    public void setColorDark(String colorDark) {
        this.colorDark = colorDark;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
