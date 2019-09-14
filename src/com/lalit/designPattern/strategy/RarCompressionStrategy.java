package com.lalit.designPattern.strategy;

public class RarCompressionStrategy implements CompressionStrategy {


    @Override
    public byte[] execute(String content) {
        System.out.println("Performing RAR Compression Strategy");
        return new byte[]{};
    }

    @Override
    public String handles() {
        return CompressionTechniquesEnum.RAR.name();
    }
}
