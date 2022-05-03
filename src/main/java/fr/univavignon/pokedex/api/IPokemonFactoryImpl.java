package fr.univavignon.pokedex.api;

import java.util.Random;

public class IPokemonFactoryImpl implements IPokemonFactory {
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata meta = new IPokemonMetadataProviderImpl().getPokemonMetadata(index);
        Random random = new Random();
        return new Pokemon(index,meta.getName(), meta.getAttack(), meta.getDefense(), meta.getStamina(),cp,hp,dust,candy,random.nextInt(100-0) + 0);
    }
}
