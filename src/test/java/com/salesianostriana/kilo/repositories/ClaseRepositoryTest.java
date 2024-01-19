package com.salesianostriana.kilo.repositories;

import com.salesianostriana.kilo.dtos.ranking.RankQueryResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles({"test"})
@Testcontainers
@Sql(value = "classpath:insert-product.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "classpath:delete-product.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ClaseRepositoryTest {

    @Autowired
    ClaseRepository repository;

    @Test
    void findClasesOrderedByRank() {

        List<RankQueryResponseDTO> resultado = repository.findClasesOrderedByRank();



    }
}