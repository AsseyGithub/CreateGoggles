package com.robocraft999.creategoggles;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import org.apache.commons.lang3.tuple.Pair;

public class CGConfig {
    public static class Common{
        public final BooleanValue useCustomCurioGoggleSlot;
        public final BooleanValue useCustomCurioBacktankSlot;

        public final BooleanValue enableExperimentalFeatures;

        Common(ForgeConfigSpec.Builder builder){
            builder.comment("General configuration settings")
                    .push("general");

            useCustomCurioGoggleSlot = builder
                    .comment("Uses custom curio slot for goggles instead of the head slot")
                    .worldRestart()
                    .define("customCurioGoggleSlot", false);

            useCustomCurioBacktankSlot = builder
                    .comment("Uses custom curio slot for backtank instead of the back slot")
                    .worldRestart()
                    .define("customCurioBacktankSlot", false);

            enableExperimentalFeatures = builder
                    .comment("Enables experimental features")
                    .worldRestart()
                    .define("enableExperimentalFeatures", true);

            builder.pop();
        }
    }

    public static class Client{

        public final BooleanValue moveGoggleToEyes;

        Client(ForgeConfigSpec.Builder builder){
            builder.comment("Client configuration settings")
                    .push("general");

            moveGoggleToEyes = builder
                    .comment("Display the goggles before the eyes and not on the forehead")
                    .define("moveGoggleToEyes", false);
        }
    }

    public static final ForgeConfigSpec commonSpec;
    public static final Common COMMON;
    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        commonSpec = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static final ForgeConfigSpec clientSpec;
    public static final Client CLIENT;
    static{
        final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
        clientSpec = specPair.getRight();
        CLIENT = specPair.getLeft();
    }
}
