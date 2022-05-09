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
     IPokemonFactory iPokemonFactory1 = new IPokemonFactoryImpl();
     IPokemonFactory iPokemonFactory2 = new RocketPokemonFactory();
     //IPokemonMetadataProvider iPokemonMetadataProvider = new IPokemonMetadataProviderImpl();

     @Before
     public void setUp() throws PokedexException {
          pok1 = new Pokemon(1,"Bulbasaur",126,126,90,613,64,4000,4,56);
//          pok2 = new Pokemon(133,"Aquali",186,168,260,2729,202,50000,4,100);

          pokemonMetadata.add(new PokemonMetadata(1,"Bulbasaur",126,126,90));
//          when(iPokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(pok1);
//          when(iPokemonFactory.createPokemon(133,2729,202,50000,4)).thenReturn(pok2);
     }

     @Test
     public void createPokemonTest1() throws PokedexException {
          Pokemon pok = iPokemonFactory1.createPokemon(1,613,64,4000,4);

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

     @Test
     public void createPokemonTest2() throws PokedexException {
          Pokemon pok = iPokemonFactory2.createPokemon(1,613,64,4000,4);

          assertEquals(pok1.getIndex(),pok.getIndex());
          assertEquals(pok1.getName(),pok.getName());
          assertTrue(0 < pok.getAttack() && pok.getAttack() < 1000);
          assertTrue(0 < pok.getDefense() && pok.getDefense() < 1000);
          assertTrue(0 < pok.getStamina() && pok.getStamina() < 1000);

          assertEquals(pok1.getCp(),pok.getCp());
          assertEquals(pok1.getHp(),pok.getHp());
          assertEquals(pok1.getDust(),pok.getDust());
          assertEquals(pok1.getCandy(),pok.getCandy());
          assertTrue(0 <= pok.getIv() && pok.getIv() <= 100);

     }
}
