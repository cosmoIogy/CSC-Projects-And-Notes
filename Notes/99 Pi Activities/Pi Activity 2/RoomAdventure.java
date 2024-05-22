import java.util.Scanner;

// Name: Blair Bourque
// Description: Room Adventure
// Improvements:
// 0. Added Room 4 and Room 5
// 1. Extra Room; Room 5
// 2. Extra actions; use and drop
// 3. A way to lose; if fire is used, then you die

public class RoomAdventure {

    private static Room currentRoom;
    private static String[] inventory = {null, null, null, null, null};
    private static String status;

    final private static String DEFAULT_STATUS = "Sorry, I don't understand. Try [verb] [noun].";
    
    public static void main(String[] args){
        setupGame();

        while (true){
            // Print info about game.
            System.out.println(currentRoom.toString());
            System.out.println("Inventory: ");
            for (int i=0; i < inventory.length; i++){
                System.out.print(inventory[i] + " ");
            }
            System.out.println("\nWhat would you like to do? ");

            // take input
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine(); // wait here for input

            // process input
            String[] words = input.split(" ");

            if (words.length != 2){
                status = DEFAULT_STATUS;
            } else {
                String verb = words[0];
                String noun = words[1];

                switch (verb){
                    case "go":
                        handleGo(noun);
                        break;
                    case "look":
                        handleLook(noun);
                        break;
                    case "take":
                        handleTake(noun);
                        break;
                    case "drop":
                        handleDrop(noun);
                        break;
                    case "use":
                        handleUse(noun);
                        break;
                    default: 
                        status = DEFAULT_STATUS;
                }
            }

            System.out.println(status);
        }
    }

    private static void handleGo(String noun){
        String[] exitDirections = currentRoom.getExitDirections();
        Room[] exitDestinations = currentRoom.getExitDestinations();
        status = "I don't see that exit.";
        for (int i = 0; i < exitDirections.length; i++){
            if (noun.equals(exitDirections[i])){
                currentRoom = exitDestinations[i];
                status = "Changed Room.";
                break;
            }
        }
    }

    private static void handleLook(String noun){
        String[] items = currentRoom.getItems();
        String[] itemDescriptions = currentRoom.getItemDescriptions();
        status = "I don't see that item.";
        for (int i = 0; i < items.length; i++){
            if (noun.equals(items[i])){
                status = itemDescriptions[i];
                break;
            }
        }
    }

    private static void handleTake(String noun){
        String[] grabbables = currentRoom.getGrabbables();
        status = "I can't grab that.";
        for (int i=0; i < grabbables.length; i++){
            if (noun.equals(grabbables[i])){
                for (int j = 0; j < inventory.length; j++){
                    if (inventory[j] == null){
                        inventory[j] = noun;
                        status = "Added it to the inventory";
                        break;
                    }
                }
                break;
            }
        }
    }

    private static void handleDrop(String noun){ // new action drop
        status = "You don't have that item.";
        for (int i = 0; i < inventory.length; i++){
            if (inventory[i] != null && inventory[i].equals(noun)){
                inventory[i] = null;
                status = "Dropped " + noun;
                break;
            }
        }
    }

    private static void handleUse(String noun){ // new action use
        status = "You can't use that.";
        for (int i = 0; i < inventory.length; i++){
            if (inventory[i] != null && inventory[i].equals(noun)){
                if (noun.equals("fire") && currentRoom.getName().equals("Room 4")){ // if fire is used then you die
                    status = "You burned yourself. Game Over.";
                    System.out.println(status);
                    System.exit(0);
                } else {
                    status = "Used " + noun;
                }
                break;
            }
        }
    }

    public static void setupGame(){
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        Room room3 = new Room("Room 3");
        Room room4 = new Room("Room 4");
        Room room5 = new Room("Room 5");

        // Setup Room 1
        String[] room1ExitDirections = {"east", "south"};
        Room[] room1ExitDestinations = {room2, room3};

        String[] room1Items = {"chair", "stool"};
        String[] room1ItemDescriptions = {
            "It is a chair.", 
            "It's like a chair. There is a key on it."
        };

        String[] room1Grabbables = {"key"};

        room1.setExitDirections(room1ExitDirections);
        room1.setExitDestinations(room1ExitDestinations);
        room1.setItems(room1Items);
        room1.setItemDescriptions(room1ItemDescriptions);
        room1.setGrabbables(room1Grabbables);

        // Setup Room 2
        String[] room2ExitDirections = {"west", "south"};
        Room[] room2ExitDestinations = {room1, room4};

        String[] room2Items = {"rug", "fireplace"};
        String[] room2ItemDescriptions = {
            "It's like a chair but flat. There is a satsuma on it.", 
            "It's hot."
        };

        String[] room2Grabbables = {"satsuma"};

        room2.setExitDirections(room2ExitDirections);
        room2.setExitDestinations(room2ExitDestinations);
        room2.setItems(room2Items);
        room2.setItemDescriptions(room2ItemDescriptions);
        room2.setGrabbables(room2Grabbables);

        // Setup Room 3
        String[] room3ExitDirections = {"north", "east"};
        Room[] room3ExitDestinations = {room1, room4};

        String[] room3Items = {"statue", "bookshelf"};
        String[] room3ItemDescriptions = {
            "It's the lady of the mist. A full-sized replica.", 
            "There is one book on it."
        };

        String[] room3Grabbables = {"book"};

        room3.setExitDirections(room3ExitDirections);
        room3.setExitDestinations(room3ExitDestinations);
        room3.setItems(room3Items);
        room3.setItemDescriptions(room3ItemDescriptions);
        room3.setGrabbables(room3Grabbables);

        // Setup Room 4
        String[] room4ExitDirections = {"north", "west", "south"};
        Room[] room4ExitDestinations = {room2, room3, room5};

        String[] room4Items = {"tiny josh coriell", "fire"};
        String[] room4ItemDescriptions = {
            "It's Josh Coriell, but he is tiny.", 
            "It is hot and fiery. There is fire circling around it. You can snatch it."
        };

        String[] room4Grabbables = {"fire"};

        room4.setExitDirections(room4ExitDirections);
        room4.setExitDestinations(room4ExitDestinations);
        room4.setItems(room4Items);
        room4.setItemDescriptions(room4ItemDescriptions);
        room4.setGrabbables(room4Grabbables);

        // Setup Room 5
        String[] room5ExitDirections = {"north"};
        Room[] room5ExitDestinations = {room4};

        String[] room5Items = {"brandon fortes", "adam guillory"};
        String[] room5ItemDescriptions = {
            "It's Brandon Fortes. He is clubbin'.", 
            "It is Adam Guillory. He is speaking words of nothingness."
        };

        String[] room5Grabbables = {"Brandon Fortes", "Adam Guillory"};

        room5.setExitDirections(room5ExitDirections);
        room5.setExitDestinations(room5ExitDestinations);
        room5.setItems(room5Items);
        room5.setItemDescriptions(room5ItemDescriptions);
        room5.setGrabbables(room5Grabbables);

        currentRoom = room1;
    }
}

class Room {

    private String name;
    private String[] exitDirections; // north, south, east, west
    private Room[] exitDestinations;
    private String[] items;
    private String[] itemDescriptions;
    private String[] grabbables;

    public Room(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setExitDirections(String[] exitDirections){
        this.exitDirections = exitDirections;
    }

    public String[] getExitDirections(){
        return this.exitDirections;
    }

    public void setExitDestinations(Room[] exitDestinations){
        this.exitDestinations = exitDestinations;
    }

    public Room[] getExitDestinations(){
        return exitDestinations;
    }

    public void setItems(String[] items){
        this.items = items;
    }

    public String[] getItems(){
        return items;
    }

    public void setItemDescriptions(String[] itemDescriptions){
        this.itemDescriptions = itemDescriptions;
    }

    public String[] getItemDescriptions(){
        return itemDescriptions;
    }

    public void setGrabbables(String[] grabbables){
        this.grabbables = grabbables;
    }

    public String[] getGrabbables(){
        return grabbables;
    }

    public String toString(){
        String result = "\n";
        result += "Location: " + name;

        // add items to the output
        result += "\nYou See: ";
        for (int i = 0; i < items.length; i++){
            result += items[i] + " ";
        }

        // add exits to the output
        result += "\nExits: ";
        for (int i = 0; i < exitDirections.length; i++){
            result += exitDirections[i] + " ";
        }

        return result;
    }
}