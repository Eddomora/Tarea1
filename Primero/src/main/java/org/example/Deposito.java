package org.example;

import java.util.ArrayList;

class Deposito {
    private ArrayList<Bebida> dep;
    public void addBebida(Bebida bebida) {
        dep.add(bebida);
    }
    public Bebida getBebida() {
        if (dep.size() != 0) {
            Bebida b = dep.get(0);
            dep.remove(0);
            return b;
        } else {
            return null;
        }
    }
    public Deposito(int c) {
        dep = new ArrayList<Bebida>(c);
    }
}

class DepositoM {
    private ArrayList<Moneda> depM;
    public void addMoneda(Moneda moneda) {
        depM.add(moneda);
    }
    public Moneda getMoneda() {
        if (depM.size() != 0) {
            Moneda m = depM.get(0);
            depM.remove(0);
            return m;
        } else {
            return null;
        }
    }
    public DepositoM(int c) {
        depM = new ArrayList<Moneda>(c);
    }
}
