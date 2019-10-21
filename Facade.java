package com.company;

import ru.ifmo.se.pokemon.*;

class Facade extends Attacks {

    protected Facade(Type type, double power, double accuracity, String name) {
        super(type, power, accuracity, name);
    }

    @Override
    protected double calcBaseDamage(Pokemon pokemon, Pokemon pokemon1) {
        if (((pokemon1.getCondition() == Status.BURN) | (pokemon1.getCondition() == Status.PARALYZE) |
                (pokemon1.getCondition() == Status.POISON)))
            return (0.4D * (double) pokemon1.getLevel() + 2.0D) * this.power * 2 / 150.0D;
        return super.calcBaseDamage(pokemon, pokemon1);
    }
}
