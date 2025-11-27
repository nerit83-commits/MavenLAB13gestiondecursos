package com.gestiondecursos;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class AppTestOnlineCourse {

    private OnlineCourse onlineCourse;

    // CICLO DE VIDA
   
    @BeforeAll
    static void beforeAll() {
        System.out.println("Iniciando OnlineCourseTest...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando OnlineCourseTest...");
    }

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach → creando OnlineCourse");
        onlineCourse = new OnlineCourse("Java Web", 12, "Mario Pérez", "Udemy");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach → limpiando instancia");
        onlineCourse = null;
    }

    
    // TEST INDIVIDUAL
   
    @Test
    @DisplayName("Verifica que OnlineCourse se crea correctamente")
    void testConstructor() {
        assertNotNull(onlineCourse);
        assertEquals("Java Web", onlineCourse.getTitle());
        assertEquals(12, onlineCourse.getDuration());
        assertEquals("Mario Pérez", onlineCourse.getProfessor());
        assertEquals("Udemy", onlineCourse.getPlataform());
    }

   

    // TEST PARAMETRIZADO
   
    @ParameterizedTest
    @CsvSource({
            "Plataforma1",
            "Plataforma2",
            "Plataforma3"
    })
    @DisplayName("Cambiar plataforma con distintos valores")
    void testSetPlataform(String plataforma) {
        onlineCourse.setPlataform(plataforma);
        assertEquals(plataforma, onlineCourse.getPlataform());
    }
}
