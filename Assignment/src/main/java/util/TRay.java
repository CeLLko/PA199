package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */
public class TRay {
    public Vec3 direction;
    public Vec3 origin;

    public TRay(Vec3 direction, Vec3 origin) {
        this.direction = direction.unit();
        this.origin = origin;
    }
    
    private TRay(){
        
    }
    
    public Vec3 getPoint(double distance){
        return this.origin.add(this.direction.mul(distance));
    }
    
    public double distanceToPoint(Vec3 point){
        Vec3 vecA = point.sub(this.origin);
        Vec3 vecB = point.sub(this.origin.add(this.direction));
        return (Vec3.cross(vecA, vecB).magnitude() / vecA.sub(vecB).magnitude());
    }
}
