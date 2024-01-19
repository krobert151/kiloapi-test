package com.salesianostriana.kilo.services;

import com.salesianostriana.kilo.dtos.cajas.EditCajaDTO;
import com.salesianostriana.kilo.entities.Caja;
import com.salesianostriana.kilo.entities.Destinatario;
import com.salesianostriana.kilo.repositories.CajaRepository;
import com.salesianostriana.kilo.repositories.DestinatarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CajaServiceTest {

    @Mock
    CajaRepository repository;
    @Mock
    DestinatarioRepository destinatarioRepository;

    @InjectMocks
    CajaService service;

    @Mock
    DestinatarioService destinatarioService;

    @Test
    void editCaja() {
        Long id = 1L;

        Destinatario destinatario = Destinatario
                .builder()
                .id(id)
                .cajas(new ArrayList<>())
                .direccion("Condes de Bustillo 17")
                .nombre("Manolo")
                .personaContacto("Alfredo").telefono("625741853")
                .build();

        destinatarioRepository.save(destinatario);

        Caja caja = Caja
                .builder()
                .numCaja(2)
                .qr("kjshdflaksjdlkjdf")
                .alimentos(new HashSet<>())
                .destinatario(destinatario)
                .id(id)
                .build();

        EditCajaDTO editCajaDTO = EditCajaDTO.builder().destinatarioId(id).numero(3).qr("kjshdflaksjdlkjdfaa").build();

        when(repository.findById(id)).thenReturn(Optional.of(caja));

        Optional<Caja> resultado = service.editCaja(editCajaDTO, id);

        assertTrue(resultado.isPresent());

        Caja cajaEditada = resultado.get();
        assertEquals(cajaEditada, service.findById(id).get());

        assertEquals(3, cajaEditada.getNumCaja());
        assertEquals("kjshdflaksjdlkjdfaa", cajaEditada.getQr());
    }
}