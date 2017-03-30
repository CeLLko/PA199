package util;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xgdovin1
 */
public class Vec3 {
 
    public double x;
    public double y;
    public double z;
    
    private Vec3(){
    }
    
    public Vec3(Vec3 vec){
        this(vec.x, vec.y, vec.z);
    }
    
    public Vec3(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    
    public Vec3(Vec4 vec){
        this(vec.x, vec.y, vec.z);
    }
    
    public static Vec3 zero(){
        return new Vec3(0,0,0);
    }
    
    public static Vec3 right(){
        return new Vec3(1,0,0);
    }
    
    public static Vec3 left(){
        return new Vec3(-1,0,0);
    }
    
    public static Vec3 up(){
        return new Vec3(0,1,0);
    }
    
    public static Vec3 down(){
        return new Vec3(0,-1,0);
    }
    
    public static Vec3 back(){
        return new Vec3(0,0,1);
    }
    
    public static Vec3 forward(){
        return new Vec3(0,0,-1);
    }
    
    public Vec3 inverse(){
        return new Vec3(-this.x, -this.y, -this.z);
    }
    
    public double magnitude(){
        return Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2)+Math.pow(this.z, 2));
    }
    
    public double length(){
        return this.magnitude();
    }
    
    public Vec3 unit(){
        return new Vec3(this.x/this.magnitude(), this.y/this.magnitude(), this.z/this.magnitude());
    }
    
    public Vec3 normalize(){
        return this.unit();
    }
    
    public Vec3 add(Vec3 other){
        return new Vec3(this.x+other.x, this.y+other.y, this.z+other.z);
    }
    public Vec3 sub(Vec3 other){
        return new Vec3(this.x-other.x, this.y-other.y, this.z-other.z);
    }
    public Vec3 mul(double factor){
        return new Vec3(this.x*factor, this.y*factor, this.z*factor);
    }
    
    public Vec3 cross(Vec3 other){
        Vec3 newVec = new Vec3();
        newVec.x = this.y * other.z - other.y * this.z;
        newVec.y = this.z * other.x - other.z * this.x;
        newVec.z = this.x * other.y - other.x * this.y;
        return newVec;
    }
    
    public double dot(Vec3 other){
        return this.x*other.x + this.y*other.y + this.z*other.z;
    }
    
    public static Vec3 inverse(Vec3 vec){
        return vec.inverse();
    }
    
    public static double magnitude(Vec3 vec){
        return vec.magnitude();
    }
    
    public static Vec3 unit(Vec3 vec){
        return vec.unit();
    }
    
    public static Vec3 normalize(Vec3 vec){
        return vec.unit();
    }
    
    public static Vec3 add(Vec3 vecA, Vec3 vecB){
        return vecA.add(vecB);
    }
    
    public static Vec3 sub(Vec3 vecA, Vec3 vecB){
        return vecA.sub(vecB);
    }
    
    public static Vec3 cross(Vec3 vecA, Vec3 vecB){
        return vecA.cross(vecB);
    }
    
    public static double dot(Vec3 vecA , Vec3 vecB){
        return vecA.dot(vecB);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vec3 other = (Vec3) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
            return false;
        }
        return true;
    }
    
   @Override
   public String toString(){
       return this.x + " "+this.y+ " "+this.z;
   }
}
