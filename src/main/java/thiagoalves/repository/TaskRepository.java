package thiagoalves.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import thiagoalves.exception.FieldNotFoundException;
import thiagoalves.exception.TaskNotFoundException;
import thiagoalves.model.Task;
import thiagoalves.parser.JsonToTaskParser;
import thiagoalves.parser.TaskToJsonParser;

public class TaskRepository  {

    private TaskToJsonParser taskToJsonParser = new TaskToJsonParser();
    private JsonToTaskParser jsonToTaskParser = new JsonToTaskParser();
    private List<Task> tasks;

    public Task save(String description) throws IOException, FieldNotFoundException {
        Path path = Path.of("tasks.json");
        
        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        String content = Files.readString(path);
        tasks = new ArrayList<>();

        if (!content.isBlank()) {
            Pattern pattern = Pattern.compile("\\{[^}]*\\}");
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                String jsonObject = matcher.group();
                Task existingTask = jsonToTaskParser.parse(jsonObject);
                tasks.add(existingTask);
            }
        }
        
        int nextId = tasks.stream()
        .mapToInt(Task::getId)
        .max()
        .orElse(0) + 1;

        Task newTask = new Task(nextId, description);
        tasks.add(newTask);

        String finalJson = taskToJsonParser.parse(tasks);
        Files.writeString(path, finalJson);

        return newTask;
        }

        public void update(int id, String description) throws IOException, FieldNotFoundException, TaskNotFoundException {
        Path path = Path.of("tasks.json");

        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        String content = Files.readString(path);
        tasks = new ArrayList<>();

        if (!content.isBlank()) {
            Pattern pattern = Pattern.compile("\\{[^}]*\\}");
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                String jsonObject = matcher.group();
                Task existingTask = jsonToTaskParser.parse(jsonObject);
                tasks.add(existingTask);
            }
        }

        Task taskFound = null;

        for(Task t : tasks) {
            if (t.getId() == id) {
                taskFound = t;
                break;
            }
        }

        if (taskFound == null) {
            throw new TaskNotFoundException("Tarefa com ID " + id + " não foi encontrada.");
        }

        taskFound.setDescription(description);
        taskFound.setUpdatedDateTime();

        String finalJson = taskToJsonParser.parse(tasks);
        Files.writeString(path, finalJson);
    } 
}