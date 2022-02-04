package com.conti.markdownblog.core.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>, CrudRepository<Author, Long> {
}
