package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class FelineTest {
    Feline feline = new Feline();
    @Test
    void getKittensWithKittensCount(){
        assertEquals(feline.getKittens(5), 5);
    }
    @Test
    void getKittensSuccess(){
        assertEquals(feline.getKittens(), 1);
    }

    @Test
    void getFamilySuccess(){
        assertEquals(feline.getFamily(), "Кошачьи");
    }

    @Test
    void eatMeatWithSpy() throws Exception {
        Feline felineSpy = spy(new Feline());
        when(felineSpy.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> food = felineSpy.eatMeat();

        verify(felineSpy, times(1)).getFood("Хищник");
        assertEquals(food, List.of("Животные", "Птицы", "Рыба"));
    }

}