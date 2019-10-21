package com.company;

import ru.ifmo.se.pokemon.*;


class Attacks extends PhysicalMove {
    protected String Attacktname;

    protected Attacks(Type type, double power, double accuracity) {
        super(type, power, accuracity);
    }

    protected Attacks(Type type, double power, double accuracity, String Attackname) {
        super(type, power, accuracity);
        this.Attacktname = Attackname;
    }

    @Override
    protected String describe() {
        String describes = "применяет физическую атаку " + Attacktname;
        return describes;
    }
}
