package ch3.lambdaReview;

public class Apple {

    private final String weight;

    private Apple(String weight){
        this.weight = weight;
    }

    public static Apple formApple(String weight){
        return new Apple(weight);
    }

    public String showWeightInfo(){
        return weight;
    }
}
