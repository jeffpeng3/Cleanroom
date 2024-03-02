/*
 * Minecraft Forge
 * Copyright (c) 2016-2020.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package minecraftforge.client;

import com.cleanroommc.hackery.enums.EnumHackery;
import minecraftforge.common.util.EnumHelper;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.Util.EnumOS;
import net.minecraft.world.GameType;
import net.minecraft.client.settings.GameSettings.Options;

import javax.annotation.Nullable;

public class EnumHelperClient extends EnumHelper
{
    private static Class<?>[][] clientTypes =
    {
        {GameType.class, int.class, String.class, String.class},
        {Options.class, String.class, boolean.class, boolean.class},
        {EnumOS.class},
        {MusicTicker.MusicType.class, SoundEvent.class, int.class, int.class}
    };

    @Nullable
    public static GameType addGameType(String name, int id, String displayName, String shortName)
    {
        return EnumHackery.addEnumEntry(GameType.class, name,
                new Class<?>[] { int.class, String.class, String.class },
                new Object[] { id, displayName, shortName });
    }

    @Nullable
    public static Options addOptions(String name, String langName, boolean isSlider, boolean isToggle)
    {
        return EnumHackery.addEnumEntry(Options.class, name,
                new Class<?>[] { String.class, boolean.class, boolean.class },
                new Object[] { langName, isSlider, isToggle });
    }

    @Nullable
    public static Options addOptions(String name, String langName, boolean isSlider, boolean isToggle, float valMin, float valMax, float valStep)
    {
        return EnumHackery.addEnumEntry(Options.class, name,
                new Class<?>[] { String.class, boolean.class, boolean.class, float.class, float.class, float.class },
                new Object[] { langName, isSlider, isToggle, valMin, valMax, valStep });
    }

    @Nullable
    public static EnumOS addOS2(String name)
    {
        return EnumHackery.addEnumEntry(EnumOS.class, name);
    }

    @Nullable
    public static MusicTicker.MusicType addMusicType(String name, SoundEvent sound, int minDelay, int maxDelay)
    {
        return EnumHackery.addEnumEntry(MusicTicker.MusicType.class, name,
                new Class<?>[] { SoundEvent.class, int.class, int.class },
                new Object[] { sound, minDelay, maxDelay });
    }

}