package fr.univavignon.pokedex.api;

public class IPokemonTrainerFactoryImpl implements IPokemonTrainerFactory {
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokemonMetadataProvider iPokemonMetadataProvider = new IPokemonMetadataProviderImpl();
        IPokemonFactory iPokemonFactory = new IPokemonFactoryImpl();
        return new PokemonTrainer(name,team,pokedexFactory.createPokedex(iPokemonMetadataProvider, iPokemonFactory));
    }
}
