package com.company;

import ru.ifmo.se.pokemon.*;

class MudSlap extends SpecialAttacks {

    protected MudSlap(Type type, double power, double accuracity, String name) {
        super(type, power, accuracity, name);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.ACCURACY, -1);
    }
}
