package at.vca.model.helper;

import at.vca.model.parts.*;

import java.io.*;
import java.util.ArrayList;

public class ComponentManagement {

    private static ArrayList<Component> cases = new ArrayList<>();
    private static ArrayList<Component> caseFans = new ArrayList<>();
    private static ArrayList<Component> cpus = new ArrayList<>();
    private static ArrayList<Component> cpuCoolers = new ArrayList<>();
    private static ArrayList<Component> gpus = new ArrayList<>();
    private static ArrayList<Component> motherboards = new ArrayList<>();
    private static ArrayList<Component> powerSupplies = new ArrayList<>();
    private static ArrayList<Component> rams = new ArrayList<>();
    private static ArrayList<Component> sockets = new ArrayList<>();
    private static ArrayList<Component> storages = new ArrayList<>();

    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;

    private static File caseFile = new File("caseFile");
    private static File caseFanFile = new File("caseFanFile");
    private static File cpuFile = new File("cpuFile");
    private static File cpuCoolerFile = new File("cpuCoolerFile");
    private static File gpuFile = new File("gpuFile");
    private static File motherboardFile = new File("motherboardFile");
    private static File powerSupplyFile = new File("powerSupplyFile");
    private static File ramFile = new File("ramFile");
    private static File socketFile = new File("socketFile");
    private static File storageFile = new File("storageFile");

    public static void loadComponents(File file, ArrayList<Component> list) throws IOException, ClassNotFoundException {
        ois = new ObjectInputStream(new FileInputStream(file));


        Object obj = ois.readObject();
        ArrayList<Component> components = (ArrayList<Component>) obj;


        ois.close();
    }

    public static void saveComponents(File file, ArrayList<Component> list) throws IOException {
        oos = new ObjectOutputStream(new FileOutputStream(file));

        oos.writeObject(list);

        oos.close();
    }

    public static void loadAllComponents() throws IOException, ClassNotFoundException {
        System.out.println("Loading all components into their lists...");
        loadComponents(getCaseFile(), getCases());
        loadComponents(getMotherboardFile(), getMotherboards());
        loadComponents(getCpuFile(), getCpus());
        loadComponents(getCpuCoolerFile(), getCpuCoolers());
        loadComponents(getGpuFile(), getGpus());
        loadComponents(getRamFile(), getRams());
        loadComponents(getSocketFile(), getSockets());
        loadComponents(getStorageFile(), getStorages());
        loadComponents(getCaseFanFile(), getCaseFans());
        loadComponents(getPowerSupplyFile(), getPowerSupplies());
        System.out.println("Finished loading components!");
    }

    public static void initializeStandardComponents() throws IOException {
        System.out.println("Starting Initialization of Components...");

        //Sockets
        System.out.println("Initializing Sockets...");
        Socket amdam4 = new Socket("AMD AM4", 0, 0);
        Socket intel1700 = new Socket("Intel 1700", 0, 0);
        Socket intel1200 = new Socket("Intel 1200", 0, 0);
        Socket intel1151 = new Socket("Intel 1151", 0, 0);

        ArrayList<Component> sockets = new ArrayList<>();
        sockets.add(amdam4);
        sockets.add(intel1151);
        sockets.add(intel1200);
        sockets.add(intel1700);

        ComponentManagement.setSockets(sockets);

        System.out.println("Finished initializing sockets!");

        //ATX-Mainboards
        System.out.println("Initializing Mainboards...");
        Component mSIMPGB550GamingPlus = new Motherboard("MSI MPG B550 Gaming Plus", 109.90, 110, "AMD B550", amdam4, "ATX");
        Component aSUSROGStrixB550AGaming = new Motherboard("ASUS ROG Strix B550-A Gaming", 87.90, 125, "AMD B550", amdam4, "ATX");
        Component gIGABYTEB660 = new Motherboard("GIGABYTE B660", 149.48, 353, "Intel B660", intel1700, "ATX");
        Component aSUSROGMaximusXIIFormula = new Motherboard("ASUS ROG Maximus XII Formula", 252.10, 296, "Intel Z490", intel1200, "ATX");

        //E-ATX-Mainboards
        Component aSUSROGMAXIMUSZ690EXTREME = new Motherboard("ASUS ROG MAXIMUS Z690 EXTREME", 1077.48, 245, "Intel Z690", intel1700, "E-ATX");
        Component gIGABYTEZ690AORUSXTREMEEATX = new Motherboard("GIGABYTE Z690 AORUS XTREME E-ATX", 901.33, 385, "Intel Z690", intel1700, "E-ATX");

        //Micro-ATX-Mainboards
        Component asRockH310CMDVS = new Motherboard("AsRock H310CM-DVS", 36.43, 95, "Intel H310", intel1151, "Micro-ATX");
        Component mSIB450MMortar = new Motherboard("MSI B450M Mortar", 83.69, 321, "AMD B450", amdam4, "Micro-ATX");

        ArrayList<Component> motherboards = new ArrayList<>();
        motherboards.add(mSIMPGB550GamingPlus);
        motherboards.add(aSUSROGStrixB550AGaming);
        motherboards.add(gIGABYTEB660);
        motherboards.add(aSUSROGMaximusXIIFormula);
        motherboards.add(aSUSROGMAXIMUSZ690EXTREME);
        motherboards.add(gIGABYTEZ690AORUSXTREMEEATX);
        motherboards.add(asRockH310CMDVS);
        motherboards.add(mSIB450MMortar);

        ComponentManagement.setMotherboards(motherboards);

        System.out.println("Finished initializing mainboards!");

        //Cases
        System.out.println("Initializing cases...");
        Component taliusCronos = new Case("Talius Cronos Gaming-Gehäuse ATX", 161.69, 0, "ATX");
        Component nzxtH510 = new Case("NZXT H510", 74, 0, "ATX");
        Component lianliodyssey = new Case("Lian Li Odyssey X Big-Tower", 459.90, 0, "E-ATX");
        Component coolerMaster = new Case("Cooler Master MasterBox Q300L", 46.90, 0, "Micro-ATX");

        ArrayList<Component> cases = new ArrayList<>();
        cases.add(taliusCronos);
        cases.add(nzxtH510);
        cases.add(lianliodyssey);
        cases.add(coolerMaster);

        ComponentManagement.setCases(cases);

        System.out.println("Finished initializing cases!");

        //CPUs
        System.out.println("Initializing CPUs...");
        Component intelCorei310100 = new CPU("Intel Core i3-10100", 107.22, 65, intel1200);
        Component intelCorei512400F = new CPU("Intel® Core™ i5-12400F", 179, 117, intel1700);
        Component intelCorei511400F = new CPU("Intel® Core™ i5-11400F", 155, 65, intel1200);
        Component intelCorei512600K = new CPU("Intel Core i5-12600K", 284, 150, intel1700);
        Component intelCorei712700K = new CPU("Intel Core i7-12700K", 408.99, 190, intel1700);
        Component intelCorei912900K = new CPU("Intel Core i9-12900K", 583.90, 241, intel1700);
        Component aMDRyzen55600X = new CPU("AMD Ryzen 5 5600X", 230.39, 65, amdam4);
        Component amdRyzen73800X = new CPU("AMD Ryzen 7 3800X", 294.90, 105, amdam4);

        ArrayList<Component> cpus = new ArrayList<>();
        cpus.add(intelCorei310100);
        cpus.add(intelCorei511400F);
        cpus.add(intelCorei512400F);
        cpus.add(intelCorei512600K);
        cpus.add(intelCorei712700K);
        cpus.add(intelCorei912900K);
        cpus.add(aMDRyzen55600X);
        cpus.add(amdRyzen73800X);

        ComponentManagement.setCpus(cpus);

        System.out.println("Finished initializing CPUs!");

        //CPU-cooler
        System.out.println("Initializing CPU-coolers...");
        ArrayList<Socket> list1 = new ArrayList<>();
        list1.add(amdam4);
        list1.add(intel1151);
        list1.add(intel1200);
        list1.add(intel1700);

        ArrayList<Socket> list2 = new ArrayList<>();
        list2.add(amdam4);
        list2.add(intel1151);
        list2.add(intel1200);

        ArrayList<Socket> list3 = new ArrayList<>();
        list2.add(intel1700);
        list2.add(intel1151);
        list2.add(intel1200);

        //coolers
        Component bequietPureRock2Black = new CPUCooler("be quiet! Pure Rock 2 Black", 37.26, 10, list1);
        Component NoctuaNHD15chromaxblack = new CPUCooler("Noctua NH-D15 chromax.black", 103.97, 10, list1);
        Component bequietPureRockSlim2 = new CPUCooler("be quiet! Pure Rock Slim 2", 23.47, 10, list2);
        Component arcticFreezeri35ARGB = new CPUCooler("Arctic Freezer i35 A-RGB", 38.33, 10, list3);
        Component alpenfoehnBenNevisRevB = new CPUCooler("Alpenföhn Ben Nevis Rev. B", 23.00, 10, list1);
        Component silentiumPCFera5 = new CPUCooler("SilentiumPC Fera 5", 33.29, 10, list1);
        Component DeepCoolGamerStormAssassinIII = new CPUCooler("DeepCool Gamer Storm Assassin III", 74.90, 10, list2);
        //liquid coolers
        Component arcticLiquidFreezerII240 = new CPUCooler("Arctic Liquid Freezer II 240", 60.49, 10, list1);
        Component corsairiCUEH150iEliteCapellix = new CPUCooler("Corsair iCUE H150i Elite Capellix", 182.80, 10, list1);
        Component bequietSilentLoop2360mm = new CPUCooler("be quiet! Silent Loop 2 360mm", 139.90, 10, list1);
        Component aSUSROGRyujinII360 = new CPUCooler("ASUS ROG Ryujin II 360 ", 326.70, 10, list3);

        ArrayList<Component> cpuCoolers = new ArrayList<>();
        cpuCoolers.add(bequietPureRock2Black);
        cpuCoolers.add(NoctuaNHD15chromaxblack);
        cpuCoolers.add(bequietPureRockSlim2);
        cpuCoolers.add(arcticFreezeri35ARGB);
        cpuCoolers.add(alpenfoehnBenNevisRevB);
        cpuCoolers.add(silentiumPCFera5);
        cpuCoolers.add(DeepCoolGamerStormAssassinIII);
        cpuCoolers.add(arcticLiquidFreezerII240);
        cpuCoolers.add(corsairiCUEH150iEliteCapellix);
        cpuCoolers.add(bequietSilentLoop2360mm);
        cpuCoolers.add(aSUSROGRyujinII360);

        ComponentManagement.setCpuCoolers(cpuCoolers);

        System.out.println("Finished initializing CPU-coolers!");

        //GPUs
        System.out.println("Initializing GPUs...");
        Component mSIGeForceRTX3070TiVentus = new GPU("MSI GeForce RTX 3070 Ti Ventus", 855.63, 290, "ATX");
        Component MSIGeForceRTX3080Ventus = new GPU("MSI GeForce RTX 3080 Ventus 3X Plus", 1219, 320, "ATX");
        Component sapphireNitroRadeonRX6900XTSE = new GPU("Sapphire Nitro+ Radeon RX 6900 XT SE", 1349, 300, "ATX");
        Component xFXSpeedsterSWFT309RadeonRX6700XTCoreGaming = new GPU("XFX Speedster SWFT 309 Radeon RX 6700 XT Core Gaming", 695, 230, "ATX");
        Component ASUSPhoenixGeForceGTX1650OC = new GPU("ASUS Phoenix GeForce GTX 1650 OC", 292.25, 75, "Micro-ATX");

        ArrayList<Component> gpus = new ArrayList<>();
        gpus.add(mSIGeForceRTX3070TiVentus);
        gpus.add(MSIGeForceRTX3080Ventus);
        gpus.add(sapphireNitroRadeonRX6900XTSE);
        gpus.add(xFXSpeedsterSWFT309RadeonRX6700XTCoreGaming);
        gpus.add(ASUSPhoenixGeForceGTX1650OC);

        ComponentManagement.setGpus(gpus);

        System.out.println("Finished initializing GPUs!");

        //RAMs
        System.out.println("Initializing RAMs...");
        Component corsairVengeanceLPXschwarzDIMMKit32GB = new RAM("Corsair Vengeance LPX schwarz DIMM Kit 32GB", 118.92, 2, "2*16GB", 31);
        Component crucialBallistixschwarzDIMMKit16GB = new RAM("Crucial Ballistix schwarz DIMM Kit 16GB, DDR4-3600, CL16-18-18-38", 89.90, 2, "2*8GB", 39.17);
        Component kingstonFURYBeastDIMMKit32GB = new RAM("Kingston FURY Beast DIMM Kit 32GB, DDR5-4800, CL38-38-38, on-die ECC", 249, 2, "2*16GB", 34.9);
        Component corsairVengeanceRGBPROschwarzDIMMKit32GB = new RAM("Corsair Vengeance RGB PRO schwarz DIMM Kit 32GB, DDR4-3600, CL18-22-22-42", 155.89, 2, "2*16GB", 51.4);
        Component kingstonFURYBeastDIMMKit16GB = new RAM("Kingston FURY Beast DIMM Kit 16GB, DDR4-3200, CL16-18-18 ", 70.76, 2, "2*8GB", 34);
        Component crucialSODIMM8GB = new RAM("Crucial SO-DIMM 8GB, DDR4-3200, CL22-22-22", 31.77, 2, "1*8GB", 30);
        Component corsairVengeanceLPXschwarzDIMMKit64GB = new RAM("Corsair Vengeance LPX schwarz DIMM Kit 64GB, DDR4-3600, CL18-22-22-42", 340.90, 2, "2*32GB", 31);

        ArrayList<Component> rams = new ArrayList<>();
        rams.add(corsairVengeanceLPXschwarzDIMMKit32GB);
        rams.add(crucialBallistixschwarzDIMMKit16GB);
        rams.add(kingstonFURYBeastDIMMKit16GB);
        rams.add(kingstonFURYBeastDIMMKit32GB);
        rams.add(corsairVengeanceLPXschwarzDIMMKit64GB);
        rams.add(corsairVengeanceRGBPROschwarzDIMMKit32GB);
        rams.add(crucialSODIMM8GB);

        ComponentManagement.setRams(rams);

        System.out.println("Finished initializing RAMs");

        //SSDs
        System.out.println("Initializing storages...");
        Component samsungSSD980PRO1TB = new Storage("Samsung SSD 980 PRO 1TB, M.2", 150.35, 9, 1000);
        Component samsungSSD870EVO1TB = new Storage("Samsung SSD 870 EVO 1TB, SATA", 115.90, 4, 1000);
        Component kIOXIAEXCERIAG2SSD1TB = new Storage("KIOXIA EXCERIA G2 SSD 1TB, M.2", 55.14, 4, 1000);
        Component kingstonNV1NVMePCIeSSD2TB = new Storage("Kingston NV1 NVMe PCIe SSD 2TB, M.2", 156.20, 4, 2000);
        Component samsungSSD870QVO4TB = new Storage("Samsung SSD 870 QVO 4TB, SATA", 329.95, 6, 4000);

        //HDDs
        Component toshibaEnterpriseCapacityMG09ACA18TB = new Storage("Toshiba Enterprise Capacity MG09ACA 18TB, 512e, SATA 6Gb/s", 289, 9, 18000);
        Component WesternDigitalWDRedPlus4TB = new Storage("Western Digital WD Red Plus 4TB, SATA 6Gb/s", 89.90, 5, 4000);
        Component SeagateBarraCudaCompute5TB = new Storage("Seagate BarraCuda Compute 5TB, 2.5\", SATA 6Gb/s", 122.81, 3, 5000);
        Component SeagateIronWolfNASHDDRescue2TB = new Storage("Seagate IronWolf NAS HDD +Rescue 2TB, SATA 6Gb/s", 151.90, 5, 2000);
        Component ToshibaEnterpriseCapacityMG07ACA12TB = new Storage("Toshiba Enterprise Capacity MG07ACA 12TB, 512e, SATA 6Gb/s", 212.31, 8, 12000);

        ArrayList<Component> storages = new ArrayList<>();
        storages.add(samsungSSD980PRO1TB);
        storages.add(samsungSSD870EVO1TB);
        storages.add(samsungSSD870QVO4TB);
        storages.add(kIOXIAEXCERIAG2SSD1TB);
        storages.add(kingstonNV1NVMePCIeSSD2TB);
        storages.add(toshibaEnterpriseCapacityMG09ACA18TB);
        storages.add(WesternDigitalWDRedPlus4TB);
        storages.add(SeagateBarraCudaCompute5TB);
        storages.add(SeagateIronWolfNASHDDRescue2TB);
        storages.add(ToshibaEnterpriseCapacityMG07ACA12TB);

        ComponentManagement.setStorages(storages);

        System.out.println("Finished initializing storages!");

        //Power Supplies
        System.out.println("Initializing power supplies...");
        Component bequietStraightPower11Platinum850WATX = new PowerSupply("be quiet! Straight Power 11 Platinum 850W ATX 2.51", 151.46, 0, 850);
        Component corsairRMxSeriesRM850x = new PowerSupply("Corsair RMx Series RM850x", 118.98, 0, 850);
        Component bequietPurePower11600WATX = new PowerSupply("be quiet! Pure Power 11 600W ATX 2.4", 80.57, 0, 600);
        Component bequietPurePower11FM1000WATX = new PowerSupply("be quiet! Pure Power 11 FM 1000W ATX 2.52", 140.68, 0, 1000);
        Component bequietStraightPower11Platinum550WATX = new PowerSupply("be quiet! Straight Power 11 Platinum 550W ATX 2.51", 105.31, 0, 550);
        Component bequietSystemPower9400WATX = new PowerSupply("be quiet! System Power 9 400W ATX 2.4", 40.24, 0, 400);
        Component corsairCXFRGBWhiteSeriesCX750FRGB750W = new PowerSupply("Corsair CX-F RGB White Series CX750F RGB, 750W", 82.59, 0, 750);

        ArrayList<Component> powerSupplies = new ArrayList<>();
        powerSupplies.add(bequietStraightPower11Platinum850WATX);
        powerSupplies.add(corsairRMxSeriesRM850x);
        powerSupplies.add(bequietPurePower11600WATX);
        powerSupplies.add(bequietPurePower11FM1000WATX);
        powerSupplies.add(bequietStraightPower11Platinum550WATX);
        powerSupplies.add(bequietSystemPower9400WATX);
        powerSupplies.add(corsairCXFRGBWhiteSeriesCX750FRGB750W);

        ComponentManagement.setPowerSupplies(powerSupplies);

        System.out.println("Finished initializing power supplies!");

        //Case Fans
        System.out.println("Initializing case fans...");
        Component corsairLL120RGBLEDPWMPCGehauuseluefter = new CaseFan("Corsair LL120 RGB LED PWM 3er Pack", 80.45, 3, "Micro-ATX");
        Component eZDIYFABMoonlightRGB = new CaseFan("EZDIY-FAB Moonlight RGB Single", 26.26, 3, "Micro-ATX");
        Component noiseBlockerBlackSilentXR2PCGehauuseLuefter = new CaseFan("NoiseBlocker BlackSilent XR-2 Single", 5.80, 1, "Micro-ATX");

        ArrayList<Component> caseFans = new ArrayList<>();
        caseFans.add(corsairLL120RGBLEDPWMPCGehauuseluefter);
        caseFans.add(eZDIYFABMoonlightRGB);
        caseFans.add(noiseBlockerBlackSilentXR2PCGehauuseLuefter);
        ComponentManagement.setCaseFans(caseFans);

        System.out.println("Finished initializing case fans!");

        //write components into their files
        System.out.println("Saving components to files...");

        saveComponents(getCaseFile(), getCases());
        saveComponents(getMotherboardFile(), getMotherboards());
        saveComponents(getCpuFile(), getCpus());
        saveComponents(getCpuCoolerFile(), getCpuCoolers());
        saveComponents(getGpuFile(), getGpus());
        saveComponents(getRamFile(), getRams());
        saveComponents(getSocketFile(), getSockets());
        saveComponents(getStorageFile(), getStorages());
        saveComponents(getCaseFanFile(), getCaseFans());
        saveComponents(getPowerSupplyFile(), getPowerSupplies());

        System.out.println("Finished saving components to files!");

        System.out.println("Initialization of components complete!");
    }


    public static ArrayList<Component> getCases() {
        return cases;
    }

    public static void setCases(ArrayList<Component> cases) {
        ComponentManagement.cases = cases;
    }

    public static ArrayList<Component> getCaseFans() {
        return caseFans;
    }

    public static void setCaseFans(ArrayList<Component> caseFans) {
        ComponentManagement.caseFans = caseFans;
    }

    public static ArrayList<Component> getCpus() {
        return cpus;
    }

    public static void setCpus(ArrayList<Component> cpus) {
        ComponentManagement.cpus = cpus;
    }

    public static ArrayList<Component> getCpuCoolers() {
        return cpuCoolers;
    }

    public static void setCpuCoolers(ArrayList<Component> cpuCoolers) {
        ComponentManagement.cpuCoolers = cpuCoolers;
    }

    public static ArrayList<Component> getGpus() {
        return gpus;
    }

    public static void setGpus(ArrayList<Component> gpus) {
        ComponentManagement.gpus = gpus;
    }

    public static ArrayList<Component> getMotherboards() {
        return motherboards;
    }

    public static void setMotherboards(ArrayList<Component> motherboards) {
        ComponentManagement.motherboards = motherboards;
    }

    public static ArrayList<Component> getPowerSupplies() {
        return powerSupplies;
    }

    public static void setPowerSupplies(ArrayList<Component> powerSupplies) {
        ComponentManagement.powerSupplies = powerSupplies;
    }

    public static ArrayList<Component> getRams() {
        return rams;
    }

    public static void setRams(ArrayList<Component> rams) {
        ComponentManagement.rams = rams;
    }

    public static ArrayList<Component> getSockets() {
        return sockets;
    }

    public static void setSockets(ArrayList<Component> sockets) {
        ComponentManagement.sockets = sockets;
    }

    public static ArrayList<Component> getStorages() {
        return storages;
    }

    public static void setStorages(ArrayList<Component> storages) {
        ComponentManagement.storages = storages;
    }

    public static ObjectInputStream getOis() {
        return ois;
    }

    public static void setOis(ObjectInputStream ois) {
        ComponentManagement.ois = ois;
    }

    public static ObjectOutputStream getOos() {
        return oos;
    }

    public static void setOos(ObjectOutputStream oos) {
        ComponentManagement.oos = oos;
    }

    public static File getCaseFile() {
        return caseFile;
    }

    public static void setCaseFile(File caseFile) {
        ComponentManagement.caseFile = caseFile;
    }

    public static File getCaseFanFile() {
        return caseFanFile;
    }

    public static void setCaseFanFile(File caseFanFile) {
        ComponentManagement.caseFanFile = caseFanFile;
    }

    public static File getCpuFile() {
        return cpuFile;
    }

    public static void setCpuFile(File cpuFile) {
        ComponentManagement.cpuFile = cpuFile;
    }

    public static File getCpuCoolerFile() {
        return cpuCoolerFile;
    }

    public static void setCpuCoolerFile(File cpuCoolerFile) {
        ComponentManagement.cpuCoolerFile = cpuCoolerFile;
    }

    public static File getGpuFile() {
        return gpuFile;
    }

    public static void setGpuFile(File gpuFile) {
        ComponentManagement.gpuFile = gpuFile;
    }

    public static File getMotherboardFile() {
        return motherboardFile;
    }

    public static void setMotherboardFile(File motherboardFile) {
        ComponentManagement.motherboardFile = motherboardFile;
    }

    public static File getPowerSupplyFile() {
        return powerSupplyFile;
    }

    public static void setPowerSupplyFile(File powerSupplyFile) {
        ComponentManagement.powerSupplyFile = powerSupplyFile;
    }

    public static File getRamFile() {
        return ramFile;
    }

    public static void setRamFile(File ramFile) {
        ComponentManagement.ramFile = ramFile;
    }

    public static File getSocketFile() {
        return socketFile;
    }

    public static void setSocketFile(File socketFile) {
        ComponentManagement.socketFile = socketFile;
    }

    public static File getStorageFile() {
        return storageFile;
    }

    public static void setStorageFile(File storageFile) {
        ComponentManagement.storageFile = storageFile;
    }
}