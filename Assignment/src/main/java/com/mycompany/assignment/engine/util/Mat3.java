package engine.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adam
 */
public class Mat3 {
    
    public double a11, a12, a13,
            a21, a22, a23,
            a31, a32, a33;

    public Mat3(double a11, double a12, double a13,
            double a21, double a22, double a23,
            double a31, double a32, double a33) {
        this.a11 = a11;
        this.a12 = a12;
        this.a13 = a13;
        this.a21 = a21;
        this.a22 = a22;
        this.a23 = a23;
        this.a31 = a31;
        this.a32 = a32;
        this.a33 = a33;
    }
     
    public Mat3(Vec3 a1, Vec3 a2, Vec3 a3){
        this(a1.x, a1.y, a1.z, a2.x, a2.y, a2.z, a3.x, a3.y, a3.z);
    }
    
    public Mat3(Mat4 mat){
        this(mat.a11, mat.a12, mat.a13,
            mat.a21, mat.a22, mat.a23,
            mat.a31, mat.a32, mat.a33);
    }
    
    private Mat3(){
        
    }
    
    public static Mat3 identity(){
        return new Mat3(1,0,0,
                        0,1,0,
                        0,0,1);
    }
    
    public Mat3 add(Mat3 other){
        return new Mat3(this.a11 +other.a11, this.a12 +other.a12,this.a13 +other.a13,
        this.a21 +other.a21,this.a22 +other.a22,this.a23 +other.a23,
        this.a31 +other.a31,this.a32 +other.a32,this.a33 +other.a33);
    }
    
    public Mat3 sub(Mat3 other){
        return new Mat3(this.a11 - other.a11, this.a12 - other.a12,this.a13 - other.a13,
        this.a21 - other.a21,this.a22 - other.a22,this.a23 - other.a23,
        this.a31 - other.a31,this.a32 - other.a32,this.a33 - other.a33);
    }
    
    public Mat3 mul(Mat3 other){
        return new Mat3(this.a11*other.a11 + this.a12*other.a21 + this.a13*other.a31,
                this.a11*other.a12 + this.a12*other.a22 + this.a13*other.a32,
                this.a11*other.a13 + this.a12*other.a23 + this.a13*other.a33,
                
                this.a21*other.a11 + this.a22*other.a21 + this.a23*other.a31,
                this.a21*other.a12 + this.a22*other.a22 + this.a23*other.a32,
                this.a21*other.a13 + this.a22*other.a23 + this.a23*other.a33,
                
                this.a31*other.a11 + this.a32*other.a21 + this.a33*other.a31,
                this.a31*other.a12 + this.a32*other.a22 + this.a33*other.a32,
                this.a31*other.a13 + this.a32*other.a23 + this.a33*other.a33);
    }
    
    public Mat3 transpone(){
        return new Mat3(this.a11, this.a21, this.a31,
                this.a12, this.a22, this.a32,
                this.a13, this.a23, this.a33);
    }
    
    public Mat3 inverse(){
        double det = this.det();
        if(det != 0){
            return this.transpone().adj().div(det);
        }else{
            return this;
        }
    }
        
    public double det(){
        return (this.a11*this.a22*this.a33+this.a12*this.a23*this.a31+this.a13*this.a21*this.a32
                -this.a13*this.a22*this.a31-this.a12*this.a21*this.a33-this.a11*this.a23*this.a32);
    }
    
    public static Mat3 add(Mat3 mat1, Mat3 mat2){
        return mat1.add(mat2);
    }
    
    public static Mat3 sub(Mat3 mat1, Mat3 mat2){
        return mat1.sub(mat2);
    }
    
    public static Mat3 mul(Mat3 mat1, Mat3 mat2){
        return mat1.mul(mat2);
    }
    
    public static  Mat3 transpone(Mat3 mat){
        return mat.transpone();
    }
    
    public static Mat3 inverse(Mat3 mat){
        return mat.inverse();
    }
        
    public static double det(Mat3 mat){
        return mat.det();
    }
    
    private double det2(double a11, double a12, double a21, double a22){
        return (a11*a22-a12*a21);
    }
    
    private Mat3 adj(){
        return new Mat3(det2(this.a22, this.a23, this.a32, this.a33), -det2(this.a21, this.a23, this.a31, this.a33), det2(this.a21, this.a22, this.a31, this.a32), 
                        -det2(this.a12, this.a13, this.a32, this.a33), det2(this.a11, this.a13, this.a31, this.a33), -det2(this.a11, this.a12, this.a31, this.a32), 
                        det2(this.a12, this.a13, this.a22, this.a23), -det2(this.a11, this.a13, this.a21, this.a23), det2(this.a11, this.a12, this.a21, this.a22));
    }
    
    private Mat3 div(double factor){
        return new Mat3(this.a11/factor, this.a12/factor, this.a13/factor,
                this.a21/factor, this.a22/factor, this.a23/factor,
                this.a31/factor, this.a32/factor, this.a33/factor);
    }
    
    public double[][] toArray(){
        return new double[][]{{a11,a12,a13},{a21,a22,a23},{a31,a32,a33}};
    }
    
    public String toString(){
        return this.a11+" "+this.a12+" "+this.a13+"\n"+
                this.a21+" "+this.a22+" "+this.a23+"\n"+
                this.a31+" "+this.a32+" "+this.a33+"\n";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.a11) ^ (Double.doubleToLongBits(this.a11) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.a12) ^ (Double.doubleToLongBits(this.a12) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.a13) ^ (Double.doubleToLongBits(this.a13) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.a21) ^ (Double.doubleToLongBits(this.a21) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.a22) ^ (Double.doubleToLongBits(this.a22) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.a23) ^ (Double.doubleToLongBits(this.a23) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.a31) ^ (Double.doubleToLongBits(this.a31) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.a32) ^ (Double.doubleToLongBits(this.a32) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.a33) ^ (Double.doubleToLongBits(this.a33) >>> 32));
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
        final Mat3 other = (Mat3) obj;
        if (Double.doubleToLongBits(this.a11) != Double.doubleToLongBits(other.a11)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a12) != Double.doubleToLongBits(other.a12)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a13) != Double.doubleToLongBits(other.a13)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a21) != Double.doubleToLongBits(other.a21)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a22) != Double.doubleToLongBits(other.a22)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a23) != Double.doubleToLongBits(other.a23)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a31) != Double.doubleToLongBits(other.a31)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a32) != Double.doubleToLongBits(other.a32)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a33) != Double.doubleToLongBits(other.a33)) {
            return false;
        }
        return true;
    }
    
}
