package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    IPokemonFactory iPokemonFactory = mock(IPokemonFactory.class);
    IPokedexFactory iPokedexFactory = mock(IPokedexFactory.class);
    IPokemonMetadataProvider iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
    IPokedex iPokedex = mock(IPokedex.class);


    @Before
    public void setUp() throws PokedexException {
        when(iPokedexFactory.createPokedex(iPokemonMetadataProvider,iPokemonFactory)).thenReturn(iPokedex);
        when(iPokedex.size()).thenReturn(0);
    }

    @Test
    public void createPokemonTest() throws PokedexException {

        assertEquals(iPokedexFactory.createPokedex(iPokemonMetadataProvider,iPokemonFactory),iPokedex);
        assertEquals(iPokedex.size(),0);

    }

}
