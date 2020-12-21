package src.model.ia;

import src.model.jeu.Plateau;

public interface IaStrategy {

    // En fonction de l'IA, on aura différentes stratégies pour résoudre celle-ci.
    public Plateau solve();

}
