package top.shadowless.client.mod;

public abstract class Mod {
    private final String name;
    private final Category category;
    private boolean enable;
    private int key;

    public Mod(String name, Category category , boolean enable) {
        this.name = name;
        this.category = category;
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;

        if (enable) {
            enable();
        } else {
            disable();
        }
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Category getCategory() {
        return category;
    }

    public void enable() {

    }

    public void disable() {

    }

    public void draw() {

    }

    public void render() {

    }

    public void update() {

    }

    public void key(int key) {

    }

}
