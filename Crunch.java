package com.company;
import ru.ifmo.se.pokemon.*;

class Crunch extends Attacks {

    protected Crunch(Type type, double power, double accuracity, String name) {
        super(type, power, accuracity, name);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.DEFENSE, -1);
    }
}
