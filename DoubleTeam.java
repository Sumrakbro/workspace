package com.company;

import ru.ifmo.se.pokemon.*;

class DoubleTeam extends StatusAttacks {

    protected DoubleTeam(Type type, double power, double accuracity, String name) {
        super(type, power, accuracity, name);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.EVASION, -1);
    }
}
