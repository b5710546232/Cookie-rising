package com.group12.cookiesrising.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;
import com.badlogic.gdx.utils.ObjectMap;

/**
 * Created by nattapat on 5/31/2016 AD.
 */
public class SaveManager {

    private static FileHandle file = Gdx.files.local("bin/save.json");
    private static Save save = getSave();
    private static Save getSave(){
        Save save = new Save();
        if(file.exists()){
            Json json = new Json();

            
            save = json.fromJson(Save.class, Base64Coder.
                    decodeString(file.readString()));
        }
        return save;
    }
    public static void saveToJson() {
        Json json = new Json();
        json.setOutputType(JsonWriter.OutputType.json);
        file.writeString(Base64Coder.encodeString(json.prettyPrint(save)), false);
    }

    public static  <T> T loadDataValue(String key, Class type){
        if(save.data.containsKey(key))return (T) save.data.get(key);
        else return null;
    }
    public static void saveDataValue(String key, Object object){
        save.data.put(key, object);
        saveToJson();
    }


    public static class Save{
        public ObjectMap<String, Object> data = new ObjectMap<String,
                Object>();
    }


}
