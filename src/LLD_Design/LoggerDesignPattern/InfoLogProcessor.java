package LLD_Design.LoggerDesignPattern;

public class InfoLogProcessor extends LogProcessor{

    public InfoLogProcessor(LogProcessor nextloggerProcessor) {
        super(nextloggerProcessor);
    }
}
