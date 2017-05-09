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
public class Mat4 {
    
    public double a11, a12, a13, a14,
            a21, a22, a23, a24,
            a31, a32, a33, a34,
            a41, a42, a43, a44;
 
   public Mat4(double a11, double a12, double a13, double a14,
            double a21, double a22, double a23, double a24,
            double a31, double a32, double a33, double a34,
            double a41, double a42, double a43, double a44) {
        this.a11 = a11;
        this.a12 = a12;
        this.a13 = a13;
        this.a14 = a14;
        this.a21 = a21;
        this.a22 = a22;
        this.a23 = a23;
        this.a24 = a24;
        this.a31 = a31;
        this.a32 = a32;
        this.a33 = a33;
        this.a34 = a34;
        this.a41 = a41;
        this.a42 = a42;
        this.a43 = a43;
        this.a44 = a44;
    }
     
    public Mat4(Vec3 a1, Vec3 a2, Vec3 a3){
        this(a1.x, a1.y, a1.z,0, a2.x, a2.y, a2.z,0, a3.x, a3.y, a3.z,0,0,0,0,1);
    }
    
    public Mat4(Mat3 mat){
        this(mat.a11, mat.a12, mat.a13, 0,
                mat.a21, mat.a22, mat.a23, 0,
                mat.a31, mat.a32, mat.a33, 0,
                0,      0,      0,         1);
    }
    
    private Mat4(){
        
    }
    
    public static Mat4 identity(){
        return new Mat4(1,0,0,0,
                        0,1,0,0,
                        0,0,1,0,
                        0,0,0,1);
    }
    
    public Mat4 add(Mat4 other){
        return new Mat4(this.a11 +other.a11, this.a12 +other.a12,this.a13 +other.a13, this.a14+other.a14,
        this.a21 +other.a21,this.a22 +other.a22,this.a23 +other.a23, this.a24 +other.a24, 
        this.a31 +other.a31,this.a32 +other.a32,this.a33 +other.a33, this.a34 +other.a34, 
        this.a41 +other.a41,this.a42 +other.a42,this.a43 +other.a43, this.a44 +other.a44);
    }
    
    public Mat4 sub(Mat4 other){
        return new Mat4(this.a11 -other.a11, this.a12 -other.a12,this.a13 -other.a13, this.a14-other.a14,
        this.a21 -other.a21,this.a22 -other.a22,this.a23 -other.a23, this.a24 -other.a24, 
        this.a31 -other.a31,this.a32 -other.a32,this.a33 -other.a33, this.a34 -other.a34, 
        this.a41 -other.a41,this.a42 -other.a42,this.a43 -other.a43, this.a44 -other.a44);
    }
    
    public Mat4 mul(Mat4 other){
        return new Mat4(
                this.a11*other.a11 + this.a12*other.a21 + this.a13*other.a31 + this.a14*other.a41,
                this.a11*other.a12 + this.a12*other.a22 + this.a13*other.a32 + this.a14*other.a42,
                this.a11*other.a13 + this.a12*other.a23 + this.a13*other.a33 + this.a14*other.a43,
                this.a11*other.a14 + this.a12*other.a24 + this.a13*other.a34 + this.a14*other.a44,
                
                this.a21*other.a11 + this.a22*other.a21 + this.a23*other.a31 + this.a24*other.a41,
                this.a21*other.a12 + this.a22*other.a22 + this.a23*other.a32 + this.a24*other.a42,
                this.a21*other.a13 + this.a22*other.a23 + this.a23*other.a33 + this.a24*other.a43,
                this.a21*other.a14 + this.a22*other.a24 + this.a23*other.a34 + this.a24*other.a44,
                
                this.a31*other.a11 + this.a32*other.a21 + this.a33*other.a31 + this.a34*other.a41,
                this.a31*other.a12 + this.a32*other.a22 + this.a33*other.a32 + this.a34*other.a42,
                this.a31*other.a13 + this.a32*other.a23 + this.a33*other.a33 + this.a34*other.a43,
                this.a31*other.a14 + this.a32*other.a24 + this.a33*other.a34 + this.a34*other.a44,
                
                this.a41*other.a11 + this.a42*other.a21 + this.a43*other.a31 + this.a44*other.a41,
                this.a41*other.a12 + this.a42*other.a22 + this.a43*other.a32 + this.a44*other.a42,
                this.a41*other.a13 + this.a42*other.a23 + this.a43*other.a33 + this.a44*other.a43,
                this.a41*other.a14 + this.a42*other.a24 + this.a43*other.a34 + this.a44*other.a44
        );
    }
    
    public Mat4 scale(double x, double y, double z){
        return this.mul(new Mat4(
                x,  0,  0,  0,
                0,  y,  0,  0,
                0,  0,  z,  0,
                0,  0,  0,  1
        ));
    }
    
    public Mat4 translate(double x, double y, double z){
        return this.mul(new Mat4(
                1,  0,  0,  x,
                0,  1,  0,  y,
                0,  0,  1,  z,
                0,  0,  0,  1
        ));
    }
    
    public static Mat4 translate(Mat4 other, double x, double y, double z){
        return other.translate(x,y,z);
    }
    
    public static Mat4 rotate(Mat4 other, double x, double y, double z){
        return other.rotate(x,y,z);
    }
    
    public Mat4 rotate(double x, double y, double z){
        return this.mul(rotateX(x)).mul(rotateY(y)).mul(rotateZ(z));
    }
    
    private Mat4 rotateX(double rad){
        return new Mat4(
                1,              0,                      0,                  0,
                0,              Math.cos(rad),          -Math.sin(rad),     0,
                0,              Math.sin(rad),          Math.cos(rad),      0,
                0,              0,                      0,                  1
        );
    }
    private Mat4 rotateY(double rad){
        return new Mat4(
                Math.cos(rad),  0,                      Math.sin(rad),      0,
                0,              1,                      0,                  0,
                -Math.sin(rad), 0,                      Math.cos(rad),      0,
                0,              0,                      0,                  1
        );
    }
    private Mat4 rotateZ(double rad){
        return new Mat4(
                Math.cos(rad),  -Math.sin(rad),         0,                  0,
                Math.sin(rad),  Math.cos(rad),          0,                  0,
                0,              0,                      1,                  0,
                0,              0,                      0,                  1
        );
    }
    
    
    public Mat4 transpone(){
        return new Mat4(this.a11, this.a21, this.a31, this.a41,
                this.a12, this.a22, this.a32, this.a42,
                this.a13, this.a23, this.a33, this.a43,
                this.a14, this.a24, this.a34, this.a44);
    }
    /*
    public Mat4 inverse(){
        double det = this.det();
        if(det != 0){
            return this.transpone().adj().div(det);
        }else{
            return this;
        }
    }*/
        
    public double det(){
        return (this.a11*this.a22*this.a33+this.a12*this.a23*this.a31+this.a13*this.a21*this.a32
                -this.a13*this.a22*this.a31-this.a12*this.a21*this.a33-this.a11*this.a23*this.a32);
    }
    
    public static Mat4 add(Mat4 mat1, Mat4 mat2){
        return mat1.add(mat2);
    }
    
    public static Mat4 sub(Mat4 mat1, Mat4 mat2){
        return mat1.sub(mat2);
    }
    /*
    public static Mat4 mul(Mat4 mat1, Mat4 mat2){
        return new Mat4(mat1.a11*mat2.a11 + mat1.a12*mat2.a21 + mat1.a13*mat2.a31,
                mat1.a11*mat2.a12 + mat1.a12*mat2.a22 + mat1.a13*mat2.a32,
                mat1.a11*mat2.a13 + mat1.a12*mat2.a23 + mat1.a13*mat2.a33,
                
                mat1.a21*mat2.a11 + mat1.a22*mat2.a21 + mat1.a23*mat2.a31,
                mat1.a21*mat2.a12 + mat1.a22*mat2.a22 + mat1.a23*mat2.a32,
                mat1.a21*mat2.a13 + mat1.a22*mat2.a23 + mat1.a23*mat2.a33,
                
                mat1.a31*mat2.a11 + mat1.a32*mat2.a21 + mat1.a33*mat2.a31,
                mat1.a31*mat2.a12 + mat1.a32*mat2.a22 + mat1.a33*mat2.a32,
                mat1.a31*mat2.a13 + mat1.a32*mat2.a23 + mat1.a33*mat2.a33);
    }*/
    
    public static  Mat4 transpone(Mat4 mat){
        return mat.transpone();
    }
    /*
    public static Mat4 inverse(Mat4 mat){
        return mat.inverse();
    }*/
        
    public static double det(Mat4 mat){
        return mat.det();
    }
    
    private double det2(double a11, double a12, double a21, double a22){
        return (a11*a22-a12*a21);
    }
    
    private double det3(double a11, double a12, double a13, double a21, double a22, double a23, double a31, double a32, double a33){
        return (a11*a22*a33+a12*a23*a31+a13*a21*a32
                -a13*a22*a31-a12*a21*a33-a11*a23*a32);
    }
    /*
    private Mat4 adj(){
        return new Mat4(det2(this.a22, this.a23, this.a32, this.a33), -det2(this.a21, this.a23, this.a31, this.a33), det2(this.a21, this.a22, this.a31, this.a32), 
                        -det2(this.a12, this.a13, this.a32, this.a33), det2(this.a11, this.a13, this.a31, this.a33), -det2(this.a11, this.a12, this.a31, this.a32), 
                        det2(this.a12, this.a13, this.a22, this.a23), -det2(this.a11, this.a13, this.a21, this.a23), det2(this.a11, this.a12, this.a21, this.a22));
    }
    
    private Mat4 div(double factor){
        return new Mat4(this.a11/factor, this.a12/factor, this.a13/factor,
                this.a21/factor, this.a22/factor, this.a23/factor,
                this.a31/factor, this.a32/factor, this.a33/factor);
    }*/
    
    public double[][] toArray(){
        return new double[][]{{a11,a12,a13,a14},{a21,a22,a23,a24},{a31,a32,a33,a34},{a41,a42,a43,a44}};
    }
    
    public String toString(){
        return this.a11+" "+this.a12+" "+this.a13+" "+this.a14+"\n"+
                this.a21+" "+this.a22+" "+this.a23+" "+this.a24+"\n"+
                this.a31+" "+this.a32+" "+this.a33+" "+this.a34+"\n"+
                this.a41+" "+this.a42+" "+this.a43+" "+this.a44+"\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a11) ^ (Double.doubleToLongBits(this.a11) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a12) ^ (Double.doubleToLongBits(this.a12) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a13) ^ (Double.doubleToLongBits(this.a13) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a14) ^ (Double.doubleToLongBits(this.a14) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a21) ^ (Double.doubleToLongBits(this.a21) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a22) ^ (Double.doubleToLongBits(this.a22) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a23) ^ (Double.doubleToLongBits(this.a23) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a24) ^ (Double.doubleToLongBits(this.a24) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a31) ^ (Double.doubleToLongBits(this.a31) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a32) ^ (Double.doubleToLongBits(this.a32) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a33) ^ (Double.doubleToLongBits(this.a33) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a34) ^ (Double.doubleToLongBits(this.a34) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a41) ^ (Double.doubleToLongBits(this.a41) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a42) ^ (Double.doubleToLongBits(this.a42) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a43) ^ (Double.doubleToLongBits(this.a43) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.a44) ^ (Double.doubleToLongBits(this.a44) >>> 32));
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
        final Mat4 other = (Mat4) obj;
        if (Double.doubleToLongBits(this.a11) != Double.doubleToLongBits(other.a11)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a12) != Double.doubleToLongBits(other.a12)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a13) != Double.doubleToLongBits(other.a13)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a14) != Double.doubleToLongBits(other.a14)) {
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
        if (Double.doubleToLongBits(this.a24) != Double.doubleToLongBits(other.a24)) {
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
        if (Double.doubleToLongBits(this.a34) != Double.doubleToLongBits(other.a34)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a41) != Double.doubleToLongBits(other.a41)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a42) != Double.doubleToLongBits(other.a42)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a43) != Double.doubleToLongBits(other.a43)) {
            return false;
        }
        if (Double.doubleToLongBits(this.a44) != Double.doubleToLongBits(other.a44)) {
            return false;
        }
        return true;
    }
}
