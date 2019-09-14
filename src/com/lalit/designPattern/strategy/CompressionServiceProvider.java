package com.lalit.designPattern.strategy;

import java.util.List;

public class CompressionServiceProvider {

    public List<CompressionStrategy> getCompressionStrategies() {
        return compressionStrategies;
    }

    public void setCompressionStrategies(List<CompressionStrategy> compressionStrategies) {
        this.compressionStrategies = compressionStrategies;
    }

    public List<CompressionStrategy> compressionStrategies;

    public byte[] compress(String content, String compressionTechnique) throws Exception{
        for (CompressionStrategy cs: compressionStrategies) {
            if(compressionTechnique.equalsIgnoreCase(cs.handles())){
                return cs.execute(content);
            }
        }
        throw new Exception("No matching Compression Technique found");
    }
}