/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.graph;

import util.Vec3;

public class Camera {

    private final Vec3 position;
    
    private final Vec3 rotation;
    
    public Camera() {
        position = new Vec3(0, 0, 0);
        rotation = new Vec3(0, 0, 0);
    }
    
    public Camera(Vec3 position, Vec3 rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    public Vec3 getPosition() {
        return position;
    }

    public void setPosition(double x, double y, double z) {
        position.x = x;
        position.y = y;
        position.z = z;
    }
    
    public void movePosition(double offsetX, double offsetY, double offsetZ) {
        if ( offsetZ != 0 ) {
            position.x += (double)Math.sin(Math.toRadians(rotation.y)) * -1.0f * offsetZ;
            position.z += (double)Math.cos(Math.toRadians(rotation.y)) * offsetZ;
        }
        if ( offsetX != 0) {
            position.x += (double)Math.sin(Math.toRadians(rotation.y - 90)) * -1.0f * offsetX;
            position.z += (double)Math.cos(Math.toRadians(rotation.y - 90)) * offsetX;
        }
        position.y += offsetY;
    }

    public Vec3 getRotation() {
        return rotation;
    }
    
    public void setRotation(double x, double y, double z) {
        rotation.x = x;
        rotation.y = y;
        rotation.z = z;
    }

    public void moveRotation(double offsetX, double offsetY, double offsetZ) {
        rotation.x += offsetX;
        rotation.y += offsetY;
        rotation.z += offsetZ;
    }
}