package thiagoalves.parser;

import java.util.List;

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
        json.append("\"createdAt\": \"" + task.getCreatedDateTime() + "\", ");
        json.append("\"updatedAt\": \"" + task.getUpdatedDateTime() + "\"");
        json.append(System.lineSeparator());
        json.append("}");

        return json.toString();
    }
    
    public String parse(List<Task> tasks) {
        StringBuilder jsonArray = new StringBuilder();
        jsonArray.append("[");
        jsonArray.append(System.lineSeparator());

        for (int i = 0; i < tasks.size(); i++) {
            jsonArray.append(parse(tasks.get(i)));

            if (i < tasks.size() - 1) {
                jsonArray.append(",");
            }
            jsonArray.append(System.lineSeparator());
        }

        jsonArray.append("]");

        return jsonArray.toString();
    }
}
