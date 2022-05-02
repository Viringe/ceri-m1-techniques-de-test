package fr.univavignon.pokedex.api;

public class IPokemonTrainerFactoryImpl implements IPokemonTrainerFactory {
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name,team,pokedexFactory.createPokedex((IPokemonMetadataProvider) new IPokemonTrainerFactoryImpl(), (IPokemonFactory) new IPokemonTrainerFactoryImpl()));
    }
}
