package thiagoalves.parser;

import java.time.LocalDateTime;

import thiagoalves.enums.Status;
import thiagoalves.exception.FieldNotFoundException;
import thiagoalves.model.Task;

public class JsonToTaskParser {
    public JsonToTaskParser() {}

    public Task parse(String json) throws FieldNotFoundException {

        int id = getInt(json, "id");
        String description = getString(json, "description");
        Status status = getStatus(json, "status");
        String createdAt = getString(json, "createdAt");
        String updatedAt = getString(json, "updatedAt");

        return new Task(id, description, status, createdAt, updatedAt);
    }

    public String getString(String json, String field) throws FieldNotFoundException{

        int fieldIndex = json.indexOf("\"" + field + "\"");

        if (fieldIndex == -1) {
            throw new FieldNotFoundException("O campo: \"" + field + "\" não foi encontrado.");
        }

        int colonIndex = json.indexOf(":", fieldIndex);
        int start = json.indexOf("\"", colonIndex) + 1;
        int end = json.indexOf("\"", start);

        return json.substring(start, end);
    }

    public Status getStatus(String json, String field) throws FieldNotFoundException{
        int fieldIndex = json.indexOf("\"" + field + "\"");

        if (fieldIndex == -1) {
            throw new FieldNotFoundException("O campo: \"" + field + "\" não foi encontrado.");
        }

        int colonIndex = json.indexOf(":", fieldIndex);

        int start = json.indexOf("\"", colonIndex) + 1; 
        int end = json.indexOf("\"", start);

        String value = json.substring(start, end);
        return Status.valueOf(value);
    }
    
    public int getInt(String json, String field) throws FieldNotFoundException{

        int fieldIndex = json.indexOf("\"" + field + "\"");

        if (fieldIndex == -1) {
            throw new FieldNotFoundException("O campo: \"" + field + "\" não foi encontrado.");
        }

        int colonIndex = json.indexOf(":", fieldIndex) + 1;
        int end = json.indexOf(",", colonIndex);
        
        String value = json.substring(colonIndex, end).trim();

        return Integer.parseInt(value);
    }

}