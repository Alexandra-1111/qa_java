package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {
    @Mock
    Feline feline;
    @InjectMocks
    Cat cat;

    @Test
    void getFoodWithMock() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> food = cat.getFood();

        verify(feline, times(1)).eatMeat();
        assertEquals(food, List.of("Животные", "Птицы", "Рыба"));
    }
    @Test
    void getSoundSuccess(){
        assertEquals(cat.getSound(), "Мяу");
    }

}