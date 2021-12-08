package lisa;


import static lisa.Game.Game.end_round;
import static lisa.Game.Game.isEndGame;

import lisa.Game.Game;
import lisa.Ui.Ui;

/*
 * This is the main class, putting everything together
*/

public class Main {

    public static void main(String[] args) {

        Ui ui = new Ui();

        ui.initBoard();

        Game game = new Game();
        System.out.println("Game started");
        /*
        * Timeout
        */
        while(! isEndGame()) {
             while (!end_round(ui.getBoard())) {
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
        }
    }

}
