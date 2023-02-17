package cmc.global.TestPurpose.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "people")
public class People {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    public People() {
    }

    public People(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }
}
