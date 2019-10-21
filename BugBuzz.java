package com.company;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

class BugBuzz extends SpecialAttacks {

    protected BugBuzz(Type type, double power, double accuracity, String name) {
        super(type, power, accuracity, name);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.SPECIAL_DEFENSE, -1);
    }
}
