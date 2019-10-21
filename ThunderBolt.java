package com.company;


import ru.ifmo.se.pokemon.*;

class ThunderBolt extends SpecialAttacks {

    protected ThunderBolt(Type type, double power, double accuracity, String name) {
        super(type, power, accuracity, name);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect.paralyze(pokemon);
    }
}
