package comparator;

import args.ArgsStorage;

public abstract class Comparator {

    private ArgsStorage argsStorage;


    public Comparator() {
    }

    public Comparator(ArgsStorage argsStorage) {
        this.argsStorage = argsStorage;
    }


    public abstract boolean compare(String fileName);

    public ArgsStorage getArgsStorage() {
        return argsStorage;
    }
}
