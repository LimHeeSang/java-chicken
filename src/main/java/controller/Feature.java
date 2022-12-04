package controller;

import service.PosService;

@FunctionalInterface
public interface Feature {
    void operate(PosService posService);
}
