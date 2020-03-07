package com.lalit.reactive.programming;

public class Client {

    public static void main(String... s) {

        System.out.println(MatchMeClass.matchMe(DemoLazyFunction.evaluateMe("one"), DemoLazyFunction.evaluateMe("one")));
        System.out.println(MatchMeClass_new.matchMe(() -> DemoLazyFunction.evaluateMe("6"), () -> DemoLazyFunction.evaluateMe("d5454fde")));
        ShowLength showLength = new ShowLength();
        showLength.show(1000);

        ShowLength_New showLength_new = new ShowLength_New();
        LengthConverter lengthConverter = new LengthConverter();
        showLength_new.show(1000, lengthConverter::toMeter);
    }
}
