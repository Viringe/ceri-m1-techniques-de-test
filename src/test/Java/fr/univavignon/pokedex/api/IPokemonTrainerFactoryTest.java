package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    private PokemonTrainer pokemonTrainer;

//    IPokemonTrainerFactory iPokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
//    IPokedexFactory iPokedexFactory = mock(IPokedexFactory.class);
//    IPokedex iPokedex = mock(IPokedex.class);
        IPokemonTrainerFactory iPokemonTrainerFactory = new IPokemonTrainerFactoryImpl();
        IPokedexFactory iPokedexFactory = new IPokedexFactoryImpl();
        IPokemonMetadataProvider iPokemonMetadataProvider = new IPokemonMetadataProviderImpl();
        IPokemonFactory iPokemonFactory = new IPokemonFactoryImpl();
        IPokedex iPokedex = new IPokedexImpl(iPokemonFactory,iPokemonMetadataProvider);
    @Before
    public void setUp() throws PokedexException {
        pokemonTrainer = new PokemonTrainer("sasha",Team.VALOR,iPokedex);
        //when(iPokemonTrainerFactory.createTrainer("sasha",Team.VALOR,iPokedexFactory)).thenReturn(pokemonTrainer);

    }

    @Test
    public void createTrainer() throws PokedexException {
        PokemonTrainer trainer = iPokemonTrainerFactory.createTrainer("sasha",Team.VALOR,iPokedexFactory);
        assertEquals(pokemonTrainer.getName(),trainer.getName());
        assertEquals(pokemonTrainer.getPokedex().size(),trainer.getPokedex().size());
        assertEquals(pokemonTrainer.getTeam(),trainer.getTeam());

        assertNotEquals(iPokemonTrainerFactory.createTrainer("sasha",Team.VALOR,iPokedexFactory),null);


    }
}
