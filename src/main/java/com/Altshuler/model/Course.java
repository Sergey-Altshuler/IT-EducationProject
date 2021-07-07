package com.Altshuler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "courses")
@Entity(name = "course")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String title;
    @Column
    private int subgroupNum;
    @Column
    private String learnType;
    @Column
    private int price;
    @Column
    private String address;
    @Column
    private int numOfStudents;
    @Column
    private Date startDate;
    @Column
    private Date finishDate;

    @OneToMany(mappedBy = "course")
    private Set<Student> students = new HashSet<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @OneToOne(optional = false, mappedBy = "course")
    private Stats stats;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && subgroupNum == course.subgroupNum && price == course.price && numOfStudents == course.numOfStudents && Objects.equals(title, course.title) && Objects.equals(learnType, course.learnType) && Objects.equals(address, course.address) && Objects.equals(startDate, course.startDate) && Objects.equals(finishDate, course.finishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subgroupNum=" + subgroupNum +
                ", learnType='" + learnType + '\'' +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", numOfStudents=" + numOfStudents +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
