package mainPart;

import java.io.Serializable;
import java.util.*;
import collection.Ticket;
import commands.*;
import exceptions.*;

/**
 * Commands decoder class that which processes incoming commands and controls collection
 */
public class CommandDecoder implements Serializable {
    /**hash map with all commands and their classes*/
    private final LinkedHashMap<String, Command> commands = new LinkedHashMap<>();
    /**collection of tickets*/
    private final LinkedList<Ticket> c;


    /**
     * Constructor without parameters
     */
    public CommandDecoder() {
        c = new LinkedList<>();
        addCommands();
    }

    /**
     * Constructor with parameter
     * @param c - collection of tickets
     */
    public CommandDecoder(LinkedList<Ticket> c) {
        this.c = c;
        addCommands();
    }

    /**
     * Put commands to the hash map
     */
    private void addCommands() {
        commands.put("help", new HelpCommand(commands));
        commands.put("info", new InfoCommand(c));
        commands.put("show", new ShowCommand(c));
        commands.put("add", new AddCommand(c));
        commands.put("update", new UpdateCommand(c));
        commands.put("remove_by_id", new RemoveByIdCommand(c));
        commands.put("clear", new ClearCommand(c));
        commands.put("execute_script", new ExecuteScriptCommand(c));
        commands.put("remove_head", new RemoveHeadCommand(c));
        commands.put("add_if_max", new AddIfMaxCommand(c));
        commands.put("remove_greater", new RemoveGreaterCommand(c));
        commands.put("sum_of_price", new SumOfPriceCommand(c));
        commands.put("filter_greater_than_price", new FilterGreaterThanPriceCommand(c));
        commands.put("print_field_descending_type", new PrintFieldDescendingTypeCommand(c));
    }

    /**
     * Command decoder
     * @param com - incoming command
     */
    public Command decode(String com) {

            String[] s, s1;
            com = com.trim();
            s = com.split(" ");
            s1 = com.split("\t");
            if (s1.length > s.length) s = s1;
            if (s.length == 0) throw new NullPointerException();
            if (!s[0].equals("exit")) {
                int countOfArguments = s.length - 1;
                Command cd = commands.get(s[0].toLowerCase());
                    if (cd.correctCountOfArguments(countOfArguments))  {
                        if (countOfArguments == 1) {
                            ((CommandWithAdditionalArgument) cd).addArgument(s[1]);
                        }
                        return cd;
                    } else throw new IllegalCountOfArgumentsException();
            }
        return null;
    }

    /**
     * Collection of tickets sorter by price and id
     * @param c - collection of tickets
     */
    public static void sort(LinkedList<Ticket> c) {
        Comparator<Ticket> comparator = Comparator.comparing(Ticket::getPrice).thenComparing(Ticket::getId);
        c.sort(comparator);
    }

    /**
     * Getter {@link CommandDecoder#c}
     * @return collection of tickets
     */
    public LinkedList<Ticket> getCollection() {
        return c;
    }

}
