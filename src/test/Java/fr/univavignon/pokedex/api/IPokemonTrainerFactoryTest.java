package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    private PokemonTrainer pokemonTrainer;

    IPokemonTrainerFactory iPokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
    IPokedexFactory iPokedexFactory = mock(IPokedexFactory.class);
    IPokedex iPokedex = mock(IPokedex.class);

    @Before
    public void setUp() throws PokedexException {
        pokemonTrainer = new PokemonTrainer("sasha",Team.VALOR,iPokedex);
        when(iPokemonTrainerFactory.createTrainer("sasha",Team.VALOR,iPokedexFactory)).thenReturn(pokemonTrainer);

    }

    @Test
    public void createTrainer() throws PokedexException {

        assertEquals(iPokemonTrainerFactory.createTrainer("sasha",Team.VALOR,iPokedexFactory),pokemonTrainer);
        assertNotEquals(iPokemonTrainerFactory.createTrainer("sasha",Team.VALOR,iPokedexFactory),null);


    }
}
