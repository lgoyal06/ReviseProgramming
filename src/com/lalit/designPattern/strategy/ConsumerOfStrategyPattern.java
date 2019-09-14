package com.lalit.designPattern.strategy;

import java.util.ArrayList;
import java.util.List;

public class ConsumerOfStrategyPattern {

    public static void main(String... s) throws Exception{
        List<CompressionStrategy> compressionStrategyList = new ArrayList<>();
        compressionStrategyList.add(new ZipCompressionStrategy());
        compressionStrategyList.add(new RarCompressionStrategy());
        CompressionServiceProvider csp = new CompressionServiceProvider();
        csp.setCompressionStrategies(compressionStrategyList);
        csp.compress("Test", "Other");
    }
}
