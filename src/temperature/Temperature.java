package temperature;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

class Temperature {

    private int value;
    private int cValue;
    private int fValue;
    private int kValue;
    private String scale;
    private Scales scales = new Scales();

    private void ifCelcium(int value) {
        fValue = (int) ((value * 1.8) + 32);
        kValue = (int) (value + 273.15);
    }

    private void ifFahrenheit(int value) {
        cValue = (int) ((value - 32) / 1.8);
        kValue = (int) ((value - 32) / 1.8 + 273.15);
    }

    private void ifKelvin(int value) {
        cValue = (int) (value - 273.15);
        fValue = (int) ((value - 273.15) * 1.8 + 32);
    }

    private void parser(String temp) {
        String str = "";
        char[] tempArray = temp.toCharArray();
        scale = Character.toString(tempArray[tempArray.length - 1]).toUpperCase();
        for (int i = 0; i < tempArray.length - 1; i++) {
            str += Character.toString(tempArray[i]);
        }
        value = Integer.parseInt(str);
    }


    public String converter(String temp) {
        parser(temp);
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();

        if (scale.equalsIgnoreCase("C")) {
            ifCelcium(value);
            scales.setF(fValue);
            scales.setK(kValue);
            jsonObject = gson.toJsonTree(scales).getAsJsonObject();
            jsonObject.remove(scale);
        } else if (scale.equalsIgnoreCase("K")) {
            ifKelvin(value);
            scales.setF(fValue);
            scales.setC(cValue);
            jsonObject = gson.toJsonTree(scales).getAsJsonObject();
            jsonObject.remove(scale);
        } else if (scale.equalsIgnoreCase("F")) {
            ifFahrenheit(value);
            scales.setC(cValue);
            scales.setK(kValue);
            jsonObject = gson.toJsonTree(scales).getAsJsonObject();
            jsonObject.remove(scale);
        } else throw new Error();

        return jsonObject.toString();

    }

}
