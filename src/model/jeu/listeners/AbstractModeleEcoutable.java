package src.model.jeu.listeners;

import java.util.List;

public abstract class AbstractModeleEcoutable implements ModeleEcoutable {
    public List<EcouteurModele> ecouteurs;

    public void ajoutEcouteur(EcouteurModele e) {
        this.ecouteurs.add(e);
    }
	
    public void retraitEcouteur(EcouteurModele e) {
		this.ecouteurs.remove(e);
	}
	
    public void fireChangement() {
        for(EcouteurModele e: ecouteurs) {
            e.modeleMisAJour(this);
        }
    }
}

