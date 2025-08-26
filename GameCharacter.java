abstract class GameCharacter {
    String name;
    int maxHealth;
    int currentHealth;
    int baseDamage;

    public GameCharacter(String name) {
        this.name = name;
    }

    // Abstract methods (must be implemented by subclasses)
    public abstract String attack();
    public abstract String specialMove();

    // Concrete method
    public void showName() {
        System.out.println("Character: " + name);
    }

    public int getMaxHealth() { return maxHealth; }
    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }

    public int getCurrentHealth() { return currentHealth; }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        if (currentHealth > maxHealth) {
            this.currentHealth = maxHealth;
        }
    }

    public int getBaseDamage() { return baseDamage; }
    public void setBaseDamage(int baseDamage) { this.baseDamage = baseDamage; }

    public void damage(int damageAmount) {
        this.currentHealth -= damageAmount;
        if (currentHealth < 0) {
            this.currentHealth = 0;
        }
    }

    public void heal(int healAmount) {
        this.currentHealth += healAmount;
        if (currentHealth > maxHealth) {
            this.currentHealth = maxHealth;
        }
    }
}
