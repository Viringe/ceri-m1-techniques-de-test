package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static fr.univavignon.pokedex.api.IPokemonMetadataProviderImpl.pokemonMetadata;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

     private Pokemon pok1;
     private Pokemon pok2;

//     IPokemonFactory iPokemonFactory = mock(IPokemonFactory.class);
     IPokemonFactory iPokemonFactory = new IPokemonFactoryImpl();
     //IPokemonMetadataProvider iPokemonMetadataProvider = new IPokemonMetadataProviderImpl();

     @Before
     public void setUp() throws PokedexException {
          pok1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
//          pok2 = new Pokemon(133,"Aquali",186,168,260,2729,202,50000,4,100);

          pokemonMetadata.add(new PokemonMetadata(0,"Bulbizarre",126,126,90));
//          when(iPokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(pok1);
//          when(iPokemonFactory.createPokemon(133,2729,202,50000,4)).thenReturn(pok2);
     }

     @Test
     public void createPokemonTest() throws PokedexException {
          Pokemon pok = iPokemonFactory.createPokemon(0,613,64,4000,4);

          assertEquals(pok1.getIndex(),pok.getIndex());
          assertEquals(pok1.getName(),pok.getName());
          assertEquals(pok1.getAttack(),pok.getAttack());
          assertEquals(pok1.getDefense(),pok.getDefense());
          assertEquals(pok1.getStamina(),pok.getStamina());
          assertEquals(pok1.getCp(),pok.getCp());
          assertEquals(pok1.getHp(),pok.getHp());
          assertEquals(pok1.getDust(),pok.getDust());
          assertEquals(pok1.getCandy(),pok.getCandy());
          assertTrue(0 <= pok.getIv() && pok.getIv() <= 100);

     }
}
