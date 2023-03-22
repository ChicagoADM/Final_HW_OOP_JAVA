package homeworks.final_project.data_handler;

import homeworks.final_project.model.Contractor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class DataWriter implements Data{

   
    public static void dataWrite(Contractor contractor) {
    
        try (FileWriter writer = new FileWriter(path, true)) { 
            writer.write(contractor.getName()); 
            writer.write(",");
            for (Map.Entry<String, List<String>> entry: contractor.getCommsMap().entrySet()) { 
                if (entry.getValue() != null) { 
                    for (String com : entry.getValue()){
                        writer.write(com);
                        writer.write(",");
                    }
                }
            }
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void removeData(String name) {
        List<Contractor> list = DataReader.read();
        for (Contractor contractor: list) {
            if (contractor.getName().equalsIgnoreCase(name)) {
                list.remove(contractor);
                DataWriter.reWriteData(list);
                return;
            }
        }
    }


    public static void reWriteData(List<Contractor> list) {
        try (FileWriter writer = new FileWriter(path, false)) { 
            for (Contractor contractor: list) {
                writer.write(contractor.getName());
                writer.write(",");
                for (Map.Entry<String, List<String>> entry: contractor.getCommsMap().entrySet()) {
                    if (entry.getValue() != null) {
                        for (String com : entry.getValue()){
                            writer.write(com);
                            writer.write(",");
                        }
                    }
                }
                writer.write("\n");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
