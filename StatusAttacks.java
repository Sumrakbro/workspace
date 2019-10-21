package com.company;

import ru.ifmo.se.pokemon.*;


class StatusAttacks extends StatusMove {
    protected String Attackname;

    protected StatusAttacks(Type type, double power, double accuracity, String Attackname) {
        super(type, power, accuracity);
        this.Attackname = Attackname;
    }

    @Override
    protected String describe() {
        String describes = "Применяет статусную атаку " + Attackname;
        return describes;
    }
}
