package org.tyoda.wurm.Leadables;

import com.wurmonline.server.creatures.CreatureTemplate;
import com.wurmonline.server.creatures.CreatureTemplateFactory;
import com.wurmonline.server.creatures.NoSuchCreatureTemplateException;
import org.gotti.wurmunlimited.modloader.ReflectionUtil;
import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.ServerStartedListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;

public class Leadables implements WurmServerMod, ServerStartedListener, Configurable {
    public static final Logger logger = Logger.getLogger(Leadables.class.getName());
    public static final String version = "v1.0";
    private final HashMap<String, Boolean> customLeadables = new HashMap<>();

    @Override
    public void configure(Properties p) {
        Enumeration<?> names = p.propertyNames();
        while(names.hasMoreElements()){
            String next = (String)names.nextElement();
            if(next.startsWith("lead")) {
                boolean isLeadable = Boolean.parseBoolean(p.getProperty(next));
                customLeadables.put(next, isLeadable);
            }
        }
    }

    @Override
    public void onServerStarted() {
        for(String custom : customLeadables.keySet()){
            logger.info("Setting isLeadable for "+custom+": "+customLeadables.get(custom));
            setLeadable(getId(custom), customLeadables.get(custom));
        }
        customLeadables.clear();
    }

    private static void setLeadable(int id, boolean isCustomLeadable){
        try {
            boolean isLeadable = ReflectionUtil.getPrivateField(CreatureTemplateFactory.getInstance().getTemplate(id), ReflectionUtil.getField(CreatureTemplate.class, "leadable"));
            if(isLeadable != isCustomLeadable){
                ReflectionUtil.setPrivateField(CreatureTemplateFactory.getInstance().getTemplate(id), ReflectionUtil.getField(CreatureTemplate.class, "leadable"), isCustomLeadable);
            }
        }catch(NoSuchCreatureTemplateException | NoSuchFieldException | IllegalAccessException e){ throw new RuntimeException(e); }
    }

    private static int getId(String leadString){
        switch(leadString){
            case "leadHuman":
                return 1;
            case "leadSalesman":
                return 9;
            case "leadBrownCow":
                return 3;
            case "leadGuardTough":
                return 7;
            case "leadGuardBrutal":
                return 8;
            case "leadBlackWolf":
                return 10;
            case "leadTroll":
                return 11;
            case "leadBrownBear":
                return 12;
            case "leadBlackBear":
                return 42;
            case "leadLargeRat":
                return 13;
            case "leadCaveBug":
                return 43;
            case "leadMountainLion":
                return 14;
            case "leadWildCat":
                return 15;
            case "leadJoeTheStupe":
                return 2;
            case "leadRedDragon":
                return 16;
            case "leadGreenDragonHatchling":
                return 17;
            case "leadBlackDragonHatchling":
                return 18;
            case "leadWhiteDragonHatchling":
                return 19;
            case "leadForestGiant":
                return 20;
            case "leadUnicorn":
                return 21;
            case "leadUnicornFoal":
                return 118;
            case "leadKyklops":
                return 22;
            case "leadGoblin":
                return 23;
            case "leadHugeSpider":
                return 25;
            case "leadLavaSpider":
                return 56;
            case "leadGoblinLeader":
                return 26;
            case "leadTrollKing":
                return 27;
            case "leadSpiritGuard":
                return 28;
            case "leadSpiritSentry":
                return 29;
            case "leadSpiritAvenger":
                return 30;
            case "leadSpiritBrute":
                return 31;
            case "leadSpiritTemplar":
                return 32;
            case "leadSpiritShadow":
                return 33;
            case "leadJennKellonTowerGuard":
                return 34;
            case "leadHordeOfTheSummonedTowerGuard":
                return 35;
            case "leadMolRehanTowerGuard":
                return 36;
            case "leadIslesTowerGuard":
                return 67;
            case "leadBartender":
                return 41;
            case "leadSantaClaus":
                return 46;
            case "leadEvilSanta":
                return 47;
            case "leadWildBoar":
                return 37;
            case "leadMountainGorilla":
                return 39;
            case "leadAnaconda":
                return 38;
            case "leadRabidHyena":
                return 40;
            case "leadPig":
                return 44;
            case "leadHen":
                return 45;
            case "leadRooster":
                return 52;
            case "leadChicken":
                return 48;
            case "leadDog":
                return 51;
            case "leadCalf":
                return 50;
            case "leadBull":
                return 49;
            case "leadBison":
                return 82;
            case "leadHorse":
                return 64;
            case "leadFoal":
                return 65;
            case "leadEasterBunny":
                return 53;
            case "leadDeer":
                return 54;
            case "leadPheasant":
                return 55;
            case "leadLavaFiend":
                return 57;
            case "leadCrocodile":
                return 58;
            case "leadScorpion":
                return 59;
            case "leadTormentor":
                return 60;
            case "leadGuide":
                return 61;
            case "leadLadyOfTheLake":
                return 62;
            case "leadCobraKing":
                return 63;
            case "leadChild":
                return 66;
            case "leadAvengerOfTheLight":
                return 68;
            case "leadZombie":
                return 69;
            case "leadSeaSerpent":
                return 70;
            case "leadHugeShark":
                return 71;
            case "leadSolDemon":
                return 72;
            case "leadDeathcrawlerMinion":
                return 73;
            case "leadSpawnOfUttacha":
                return 74;
            case "leadSonOfNogump":
                return 75;
            case "leadDrakespirit":
                return 76;
            case "leadEaglespirit":
                return 77;
            case "leadEpiphanyOfVynora":
                return 78;
            case "leadJuggernautOfMagranon":
                return 79;
            case "leadManifestationOfFo":
                return 80;
            case "leadIncarnationOfLibila":
                return 81;
            case "leadHellHorse":
                return 83;
            case "leadHellFoal":
                return 117;
            case "leadHellHound":
                return 84;
            case "leadHellScorpious":
                return 85;
            case "leadWorg":
                return 86;
            case "leadSkeleton":
                return 87;
            case "leadWraith":
                return 88;
            case "leadSeal":
                return 93;
            case "leadTortoise":
                return 94;
            case "leadCrab":
                return 95;
            case "leadSheep":
                return 96;
            case "leadBlueWhale":
                return 97;
            case "leadSealCub":
                return 98;
            case "leadDolphin":
                return 99;
            case "leadOctopus":
                return 100;
            case "leadLamb":
                return 101;
            case "leadRam":
                return 102;
            case "leadBlackDragon":
                return 89;
            case "leadBlueDragon":
                return 91;
            case "leadGreenDragon":
                return 90;
            case "leadWhiteDragon":
                return 92;
            case "leadBlueDragonHatchling":
                return 104;
            case "leadRedDragonHatchling":
                return 103;
            case "leadFogSpider":
                return 105;
            case "leadRiftBeast":
                return 106;
            case "leadRiftJackal":
                return 107;
            case "leadRiftOgre":
                return 108;
            case "leadRiftWarmaster":
                return 109;
            case "leadRiftOgreMage":
                return 111;
            case "leadRiftCaster":
                return 110;
            case "leadRiftSummoner":
                return 112;
            case "leadNPCHuman":
                return 113;
            default:
                throw new RuntimeException("Could not find Id for leadString: "+leadString);
        }
    }
    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void init() {
    }

    @Override
    public void preInit() {
    }

}
