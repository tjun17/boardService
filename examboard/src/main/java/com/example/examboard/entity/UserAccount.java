package com.example.examboard.entity;

import com.example.examboard.entity.constant.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "email", unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class UserAccount extends AuditingFields {
    @Id
    @Column(length = 50)
    @Setter
    private String userId;

    @Setter
    @Column(nullable = false)
    private String userPassword;

    @Setter
    @Column(length = 100)
    private String email;

    @Setter
    @Column(length = 100)
    private String nickname;
    @Setter
    @Column
    private UserRole userRole;

    @OneToMany(mappedBy = "userAccount")
    private List<Article> articles = new ArrayList<>();
}