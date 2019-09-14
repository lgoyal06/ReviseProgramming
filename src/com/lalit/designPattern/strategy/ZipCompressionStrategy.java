package com.lalit.designPattern.strategy;

public class ZipCompressionStrategy implements CompressionStrategy {


    @Override
    public byte[] execute(String content) {
        System.out.println("Performing Zip Compression Strategy");
        return new byte[]{};
    }

    @Override
    public String handles() {
        return CompressionTechniquesEnum.ZIP.name();
    }
}
