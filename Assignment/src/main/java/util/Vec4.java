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
public class Vec4 {
 
    public double x;
    public double y;
    public double z;
    public double w;
    
    private Vec4(){
    }
    
    public Vec4(Vec4 vec){
        this(vec.x, vec.y, vec.z, vec.w);
    }
    
    public Vec4(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
        this.w=1;
    }
    
    public Vec4(double x, double y, double z, double w){
        this.x=x;
        this.y=y;
        this.z=z;
        this.w=w;
    }
    
    public Vec4(Vec3 vec){
        this.x=vec.x;
        this.y=vec.y;
        this.z=vec.z;
        this.w=1;
    }
    
    public static Vec4 zero(){
        return new Vec4(0,0,0,0);
    }
    
    public static Vec4 one(){
        return new Vec4(1,1,1);
    }
    
    public static Vec4 right(){
        return new Vec4(1,0,0);
    }
    
    public static Vec4 left(){
        return new Vec4(-1,0,0);
    }
    
    public static Vec4 up(){
        return new Vec4(0,1,0);
    }
    
    public static Vec4 down(){
        return new Vec4(0,-1,0);
    }
    
    public static Vec4 back(){
        return new Vec4(0,0,1);
    }
    
    public static Vec4 forward(){
        return new Vec4(0,0,-1);
    }
    
    public Vec4 inverse(){
        return new Vec4(-this.x, -this.y, -this.z, this.w);
    }
    
    public double magnitude(){
        return Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2)+Math.pow(this.z, 2)+Math.pow(this.w, 2));
    }
    
    public double length(){
        return this.magnitude();
    }
    
    public Vec4 unit(){
        return new Vec4(this.x/this.magnitude(), this.y/this.magnitude(), this.z/this.magnitude(), this.w);
    }
    
    public Vec4 normalize(){
        return this.unit();
    }
    
    public Vec4 add(Vec4 other){
        return new Vec4(this.x+other.x, this.y+other.y, this.z+other.z, this.w);
    }
    public Vec4 sub(Vec4 other){
        return new Vec4(this.x-other.x, this.y-other.y, this.z-other.z, this.w);
    }
    public Vec4 mul(double factor){
        return new Vec4(this.x*factor, this.y*factor, this.z*factor, this.w);
    }
    
    public Vec4 cross(Vec4 other){
        Vec4 newVec = new Vec4();
        newVec.x = this.y * other.z - other.y * this.z;
        newVec.y = this.z * other.x - other.z * this.x;
        newVec.z = this.x * other.y - other.x * this.y;
        newVec.w = this.w;
        return newVec;
    }
    
    public double dot(Vec4 other){
        return this.x*other.x + this.y*other.y + this.z*other.z;
    }
    
    public static Vec4 inverse(Vec4 vec){
        return vec.inverse();
    }
    
    public static double magnitude(Vec4 vec){
        return vec.magnitude();
    }
    
    public static Vec4 unit(Vec4 vec){
        return vec.unit();
    }
    
    public static Vec4 normalize(Vec4 vec){
        return vec.unit();
    }
    
    public static Vec4 add(Vec4 vecA, Vec4 vecB){
        return vecA.add(vecB);
    }
    
    public static Vec4 sub(Vec4 vecA, Vec4 vecB){
        return vecA.sub(vecB);
    }
    
    public static Vec4 cross(Vec4 vecA, Vec4 vecB){
        return vecA.cross(vecB);
    }
    
    public static double dot(Vec4 vecA , Vec4 vecB){
        return vecA.dot(vecB);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.w) ^ (Double.doubleToLongBits(this.w) >>> 32));
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
        final Vec4 other = (Vec4) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
            return false;
        }
        if (Double.doubleToLongBits(this.w) != Double.doubleToLongBits(other.w)) {
            return false;
        }
        return true;
    }
    
    
    
   @Override
   public String toString(){
       return this.x + " "+this.y+ " "+this.z;
   }
}
