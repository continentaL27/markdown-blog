package com.conti.markdownblog.core.author;

import com.conti.markdownblog.core.post.Post;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String url;

    @OneToMany(mappedBy = "author",
            fetch = FetchType.LAZY)
    private List<Post> posts;

}
