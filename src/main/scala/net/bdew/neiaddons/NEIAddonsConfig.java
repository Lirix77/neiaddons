/*
 * Copyright (c) bdew, 2013 - 2015 https://github.com/bdew/neiaddons This mod is distributed under the terms of the
 * Minecraft Mod Public License 1.0, or MMPL. Please check the contents of the license located in
 * http://bdew.net/minecraft-mod-public-license/
 */

package net.bdew.neiaddons;

import net.bdew.neiaddons.api.NEIAddon;

import codechicken.nei.api.IConfigureNEI;

public class NEIAddonsConfig implements IConfigureNEI {

    @Override
    public void loadConfig() {
        for (NEIAddon addon : NEIAddons.addons) {
            if (addon.isActive()) {
                try {
                    addon.loadClient();
                } catch (Throwable e) {
                    NEIAddons.logWarningExc(e, "Addon %s failed client initialization", addon.getName());
                }
            }
        }
    }

    @Override
    public String getName() {
        return "NEI Addons";
    }

    @Override
    public String getVersion() {
        return "NEIADDONS_VER";
    }
}
