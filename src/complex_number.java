class complex_number {
    private double real;
    private double image;
    complex_number(double real, double image) {
        this.real = real;
        this.image = image;
    }
    public complex_number add(complex_number other) {
        return new complex_number(this.real + other.real, this.image + other.image);
    }
    public complex_number multiply(complex_number other){
        return new complex_number(this.real* other.real - this.image*other.image, this.real*other.image + this.image*other.real);
    }
    public complex_number subtract (complex_number other) {
        return new complex_number(this.real - other.real, this.image - other.image);
    }
    public complex_number divide (complex_number other) {
        double denom = other.real * other.real + other.image* other.image;
        double newReal = (this.real * other.real + this.image * other.image) / denom;
        double newImage = (this.image * other.real - this.real * other.image) / denom;
        return new complex_number(newReal, newImage);
    }
    @Override
    public String toString() {
        if (image >= 0) {
            return real + "+" + image + "i";
        } else {
            return real + "-" + Math.abs(image) + "i";
        }
    }




}