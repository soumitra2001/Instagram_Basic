package com.geekster.Instagram_Basic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    @NotBlank
    private String postData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id",nullable = false)
    private User user;

    public Post(User user,String data){
        this.user=user;
        this.createdDate=createdDate==null?Timestamp.valueOf(LocalDateTime.now()):this.createdDate;
        this.updatedDate=Timestamp.valueOf(LocalDateTime.now());
        this.postData=data;
    }
}
