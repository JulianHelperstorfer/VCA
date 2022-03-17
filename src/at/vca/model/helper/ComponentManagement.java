package at.vca.model.helper;

import at.vca.model.parts.Case;
import at.vca.model.parts.Component;

import java.io.*;
import java.lang.reflect.Array;
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

        list = (ArrayList<Component>) ois.readObject();

        ois.close();
    }

    public static void saveComponents(File file, ArrayList<Component> list) throws IOException {
        oos = new ObjectOutputStream(new FileOutputStream(file));

        oos.writeObject(list);

        oos.close();
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