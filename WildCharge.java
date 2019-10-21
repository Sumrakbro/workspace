package com.company;

import ru.ifmo.se.pokemon.*;

class WildCharge extends Attacks {

    protected WildCharge(Type type, double power, double accuracity, String name) {
        super(type, power, accuracity, name);
    }

    @Override
    protected void applySelfDamage(Pokemon pokemon, double damage) {
        pokemon.setMod(Stat.HP, (int) Math.round(damage / 4));
    }
}
