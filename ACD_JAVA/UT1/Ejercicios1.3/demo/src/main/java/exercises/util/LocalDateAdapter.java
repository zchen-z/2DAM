package exercises.util;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ISO_LOCAL_DATE;

    /**
     * De LocalDate a JSON (por ejemplo "2025-03-15").
     */
    @Override
    public JsonElement serialize(LocalDate fecha, Type tipo, JsonSerializationContext contexto) {
        return new JsonPrimitive(fecha.format(FORMATO));
    }

    /**
     * De JSON (texto) a LocalDate.
     */
    @Override
    public LocalDate deserialize(JsonElement json, Type tipo, JsonDeserializationContext contexto)
            throws JsonParseException {
        return LocalDate.parse(json.getAsString(), FORMATO);
    }
}
