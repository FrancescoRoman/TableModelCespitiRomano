package itiscuneo.backend;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CespitiFile implements IExports{


    @Override
    public void scriviCsv(ElencoCespiti elencoCespiti) {
        File fileCsv = new File(PATH + NAME_CSV);
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(fileCsv);
            bw = new BufferedWriter(fw);
            for(Cespiti cespiti : elencoCespiti){
                bw.write(cespiti.toCsv());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void scriviJson(ElencoCespiti elencoCespiti){
        Gson gson = new Gson();
        String json = gson.toJson(elencoCespiti);

        File fileJson = new File(PATH + NAME_CSV);
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(fileJson);
            bw = new BufferedWriter(fw);
            bw.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void Main(String[] args){
        
    }
}
