/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import engine.GameEngine;
import engine.IGameLogic;

 /*
 * @author xgdovin1
 */
public class Game {
    
    public static void main(String[] args) {
        try {
            boolean vSync = true;
            IGameLogic gameLogic = new Breakout();
            GameEngine gameEng = new GameEngine("Breakout", 600, 480, vSync, gameLogic);
            gameEng.start();
        } catch (Exception excp) {
            excp.printStackTrace();
            System.exit(-1);
        }
    } 
}
