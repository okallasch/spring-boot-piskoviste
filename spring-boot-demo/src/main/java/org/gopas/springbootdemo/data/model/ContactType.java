package org.gopas.springbootdemo.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact_type")
public class ContactType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact_type")
    private Long id;
    @Column(name = "title")
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ContactType{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
