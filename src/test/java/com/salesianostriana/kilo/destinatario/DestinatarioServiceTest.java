package com.salesianostriana.kilo.destinatario;

import com.salesianostriana.kilo.entities.Destinatario;
import com.salesianostriana.kilo.repositories.DestinatarioRepository;
import com.salesianostriana.kilo.services.DestinatarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DestinatarioServiceTest {


    @Mock
    private DestinatarioRepository destinatarioRepository;

    @InjectMocks
    private DestinatarioService destinatarioService;



    @Test
    public void deleteById_ValidId_DeletesDestinatario() {
        Long id = 1L;
        Destinatario destinatario = Destinatario.builder()
                .id(id)
                .direccion("Calle Manolo")
                .nombre("Manolo")
                .cajas(new ArrayList<>())
                .personaContacto("Manue")
                .telefono("123456789")
                .build();
        when(destinatarioRepository.findById(id)).thenReturn(Optional.of(destinatario));

        destinatarioService.deleteById(id);

        verify(destinatarioRepository, times(1)).delete(destinatario);
    }





}
