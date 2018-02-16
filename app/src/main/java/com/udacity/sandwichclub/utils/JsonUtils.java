package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    /*
    {\"name\":{\"mainName\":\"Ham and cheese
            sandwich\",\"alsoKnownAs\":[]},

            \"placeOfOrigin\":\"\",
            \"description\":\"A ham and cheese
            sandwich is a common type of sandwich. It is made by putting cheese and sliced ham
            between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables
            like lettuce, tomato, onion or pickle slices can also be included. Various kinds of
            mustard and mayonnaise are also
            common.\",
            \"image\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG\",
            \"ingredients\":[\"Sliced bread\",\"Cheese\",\"Ham\"]}
     */

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jo = new JSONObject(json);
            JSONObject names = jo.getJSONObject("name");
            String mainName = names.getString("mainName");


            JSONArray nameArray = names.getJSONArray("alsoKnownAs");
            int nameCount = nameArray.length();
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < nameCount; i++) {
                alsoKnownAs.add(nameArray.getString(i));
            }


            JSONArray ingredientArray = jo.getJSONArray("ingredients");
            int ingredientCount = ingredientArray.length();
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i <ingredientCount; i++) {
                ingredients.add(ingredientArray.getString(i));
            }

            String origin = jo.getString("placeOfOrigin");
            String description = jo.getString("description");
            String image = jo.getString("image");


            Sandwich parsedSandwich = new Sandwich(mainName, alsoKnownAs, origin, description, image, ingredients);
            return parsedSandwich;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
