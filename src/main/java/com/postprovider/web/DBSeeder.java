package com.postprovider.web;


import com.postprovider.web.entity.Comment;
import com.postprovider.web.entity.Post;
import com.postprovider.web.entity.Tag;
import com.postprovider.web.repository.PostRepository;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(DBSeeder.class);

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {




        Post postA = new Post(
                "0",
                "Hotel trivago",
                "hotel",
                47.1,
                78.2,
                "Calle falsa 123",
                "111111",
                "Madrid",
                "3121546798",
                Arrays.asList("0", "1"),
                Arrays.asList(
                        new Tag("Comida", "Tiene comida"),
                        new Tag("Piscina", "Tiene piscina")
                )
        );

        Post postB =

        new Post(
                "0",
                "Vuelo 370",
                "vuelo",
                47.1,
                78.2,
                "Calle falsa 123",
                "111111",
                "Madrid",
                "3121546798",
                Arrays.asList("0", "1"),
                Arrays.asList(
                        new Tag("Sin escalas", "Vuelo directo sin escalas.")
                )
        );


        Post postC = new Post(
        "0",
                "Tesla",
                "vuelo",
                47.1,
                78.2,
                "Calle falsa 123",
                "111111",
                "Madrid",
                "3121546798",
                Arrays.asList("0", "1"),
                Arrays.asList(
                        new Tag("Eléctrico", "Carro eléctrico."),
                        new Tag("GPS", "GPS integrado.")
                )
        );


        Post postD = new Post(
                "012354",
                "Trattoria Tussardi",
                "restaurant",
                47.1,
                78.2,
                "Calle falsa 123",
                "111111",
                "Madrid",
                "3121546798",
                Arrays.asList(),
                Arrays.asList(
                        new Tag("Apto para vegetarianos", "Menú con opción vegetariana."),
                        new Tag("Etiqueta", "Admisión restringida a un código de etiqueta."),
                        new Tag("Bar", "Bebidas alcohólicas disponibles.")
                )
        );


        this.postRepository.deleteAll();
        List<Post> testPosts = Arrays.asList(postA,postB,postC, postD);
        this.postRepository.saveAll(testPosts);


    }
}
