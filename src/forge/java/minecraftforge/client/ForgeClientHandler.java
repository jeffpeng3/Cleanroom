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

import minecraftforge.client.event.ColorHandlerEvent;
import minecraftforge.client.event.ModelRegistryEvent;
import minecraftforge.client.model.ModelLoader;
import minecraftforge.common.ForgeModContainer;
import minecraftforge.fluids.FluidRegistry;
import minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ForgeClientHandler
{
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        // register model for the universal bucket, if it exists
        if (FluidRegistry.isUniversalBucketEnabled())
        {
            ModelLoader.setBucketModelDefinition(ForgeModContainer.getInstance().universalBucket);
        }
    }

    @SubscribeEvent
    public static void registerItemHandlers(ColorHandlerEvent.Item event)
    {
        if (FluidRegistry.isUniversalBucketEnabled())
        {
            event.getItemColors().registerItemColorHandler(new FluidContainerColorer(), ForgeModContainer.getInstance().universalBucket);
        }
    }
}