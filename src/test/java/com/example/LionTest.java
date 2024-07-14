package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {
    @Mock
    Feline feline;
    Lion lion;
    @BeforeEach
    void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }
    @Test
    void getFoodWithMock() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> food = lion.getFood();

        verify(feline, times(1)).getFood("Хищник");
        assertEquals(food, List.of("Животные", "Птицы", "Рыба"));
    }
    @Test
    void getKittens() throws Exception {
        when(feline.getKittens()).thenReturn(1);

        assertEquals(lion.getKittens(), 1);
        verify(feline, times(1)).getKittens();
    }
}