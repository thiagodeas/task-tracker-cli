package thiagoalves.parser;

import thiagoalves.model.Task;

public class TaskToJsonParser {

    public TaskToJsonParser(){}

    public String parse(Task task) {
        StringBuilder json = new StringBuilder();

        json.append("{");
        json.append(System.lineSeparator());
        json.append("\"id\": " + task.getId() + ", ");
        json.append("\"description\": \"" + task.getDescription() + "\", ");
        json.append("\"status\": \"" + task.getStatus() + "\", ");
        json.append("\"createdAt\": " + task.getCreatedDateTime() + ", ");
        json.append("\"updatedAt\": " + task.getUpdatedDateTime());
        json.append(System.lineSeparator());
        json.append("}");

        return json.toString();
    }
}
