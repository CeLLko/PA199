/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

/**
 *
 * @author xgdovin1
 */
public interface IGameLogic {

    void init() throws Exception;

    void input(Window window);

    void update(float interval);
    
    void render(Window window);
}