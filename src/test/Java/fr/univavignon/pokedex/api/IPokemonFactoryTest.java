package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

     private Pokemon pok1;
     private Pokemon pok2;

     IPokemonFactory iPokemonFactory = mock(IPokemonFactory.class);

     @Before
     public void setUp() throws PokedexException {
          pok1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
          pok2 = new Pokemon(133,"Aquali",186,168,260,2729,202,50000,4,100);

          when(iPokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(pok1);
          when(iPokemonFactory.createPokemon(133,2729,202,50000,4)).thenReturn(pok2);
     }

     @Test
     public void createPokemonTest() throws PokedexException {

          assertEquals(pok1,iPokemonFactory.createPokemon(0,613,64,4000,4));
          assertEquals(pok2,iPokemonFactory.createPokemon(133,2729,202,50000,4));

     }
}
