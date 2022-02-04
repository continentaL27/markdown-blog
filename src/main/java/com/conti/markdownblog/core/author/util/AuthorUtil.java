package com.conti.markdownblog.core.author.util;

import com.conti.markdownblog.core.author.Author;
import com.conti.markdownblog.core.author.AuthorRepository;

import java.util.Optional;

public class AuthorUtil {

    public static Author bootstrapAuthor(AuthorRepository authorRepository) {
        Optional<Author> authorOpt = authorRepository.findById(1L);
        if (authorOpt.isPresent()) {
            return authorOpt.get();
        } else {
            Author digi = new Author();
            digi.setName("Di Gi");
            digi.setEmail("test@gmail.com");
            digi.setUrl("github.com/continentaL27");

            authorRepository.save(digi);
            return digi;
        }
    }
}
