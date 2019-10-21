package com.company;

import ru.ifmo.se.pokemon.*;
import ru.ifmo.se.pokemon.Type;

class SpecialAttacks extends SpecialMove {
    protected String Attackname;

    protected SpecialAttacks(Type type, double power, double accuracity, String Attackname) {
        super(type, power, accuracity);
        this.Attackname = Attackname;
    }

    @Override
    protected String describe() {
        String describes = " применяет специальную атаку " + Attackname;
        return describes;
    }
}
