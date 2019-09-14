package com.lalit.designPattern.strategy;

public interface CompressionStrategy {
    public byte[] execute(String content);
    public String handles();
}
