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

    private final Mat4 projectionMatrix;

    private final Mat4 modelViewMatrix;
    
    private final Mat4 viewMatrix;

    public Transformation() {
        projectionMatrix = Mat4.identity();
        modelViewMatrix = Mat4.identity();
        viewMatrix = Mat4.identity();
    }

    public final Mat4 getProjectionMatrix(float fov, float width, float height, float zNear, float zFar) {
        float aspectRatio = width / height;        
        projectionMatrix.identity();
        projectionMatrix.perspective(fov, aspectRatio, zNear, zFar);
        return projectionMatrix;
    }
    
    public Mat4 getViewMatrix(Camera camera) {
        Vec3 cameraPos = camera.getPosition();
        Vec3 rotation = camera.getRotation();
        
        viewMatrix.identity();
        // First do the rotation so camera rotates over its position
        viewMatrix.rotate((float)Math.toRadians(rotation.x), new Vec3(1, 0, 0))
                .rotate((float)Math.toRadians(rotation.y), new Vec3(0, 1, 0));
        // Then do the translation
        viewMatrix.translate(-cameraPos.x, -cameraPos.y, -cameraPos.z);
        return viewMatrix;
    }

    public Mat4 getModelViewMatrix(GameItem gameItem, Mat4 viewMatrix) {
        Vec3 rotation = gameItem.getRotation();
        modelViewMatrix.identity().translate(gameItem.getPosition()).
                rotateX((float)Math.toRadians(-rotation.x)).
                rotateY((float)Math.toRadians(-rotation.y)).
                rotateZ((float)Math.toRadians(-rotation.z)).
                scale(gameItem.getScale());
        Mat4 viewCurr = new Mat4(viewMatrix);
        return viewCurr.mul(modelViewMatrix);
    }
}