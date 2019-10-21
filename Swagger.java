package com.company;

import ru.ifmo.se.pokemon.*;

class Swagger extends StatusAttacks {

    protected Swagger(Type type, double power, double accuracity, String name) {
        super(type, power, accuracity, name);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect.confuse(pokemon);
        pokemon.setMod(Stat.ATTACK, 2);
    }
}
