package com.group12.cookiesrising.util;

import com.badlogic.gdx.Gdx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by nattapat on 5/31/2016 AD.
 */
public class Save {
    public final static Save instance = new Save();
    public static GameData gameData;
    public Save(){
        init();
    }

    public void save(){
        try{
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("savegame.sav")
            );
            out.writeObject(gameData);
            out.close();
        }
        catch(Exception e){
            e.printStackTrace();
            Gdx.app.exit();
        }

    }
    public void load(){
        try{
            if(!saveFileExist()){
                init();
                return;
            }
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("savegame.sav")
            );

        }
        catch(Exception e){
            e.printStackTrace();
            Gdx.app.exit();
        }

    }

    public void init(){
        gameData = GameData.instance;
        gameData.init();
        save();
    }
    public boolean saveFileExist(){
        File f = new File("savegame.sav");
        return f.exists();
    }
}
