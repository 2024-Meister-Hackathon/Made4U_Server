package org.example.made4u.persistence.post.entity;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@AllArgsConstructor
public class BookMarkId implements Serializable {

    private String email;

    private UUID postId;
}
