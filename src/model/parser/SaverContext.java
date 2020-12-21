package src.model.parser;

// classe Context (pour le pattern Strategy)
public class SaverContext {

    private SaveStrategy saver;

    public SaverContext(SaveStrategy saver){
        this.saver = saver;
    }

    public void executeStrategy(){
        saver.writeFile();
    }
}

