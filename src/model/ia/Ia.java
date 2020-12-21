package src.model.ia;

import src.model.jeu.Plateau;

// classe Context (pour le pattern Strategy)
public class Ia {

    private IaStrategy iaStrategy;

        public Ia(IaStrategy iaStrategy){
            this.iaStrategy = iaStrategy;
        }

        public Plateau executeStrategy(){
            return iaStrategy.solve();
        }
}
