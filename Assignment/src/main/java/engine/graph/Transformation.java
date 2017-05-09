/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.graph;

import util.Mat4;
import util.Vec3;

/**
 *
 * @author Oldriska
 */
public class Transformation {

    private Mat4 projectionMatrix;

    private Mat4 modelViewMatrix;
    
    private Mat4 viewMatrix;

    public Transformation() {
        projectionMatrix = Mat4.identity();
        modelViewMatrix = Mat4.identity();
        viewMatrix = Mat4.identity();
    }

    public final Mat4 getProjectionMatrix(float fov, float width, float height, float zNear, float zFar) {
        float aspectRatio = width / height;      
        projectionMatrix = Mat4.identity();
        projectionMatrix.perspective(fov, aspectRatio, zNear, zFar);
        return projectionMatrix;
    }
    
    public Mat4 getViewMatrix(Camera camera) {
        Vec3 cameraPos = camera.getPosition();
        Vec3 rotation = camera.getRotation();
        
        viewMatrix = Mat4.identity();
        // First do the rotation so camera rotates over its position
        viewMatrix = viewMatrix.rotate(Math.toRadians(rotation.x), Math.toRadians(rotation.y), 0);
        // Then do the translation
        viewMatrix.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);
        return viewMatrix;
    }

    public Mat4 getModelViewMatrix(GameItem gameItem, Mat4 viewMatrix) {
        Vec3 rotation = gameItem.getRotation();
        modelViewMatrix = Mat4.identity().translate(gameItem.getPosition())
                .rotate(Math.toRadians(-rotation.x)),Math.toRadians(-rotation.y)),Math.toRadians(-rotation.z))
                .scale(gameItem.getScale());
        Mat4 viewCurr = viewMatrix;
        return viewCurr.mul(modelViewMatrix);
    }
}