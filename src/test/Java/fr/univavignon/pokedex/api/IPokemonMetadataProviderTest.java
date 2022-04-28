package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private PokemonMetadata pok1;
    private PokemonMetadata pok2;

    IPokemonMetadataProvider iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);

    @Before
    public void setUp() throws PokedexException {
        pok1 = new PokemonMetadata(5,"roucoul",120,60,150);
        pok2 = new PokemonMetadata(0,"pickachu",60,50,90);

        when(iPokemonMetadataProvider.getPokemonMetadata(5)).thenReturn(pok1);
        when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pok2);
        when(iPokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("pokemon non existant"));
    }

    @Test
    public void getPokemonMetadataTest() throws PokedexException {

        assertEquals(pok1,iPokemonMetadataProvider.getPokemonMetadata(5));
        assertEquals(pok2,iPokemonMetadataProvider.getPokemonMetadata(0));

        Exception exception = assertThrows(PokedexException.class, () -> {
            iPokemonMetadataProvider.getPokemonMetadata(-1);
        });
        assertTrue(exception.getMessage().contains("pokemon non existant"));

    }

}
