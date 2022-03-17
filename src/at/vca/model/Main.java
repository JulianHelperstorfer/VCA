package at.vca.model;

import at.vca.model.helper.FileManagement;
import at.vca.model.helper.PasswordManagement;
import at.vca.model.parts.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/homepage.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 630, 340));
        primaryStage.show();
    }

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
       /* String user = "asd";
        byte[] test = PasswordManagement.encrypt(user);
        System.out.println(new String(PasswordManagement.decrypt(test)));*/

        //Sockets
        Socket amdam4 = new Socket("AMD AM4");
        Socket intel1700 = new Socket("Intel 1700");
        Socket intel1200 = new Socket("Intel 1200");
        Socket intel1151 = new Socket("Intel 1151");

        //ATX-Mainboards
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

        //Cases
        Component taliusCronos = new Case("Talius Cronos Gaming-Gehäuse ATX", 161.69, 0, "ATX");
        Component nzxtH510 = new Case("NZXT H510", 74, 0, "ATX");
        Component lianliodyssey = new Case("Lian Li Odyssey X Big-Tower", 459.90, 0, "E-ATX");
        Component coolerMaster = new Case("Cooler Master MasterBox Q300L", 46.90, 0, "Micro-ATX");

        //CPUs
        Component intelCorei310100 = new CPU("Intel Core i3-10100", 107.22, 65, intel1200);
        Component intelCorei512400F = new CPU("Intel® Core™ i5-12400F", 179, 117, intel1700);
        Component intelCorei511400F = new CPU("Intel® Core™ i5-11400F", 155, 65, intel1200);
        Component intelCorei512600K = new CPU("Intel Core i5-12600K", 284, 150, intel1700);
        Component intelCorei712700K = new CPU("Intel Core i7-12700K", 408.99, 190, intel1700);
        Component intelCorei912900K = new CPU("Intel Core i9-12900K", 583.90, 241, intel1700);
        Component aMDRyzen55600X = new CPU("AMD Ryzen 5 5600X", 230.39, 65, amdam4);
        Component amdRyzen73800X = new CPU("AMD Ryzen 7 3800X", 294.90, 105, amdam4);

        //CPU-cooler
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

        Component bequietPureRock2Black = new CPUCooler("be quiet! Pure Rock 2 Black", 37.26, 150, list1);
        Component NoctuaNHD15chromaxblack = new CPUCooler("Noctua NH-D15 chromax.black", 103.97, 197, list1);
        Component bequietPureRockSlim2 = new CPUCooler("be quiet! Pure Rock Slim 2", 23.47, 130, list2);
        Component arcticFreezeri35ARGB = new CPUCooler("Arctic Freezer i35 A-RGB", 38.33, 200, list3);
        Component alpenfoehnBenNevisRevB = new CPUCooler("Alpenföhn Ben Nevis Rev. B", 23.00, 140, list1);
        Component silentiumPCFera5 = new CPUCooler("SilentiumPC Fera 5", 33.29, 220, list1);
        Component DeepCoolGamerStormAssassinIII = new CPUCooler("DeepCool Gamer Storm Assassin III", 74.90, 280, list2);

        Component arcticLiquidFreezerII240 = new CPUCooler("Arctic Liquid Freezer II 240", 60.49, 3, list1);
        Component CorsairiCUEH150iEliteCapellix = new CPUCooler("Corsair iCUE H150i Elite Capellix", 182.80, 30, list1);

        launch(args);
    }

}
