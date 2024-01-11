package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Management implements Factory {
    private Map<String, Task> tasks = new HashMap<>();
    private Map<String, String> assignments = new HashMap<>();

    public Management(List<Task> taskList) {
        for (Task task : taskList) {
            tasks.put(task.getId(), task);
        }
    }

    @Override
    public void assign(String name, String taskId) {
        if (assignments.containsKey(name)) {
            System.out.println("Pracownik " + name + " ma już przypisane zadanie!");
            return;
        }

        if (assignments.containsValue(taskId)) {
            System.out.println("Zadanie " + taskId + " zostało już przydzielone do innego pracownika!");
            return;
        }

        Task task = tasks.get(taskId);
        if (task == null) {
            System.out.println("Nieznane zadanie o ID: " + taskId);
            return;
        }

        assignments.put(name, taskId);
        System.out.println("Przypisano zadanie " + task.getName() + " pracownikowi " + name);
    }

    @Override
    public void remove(String name, String taskId) {
        if (!assignments.containsKey(name)) {
            System.out.println("Pracownik " + name + " nie ma przypisanego zadania.");
            return;
        }

        String assignedTask = assignments.get(name);
        if (!assignedTask.equals(taskId)) {
            System.out.println("Pracownik " + name + " ma przypisane inne zadanie.");
            return;
        }

        assignments.remove(name);
        System.out.println("Odepnieto zadanie " + taskId + " od pracownika " + name);
    }

    @Override
    public List<Task> get(String name) {
        List<Task> getTask = new ArrayList<>();
        for (String taskId : assignments.values()) {
            if(!assignments.containsValue(taskId)) {
                Task task = tasks.get(taskId);
                if (task != null) {
                    getTask.add(task);
                }
            }
        }
        return getTask;
    }
}
