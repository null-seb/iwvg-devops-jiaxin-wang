package es.upm.miw.iwvg_devops.code;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {

    private int numerator;//分子

    private int denominator;//分母

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper(int numerator,int denominator){
        if (denominator>numerator){
            return true;
        }else {
            return false;
        }
    }

    public boolean isImproper(int numerator,int denominator){
        if (numerator>denominator){
            return true;
        }
        else {
            return false;
        }
    }

    public  boolean isEquivalent(int numerator,int denominator){
        if (numerator==denominator){
            return true;
        }else {
            return false;
        }

    }

    public Fraction add(Fraction summand){
        if (this.denominator%summand.getDenominator()==0) {
            summand.setNumerator(summand.getNumerator() * (this.denominator / summand.getDenominator()));
            summand.setDenominator(this.denominator);
        }else if(summand.getDenominator()%this.denominator==0){
            this.setNumerator(summand.numerator * (summand.getDenominator() / this.denominator));
            this.setDenominator(summand.denominator);
        }
        else{
            int tmp = this.denominator;

            this.setDenominator(this.denominator * summand.getDenominator());
            this.setNumerator(this.numerator * summand.getDenominator());

            summand.setDenominator(tmp * summand.getDenominator());
            summand.setNumerator(tmp * summand.getNumerator());
        }
        return new Fraction(this.numerator + summand.getNumerator(), this.denominator);
    }

    public Fraction multiply(Fraction multiplier){
        Fraction temp=new Fraction((this.numerator*multiplier.numerator),(this.denominator*multiplier.denominator));
        return temp;
    }

    public Fraction divide(Fraction divisor){
        Fraction temp=new Fraction((this.numerator*divisor.denominator),(this.denominator*divisor.numerator));
        return temp;
    }
    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}

