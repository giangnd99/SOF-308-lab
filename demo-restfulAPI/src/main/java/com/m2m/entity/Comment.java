package com.m2m.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "comments")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss dd/MM/yyyy")
    @Column
    private Timestamp createdDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference("user-comments")
    private User user;

    @ManyToOne
    @JoinColumn(name = "postId")
    @JsonBackReference("post-comments")
    private Post post;
}
