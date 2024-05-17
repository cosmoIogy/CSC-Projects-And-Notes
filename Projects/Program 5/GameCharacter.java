public class GameCharacter {
    // Private instance variables
    private String name;
    private int lives;
    private String[] inventory;
    private static int MAXLIVES = 5;

    // Default constructor
    public GameCharacter() {
        this.name = "Sam Sung";
        this.lives = MAXLIVES;
        this.inventory = new String[5];
    }

    // Overloaded constructor
    public GameCharacter(String name, int lives) {
        this.name = name;
        this.lives = Math.min(lives, MAXLIVES); // Ensure lives do not exceed MAXLIVES
        this.inventory = new String[5];
    }

    // Accessors and Mutators
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        if (lives >= 0 && lives <= MAXLIVES) {
            this.lives = lives;
        }
    }

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory){
        if (inventory.length >= 0 && inventory.length <= 5){
            this.inventory = inventory;
        }
    }

    // Check if the character is alive
    public boolean isAlive(){
        return lives > 0;
    }

    // Check if the character has a weapon
    public boolean hasWeapon() {
        for (String item : inventory) {
            if ("knife".equals(item) || "gun".equals(item)) {
                return true;
            }
        }
        return false;
    }

    // Get the size of the inventory
    public int sizeOfInventory() {
        int count = 0;
        for (String item : inventory) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }

    // Heal the character
    public void heal() {
        this.lives = MAXLIVES;
    }

    // Damage the character
    public void damage() {
        if (isAlive()) {
            this.lives--;
        }
    }

    // Pick up an item
    public void pickUp(String item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                return; // Exit after adding the item
            }
        }
    }

    // Drop an item
    public void drop(String item) {
        for (int i = 0; i < inventory.length; i++) {
            if (item.equals(inventory[i])) {
                inventory[i] = null;
                return; // Exit after dropping the item
            }
        }
    }

    // String representation of the GameCharacter
    @Override
    public String toString() {
        StringBuilder inventoryList = new StringBuilder();
        for (String item : inventory) {
            if (item != null) {
                if (inventoryList.length() > 0) {
                    inventoryList.append(", ");
                }
                inventoryList.append(item);
            }
        }
        return "Name: " + name + "\nLives: " + lives + "\nInventory: [" + inventoryList.toString() + "]" + "\n";
    }

}
    
