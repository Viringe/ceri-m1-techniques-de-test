package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    private PokemonMetadata pokMeta1;
    private PokemonMetadata pokMeta2;
    private Pokemon pok1;
    private Pokemon pok2;
    private List<Pokemon> pokemonList = new ArrayList<>();
    List<Pokemon> pokemonList2;
    private PokemonComparators pokemonComparator;

//    IPokemonFactory iPokemonFactory = mock(IPokemonFactory.class);
    IPokemonFactory iPokemonFactory = new IPokemonFactoryImpl();
//    IPokedexFactory iPokedexFactory = mock(IPokedexFactory.class);
    IPokedexFactory iPokedexFactory = new IPokedexFactoryImpl();
//    IPokemonMetadataProvider iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
    IPokemonMetadataProvider iPokemonMetadataProvider = new IPokemonMetadataProviderImpl();
    IPokedex iPokedex = new IPokedexImpl(iPokemonFactory,iPokemonMetadataProvider);


    @Before
    public void setUp() throws PokedexException {
        pok1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
        pok2 = new Pokemon(133,"Aquali",186,168,260,2729,202,50000,4,100);
        pokMeta1 = new PokemonMetadata(0,"Bulbizarre",126,126,90);
        pokMeta2 = new PokemonMetadata(133,"Aquali",186,168,260);
        pokemonList2 = new ArrayList<>();

        pokemonList2.add(pok1);
        pokemonList2.add(pok2);
        pokemonComparator = PokemonComparators.INDEX;

//        when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokMeta1);
//        when(iPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(pokMeta2);
//
//        when(iPokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(pok1);
//        when(iPokemonFactory.createPokemon(133,2729,202,50000,4)).thenReturn(pok2);
//
//        when(iPokedexFactory.createPokedex(iPokemonMetadataProvider,iPokemonFactory)).thenReturn(iPokedex);
//
//        when(iPokedex.size()).thenReturn(pokemonList.size());
//
//        when(iPokedex.addPokemon(pok1)).thenReturn(1);
//        when(iPokedex.addPokemon(pok2)).thenReturn(0);
//
//        when(iPokedex.getPokemon(1)).thenReturn(pok1);
//        when(iPokedex.getPokemon(0)).thenReturn(pok2);
//        when(iPokedex.getPokemon(-1)).thenThrow(new PokedexException("Aucun pokemon avec cette id"));
//        when(iPokedex.getPokemon(151)).thenThrow(new PokedexException("Taille pokedex dépaser"));
//
//        when(iPokedex.getPokemons()).thenReturn(pokemonList);
//
//        when(iPokedex.getPokemons(pokemonComparator)).thenReturn(pokemonList2);

    }

    public void Main() throws PokedexException {

        sizeTest();
        getPokemonTest();
        addPokemonTest();
        getPokemonsTest();
        getPokemonsComparatorTest();
    }

    @Test
    public void sizeTest()
    {
        assertEquals(iPokedex.size(),0);

        //pokemonList.add(pok2);
        iPokedex.addPokemon(pok2);
        //when(iPokedex.size()).thenReturn(pokemonList.size());

        assertEquals(iPokedex.size(),1);
    }

    @Test
    public void getPokemonTest() throws PokedexException {
        iPokedex.addPokemon(pok1);
        assertEquals(iPokedex.getPokemon(0),pok1);
        Exception exception = assertThrows(PokedexException.class, () -> {
            iPokedex.getPokemon(-1);
        });
        assertTrue(exception.getMessage().contains("Aucun pokemon avec cette id"));
        exception = assertThrows(PokedexException.class, () -> {
            iPokedex.getPokemon(151);
        });
        assertTrue(exception.getMessage().contains("Taille pokedex dépaser"));

    }

    @Test
    public void addPokemonTest() throws PokedexException {
        iPokedex.addPokemon(pok1);
        assertEquals(iPokedex.addPokemon(pok1),1);
        assertEquals(iPokedex.getPokemon(1),pok1);
    }

    @Test
    public void getPokemonsTest()
    {
        assertEquals(iPokedex.getPokemons(),pokemonList);
    }

    @Test
    public void getPokemonsComparatorTest()
    {
        iPokedex.addPokemon(pok2);
        iPokedex.addPokemon(pok1);
        pokemonList2 = new ArrayList<>();
        pokemonList2.add(pok1);
        pokemonList2.add(pok2);
        assertEquals(iPokedex.getPokemons(pokemonComparator),pokemonList2);
    }
}
