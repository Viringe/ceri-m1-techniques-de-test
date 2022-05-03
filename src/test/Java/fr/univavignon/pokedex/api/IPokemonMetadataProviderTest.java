package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static fr.univavignon.pokedex.api.IPokemonMetadataProviderImpl.pokemonMetadata;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private PokemonMetadata pok1;
    private PokemonMetadata pok2;

//    IPokemonMetadataProvider iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonMetadataProvider iPokemonMetadataProvider = new IPokemonMetadataProviderImpl();
    @Before
    public void setUp() throws PokedexException {
        pok1 = new PokemonMetadata(0,"Bulbizarre",126,126,90);
        pokemonMetadata.add(new PokemonMetadata(0,"Bulbizarre",126,126,90));
//        when(iPokemonMetadataProvider.getPokemonMetadata(5)).thenReturn(pok1);
//        when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pok2);
//        when(iPokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("pokemon non existant"));
//        when(iPokemonMetadataProvider.getPokemonMetadata(151)).thenThrow(new PokedexException("index trops grand"));
    }

    @Test
    public void getPokemonMetadataTest() throws PokedexException {
        PokemonMetadata pok = iPokemonMetadataProvider.getPokemonMetadata(0);

        assertEquals(pok1.getIndex(),pok.getIndex());
        assertEquals(pok1.getName(),pok.getName());
        assertEquals(pok1.getAttack(),pok.getAttack());
        assertEquals(pok1.getDefense(),pok.getDefense());
        assertEquals(pok1.getStamina(),pok.getStamina());

        Exception exception = assertThrows(PokedexException.class, () -> {
            iPokemonMetadataProvider.getPokemonMetadata(-1);
        });
        assertTrue(exception.getMessage().contains("pokemon non existant"));
        exception = assertThrows(PokedexException.class, () -> {
            iPokemonMetadataProvider.getPokemonMetadata(151);
        });
        assertTrue(exception.getMessage().contains("index trops grand"));

    }

}
