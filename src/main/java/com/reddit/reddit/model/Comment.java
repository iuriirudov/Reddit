package com.reddit.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotEmpty(message = "Post name cannot be empty")
    private String text;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    private Post post;

    private Instant created;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

}
