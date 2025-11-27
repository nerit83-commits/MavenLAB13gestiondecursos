package com.gestiondecursos;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


/*
*CourseTest.java
*Testea constructor, getters, showInformation
*1 test parametrizado 
*1 test normal
*1 ciclo de vida
*/

public class AppTestCourse {

    private Course course;

    //CICLO DE VIDA

    @BeforeAll
    static void beforeAll() {
        System.out.println("Iniciando AppTest...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando AppTest...");
    }


    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach → creando instancia de Course");
        course = new Course("Intro a Java", 8);
    }

    @AfterEach
    void tearDown() {
        System.out.println("⚫ AfterEach → limpiando instancia");
        course = null;
    }

    //TEST INDIVIDUAL
    @Test
    @DisplayName("Constructor crea correctamente un objeto Course")
    void testCourseNotNull() {
        assertNotNull(course);
        assertEquals("Intro a Java", course.getTitle());
        assertEquals(8, course.getDuration());
    }


    //TEST PARAMETRIZADO
    @ParameterizedTest
    @ValueSource(strings = {"Python", "Git", "Docker"})
    @DisplayName("Asignación de diferentes títulos de curso")
    void testSetTitle(String title) {
        course.setTitle(title);
        assertEquals(title, course.getTitle());
    }
}


