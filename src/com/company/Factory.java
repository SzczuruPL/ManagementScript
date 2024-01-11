package com.company;

import java.util.List;

interface Factory {
    void assign(String name, String taskId);
    void remove(String name, String taskId);
    List<Task> get(String name);
}