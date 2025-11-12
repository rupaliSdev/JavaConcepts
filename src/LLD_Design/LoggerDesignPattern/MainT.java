package LLD_Design.LoggerDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class MainT {
    public static void main(String[] args) {
        //info -> debug ->error
        LogProcessor logProcessor=
                new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcessor.log(LogProcessor.ERROR,"exception happens");
        logProcessor.log(LogProcessor.INFO,"info happens");
        logProcessor.log(LogProcessor.DEBUG,"debug happens");

    }
}
