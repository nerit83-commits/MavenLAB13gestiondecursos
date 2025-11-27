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


/*
*Test individual:
*Crea OnsiteCourse
*Verifica título, duración, aula y cupo → OK
*Test parametrizado:
*Prueba cupos: 10, 0 y -5
*Verifica comportamiento especial para cupos negativos (tu clase los pone en 0)
*Ciclo de vida del test:
*BeforeAll → mensaje inicial
*AfterAll → mensaje final
*BeforeEach → crea instancia nueva
*AfterEach → limpia instancia
*/



public class AppTestOnsiteCourse {

    private OnsiteCourse onsiteCourse;

    // CICLO DE VIDA

    @BeforeAll
    static void beforeAll() {
        System.out.println("Iniciando OnsiteCourseTest...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando OnsiteCourseTest...");
    }

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach → creando OnsiteCourse");
        onsiteCourse = new OnsiteCourse("Cocina Básica", 6, "A-12", 20);
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach → limpiando instancia");
        onsiteCourse = null;
    }

    
    // TEST INDIVIDUAL

    @Test
    @DisplayName("✔ Constructor crea correctamente el OnsiteCourse")
    void testConstructor() {
        assertNotNull(onsiteCourse);

        assertEquals("Cocina Básica", onsiteCourse.getTitle());
        assertEquals(6, onsiteCourse.getDuration());
        assertEquals("A-12", onsiteCourse.getClassroom());
        assertEquals(20, onsiteCourse.getMaxQuota());
    }

 
    // TEST PARAMETRIZADO

    @ParameterizedTest
    @CsvSource({
            "10",
            "0",
            "-5"
    })
    @DisplayName("✔ Validación de cupos (maxQuota) con distintos valores")
    void testSetMaxQuota(int cuota) {
        onsiteCourse.setMaxQuota(cuota);

        if (cuota < 0) {
            assertEquals(0, onsiteCourse.getMaxQuota(), "Valores negativos deben convertirse a 0");
        } else {
            assertEquals(cuota, onsiteCourse.getMaxQuota());
        }
    }

}
