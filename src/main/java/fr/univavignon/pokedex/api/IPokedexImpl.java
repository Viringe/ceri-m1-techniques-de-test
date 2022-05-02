package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IPokedexImpl implements IPokedex {

    private IPokemonFactory iPokemonFactory;
    private IPokemonMetadataProvider iPokemonMetadataProvider;
    private List<Pokemon> pokemonList = new ArrayList<Pokemon>();

    public IPokedexImpl(IPokemonFactory iPokemonFactory, IPokemonMetadataProvider iPokemonMetadataProvider) {
        this.iPokemonFactory = iPokemonFactory;
        this.iPokemonMetadataProvider = iPokemonMetadataProvider;
    }

    @Override
    public int size() {
        return pokemonList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        return pokemonList.add(pokemon)? 1 : 0;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if(id > 150) throw new PokedexException("Taille pokedex dépaser");
        if(id < 0) throw new PokedexException("Aucun pokemon avec cette id");
        Pokemon tmp =pokemonList.get(id);
        if(tmp==null) throw new PokedexException("Aucun pokemon avec cette id");
        return tmp;
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemonList;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> tmp = pokemonList;
        tmp.sort(order);
        return tmp;
    }


    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return iPokemonFactory.createPokemon(index,cp,hp,dust,candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return iPokemonMetadataProvider.getPokemonMetadata(index);
    }
}
