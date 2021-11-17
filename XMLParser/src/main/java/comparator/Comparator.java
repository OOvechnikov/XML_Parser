package comparator;

import args.ArgsStorage;

public abstract class Comparator {

    ArgsStorage argsStorage;


    public abstract boolean compare(String fileName);
}
