package DesignPatterns.builder;

public class TestBuilderPattern {
    public static void main(String ar[]) {
        Computer computer = new Computer.ComputerBuilder("hi","bye").setGraphicsCardEnabled(true).build();
        computer.isBluetoothEnabled();
    }
}
