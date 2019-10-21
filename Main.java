package com.company;

import java.util.Scanner;

import ru.ifmo.se.pokemon.*;


import static ru.ifmo.se.pokemon.Type.*;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Здравствуйте! Это программа- симуляция боя покемонов");
        System.out.println("Хотите ли ей воспользоваться ?(0-Нет/ Любое другое целое число-да)");
        Mbexit();
        System.out.println("Хотите сами сформировать команды покемонов?(0-Нет/ Любое другое целое число-да)");
        Trapinch Pok_Trapinch = new Trapinch("Трапиныч", 1);
        Vibrava Pok_Vibrava = new Vibrava("Вибра", 1);
        Flygon Pok_Flygon = new Flygon("Флайгон", 1);
        Minior Pok_Minior = new Minior("Минион", 1);
        Silvally Pok_Silvally = new Silvally("Силвалли", 1);
        Stantler Pok_Stantler = new Stantler("Стантлер", 1);
        Pokemon[] pokemons = {Pok_Trapinch, Pok_Vibrava, Pok_Flygon, Pok_Minior, Pok_Silvally, Pok_Stantler};
        while (true) {
            String input = in.nextLine();
            if (!Check(input)) {
                System.out.println("Неверный ввод");
            } else if (Integer.parseInt(input) == 0) {
                Automatics(pokemons);
                break;
            } else Hands(pokemons);
            break;
        }
        System.out.println();
    }
    protected static boolean Check(String str) {
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    protected static void Automatics(Pokemon[] pokemons) {

        Battle b = new Battle();
        for (int i = 0; i <=4; i=i+2) {
            b.addAlly(pokemons[i]);
            b.addFoe(pokemons[i + 1]);
        }
        b.go();
    }


    protected static void Hands(Pokemon[] pokemons) {
        String input;
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int count = 0;
        int N = 6;
        Battle b = new Battle();
        Scanner in = new Scanner(System.in);
        System.out.println("Вам нужно будет собрать две команды покемонов.");
        System.out.println("В каждой команде должен быть минимум один покемон.");
        System.out.println("Доступные покемоны:");
        for (int i = 0; i < pokemons.length; i++) {
            System.out.println(" Группа и имя:" + pokemons[i] + "\n" + " Уровень:" + pokemons[i].getLevel() + "\n" + " Здоровье:" + pokemons[i].getHP());
            System.out.println("----------");
        }
        System.out.println("Пришло время сформировать команды.");
        System.out.println("Введите номера покемонов, которые войдут в первую команду");
        while (N > 1) {
            input = in.nextLine();
            if (!Check(input)) System.out.println("Неверный ввод!");
            else if ((Integer.parseInt(input) == 0) && (N < 6)) break;
            else if ((Integer.parseInt(input) == 0) && (N == 6))
                System.out.println("Первая команда не может быть пустой");
            else if ((Integer.parseInt(input) <= 0) || (Integer.parseInt(input) > 6))
                System.out.println("Неверный Ввод!");
            else if (numbers[Integer.parseInt(input) - 1] != 0) {
                b.addAlly(pokemons[Integer.parseInt(input) - 1]);
                --N;
                numbers[Integer.parseInt(input) - 1] = 0;
            } else if (numbers[Integer.parseInt(input) - 1] == 0) {
                System.out.println("Покемон уже состоит в команде!");
            } else System.out.println("Неверный ввод!");
        }
        System.out.println("Первая команда сформирована!");
        System.out.println("Время сформировать вторую команду");
        System.out.println("Введите номера покемонов,которые войдут во вторую команду:");
        while (N > 0) {
            input = in.nextLine();
            if (!Check(input)) System.out.println("Неверный ввод!");
            else if ((Integer.parseInt(input) == 0) && (N < 6)) break;
            else if ((Integer.parseInt(input) == 0) && (N == 6))
                System.out.println("Вторая команда не может быть пустой");
            else if ((Integer.parseInt(input) <= 0) || (Integer.parseInt(input) > 6))
                System.out.println("Неверный Ввод!");
            else if (numbers[Integer.parseInt(input) - 1] != 0) {
                b.addFoe(pokemons[Integer.parseInt(input) - 1]);
                --N;
                numbers[Integer.parseInt(input) - 1] = 0;
            } else if (numbers[Integer.parseInt(input) - 1] == 0) {
                System.out.println("Покемон уже состоит в команде!");
            } else System.out.println("Неверный ввод!");
        }
        b.go();
    }

    protected static void Mbexit() {
        Scanner in = new Scanner(System.in);
        String input;
        while (true) {
            input = in.nextLine();
            if (!Check(input)) {
                System.out.println("Неверный ввод");
            } else if (Integer.parseInt(input) == 0) {
                System.out.print("Пока");
                System.exit(0);
            } else break;
        }
    }
}

class Trapinch extends Pokemon {
    protected Trapinch(String name, int level) {
        super(name, level);
        setMove(new MudSlap(GROUND, 20, 80, "MudSlap"),
                new FeintAttack(DARK, 60, 100, "FeintAttack"));
        setType(GROUND);
        setStats(45, 100, 45, 45, 45, 10);
    }

}

class Vibrava extends Trapinch {
    protected Vibrava(String name, int level) {
        super(name, level);
        addMove(new BugBuzz(BUG, 90, 80, "BugBuzz"));
        setStats(50, 70, 50, 50, 50, 70);
        setType(DRAGON);
    }
}

class Flygon extends Vibrava {
    protected Flygon(String name, int level) {
        super(name, level);
        addMove(new DragonBreath(DRAGON, 60, 80, "DragonBreath"));
        setStats(80, 100, 80, 80, 80, 100);
    }
}

class Minior extends Pokemon {
    protected Minior(String name, int level) {
        super(name, level);
        setMove(new Swagger(NORMAL, 0, 100, "Swagger"),
                new AirSlash(FLYING, 75, 80, "AirSlash"),
                new Facade(NORMAL, 70, 100, "Facade"),
                new Crunch(DARK, 80, 100, "Crunch"));
        setType(ROCK, FLYING);
        setStats(60, 60, 100, 60, 100, 60);
    }

}

class Silvally extends Pokemon {
    protected Silvally(String name, int level) {
        super(name, level);
        setMove(new Swagger(NORMAL, 0, 100, "Swagger"),
                new AirSlash(FLYING, 75, 80, "AirSlash"),
                new Facade(NORMAL, 70, 100, "Facade"));
        setType(NORMAL);
        setStats(95, 95, 95, 95, 95, 95);
    }

}

class Stantler extends Pokemon {
    protected Stantler(String name, int level) {
        super(name, level);
        setMove(new ThunderBolt(ELECTRIC, 90, 80, "ThunderBolt"),
                new Astonish(GHOST, 30, 100, "Astonish"),
                new DoubleTeam(NORMAL, 0, 100, "DoubleTeam"),
                new WildCharge(ELECTRIC, 90, 100, "WildCharge"));
        setType(NORMAL);
        setStats(73, 95, 62, 85, 65, 85);
    }

}

