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
*Identificar 1 test y Reescribilor usando @ParameterizedTest con:
 @MethodSource (idealmente uno que necesite múltiples parámetros o lógica 
personalizada)
*/



public class AppTestOnsiteCourse {

    private OnsiteCourse onsiteCourse;

    // CICLO DE VIDA

    @BeforeAll  //Se ejecuta solo una vez antes de todos los test.
    static void beforeAll() {
        System.out.println("Iniciando OnsiteCourseTest...");
    }

    @AfterAll  //Se ejecuta solo una vez después de todos los test.
    static void afterAll() {
        System.out.println("Finalizando OnsiteCourseTest...");
    }

    @BeforeEach
    void setUp() {  //Se ejecuta antes de cada test individual.
        System.out.println("BeforeEach → creando OnsiteCourse");
        onsiteCourse = new OnsiteCourse("Cocina Básica", 6, "A-12", 20); //Se crea una instancia para evitar contaminación entre test.
    }

    @AfterEach  //Se ejecuta después de cada test individual.
    void tearDown() {
        System.out.println("AfterEach = limpiando instancia");
        onsiteCourse = null;  //Se limpira para liberar memoria.
    }

    
    // TEST QUE SE PUEDE PARAMETRIZAR

    @ParameterizedTest  //Constructor test usando múltiples parámetros.
    @CsvSource({  //Permite definir múltiples conjuntos de datos para el test.
            "Cocina Básica, 6, A-12, 20",
            "Fotografía, 4, B-5, 15",
            "Programación, 10, C-3, 30"
    })
    @DisplayName("Constructor crea correctamente el OnsiteCourse")
    void testOnsiteCourseConstructor(String title, int duration, String classroom, int maxQuota) {
        OnsiteCourse course = new OnsiteCourse(title, duration, classroom, maxQuota);

        assertNotNull(course);  //Verifica que la instancia no sea nula.
        assertEquals(title, course.getTitle());
        assertEquals(duration, course.getDuration());
        assertEquals(classroom, course.getClassroom());
        assertEquals(maxQuota, course.getMaxQuota());
    }
    /*void testConstructor() {
        assertNotNull(onsiteCourse);  //Verifica que la instancia no sea nula.

        assertEquals("Cocina Básica", onsiteCourse.getTitle());
        assertEquals(6, onsiteCourse.getDuration());
        assertEquals("A-12", onsiteCourse.getClassroom());
        assertEquals(20, onsiteCourse.getMaxQuota());
    }
    */
 
    // TEST PARAMETRIZADO

    @ParameterizedTest
    @CsvSource({
            "10",
            "0",
            "-5"
    })
    @DisplayName("Validación de cupos (maxQuota) con distintos valores")
    void testSetMaxQuota(int cuota) {  //Llama al setter con distintos valores.
        onsiteCourse.setMaxQuota(cuota);

        if (cuota < 0) {  //Si el valor es negativo, lo convierte a 0.
            assertEquals(0, onsiteCourse.getMaxQuota(), "Valores negativos deben convertirse a 0");
        } else {  //Si el valor es válido, debe coincidir.
            assertEquals(cuota, onsiteCourse.getMaxQuota());
        }
    }

}
