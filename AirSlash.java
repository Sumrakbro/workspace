package com.company;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

class AirSlash extends SpecialAttacks {

    protected AirSlash(Type type, double power, double accuracity, String name) {
        super(type, power, accuracity, name);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect.flinch(pokemon);
    }
}
