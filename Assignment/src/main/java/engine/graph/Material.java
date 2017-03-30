/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.graph;

import util.Vec3;

public class Material {

    private static final Vec3 DEFAULT_COLOUR = new Vec3(1.0f, 1.0f, 1.0f);

    private Vec3 colour;
    
    private float reflectance;
    
    public Material() {
        colour = DEFAULT_COLOUR;
        reflectance = 0;
    }
    
    public Material(Vec3 colour, float reflectance) {
        this();
        this.colour = colour;
        this.reflectance = reflectance;
    }

    public Material(/*Texture texture,*/ float reflectance) {
        this();
        //this.texture = texture;
        this.reflectance = reflectance;
    }

    public Vec3 getColour() {
        return colour;
    }

    public void setColour(Vec3 colour) {
        this.colour = colour;
    }

    public float getReflectance() {
        return reflectance;
    }

    public void setReflectance(float reflectance) {
        this.reflectance = reflectance;
    }
/*
    public boolean isTextured() {
        return this.texture != null;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }*/
}