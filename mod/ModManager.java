package top.shadowless.client.mod;

import top.shadowless.client.mod.mods.movement.HUD;
import top.shadowless.client.mod.mods.movement.SprintMod;
import top.shadowless.client.mod.mods.movement.betterfps.BetterFps;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModManager {
    private final List<Mod> mods = new ArrayList<>();

    public List<Mod> getMods() {
        return mods;
    }

    public List<Mod> getEnableMods() {
        return mods.stream().filter(Mod::isEnable).collect(Collectors.toList());
    }

    public void onKey(int key) {
        for (Mod enableMod : mods) {
            if (enableMod.getKey() == key) {
                enableMod.setEnable(!enableMod.isEnable());
            }
        }
    }

    public void load() {
        mods.add(new HUD());
        mods.add(new SprintMod());
        mods.add(new BetterFps());
    }

    public Mod getByName(String name) {
        for (Mod mod : mods) {
            if (name.equalsIgnoreCase(mod.getName())) {
                return mod;
            }
        }
        return null;
    }

    public Mod getByClass(Class<? extends Mod> modClass) {
        for (Mod mod : mods) {
            if (mod.getClass() == modClass) {
                return mod;
            }
        }
        return null;
    }

    public List<Mod> getByCategory(Category category) {
        return mods.stream().filter(m -> m.getCategory() == category).collect(Collectors.toList());
    }
}
