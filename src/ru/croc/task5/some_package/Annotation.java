package ru.croc.task5.some_package;

public class Annotation {
    private Figure figure;
    private String label;
    public Figure getFigure(){
        return figure;
    }
    public String getLabel(){
        return label;
    }
    public Annotation(Figure figure , String label){
        this.figure = figure;
        this.label = label;
    }
    public static Annotation  findByPoint(Annotation[] annotations, int x, int y){

            for(Annotation annotation : annotations){
                if(annotation.getFigure().existenceOfPoint(x , y)){
                    return annotation;
                }
            }
            return null; // на эту строчку мы попадём в случае, если никакая фигура не содержит заданной точки, тогда возвращаем нулевую ссылку
    }
    public  static Annotation findByLabel(Annotation[] annotations , String label){
        for(Annotation annotation : annotations){
            if(annotation.getLabel().contains(label)){
                return annotation;
            }
        }
        return null; // на эту строчку мы попадём в случае, если никакая фигура в своей подписи не содержит подстроки label, тогда возвращаем нулевую ссылку
    }
    @Override
    public String toString(){
        return figure.toString() + ": " + label;
    }
}
