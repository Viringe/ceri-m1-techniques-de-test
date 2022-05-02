package fr.univavignon.pokedex.api;

import java.util.Vector;

public class IPokemonMetadataProviderImpl implements IPokemonMetadataProvider {

    private static Vector<PokemonMetadata> pokemonMetadata = new Vector<PokemonMetadata>();

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index > 150) throw new PokedexException("index trops grand");
        for (PokemonMetadata meta: pokemonMetadata) {
            if(meta.getIndex() == index)
            {
                return meta;
            }
        }
        throw new PokedexException("pokemon non existant");
    }
}
