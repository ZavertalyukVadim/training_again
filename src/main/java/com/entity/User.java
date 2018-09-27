package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Size(max = 350, message = "Length is not valid, maximum 350 allowed")
    private String username;

    @Column
    @Email
    @Size(max = 350, message = "Length is not valid, maximum 350 allowed")
    private String email;

    @Column
    @JsonIgnore
    @Size(max = 350, message = "Length is not valid, maximum 350 allowed")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "role")
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Task> tasks;

    public void addTask(Task task){
        if (tasks==null){
            tasks = new ArrayList<>();
        }
        tasks.add(task);
        task.setUser(this);
    }
}
