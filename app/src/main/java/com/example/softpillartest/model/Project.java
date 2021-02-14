package com.example.softpillartest.model;

import java.io.Serializable;

public class Project implements Serializable {

    public static Project project = null;

    public String client_id,client_name,compony_name,project_stage,category,project_date;

    public Project() {
    }

    public Project(String client_id, String client_name, String compony_name, String project_stage, String category, String project_date) {
        this.client_id = client_id;
        this.client_name = client_name;
        this.compony_name = compony_name;
        this.project_stage = project_stage;
        this.category = category;
        this.project_date = project_date;
    }

    public static Project getInstance() {
        if (project == null) {
            project = new Project();
        }
        return project;
    }

    public static Project getInstance(String client_id, String client_name, String compony_name, String project_stage, String category, String project_date) {
        if (project == null) {
            project = new Project(client_id, client_name, compony_name,project_stage,category,project_date);
        }
        return project;
    }

    public static Project getProject() {
        return project;
    }

    public static void setProject(Project project) {
        Project.project = project;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getCompony_name() {
        return compony_name;
    }

    public void setCompony_name(String compony_name) {
        this.compony_name = compony_name;
    }

    public String getProject_stage() {
        return project_stage;
    }

    public void setProject_stage(String project_stage) {
        this.project_stage = project_stage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProject_date() {
        return project_date;
    }

    public void setProject_date(String project_date) {
        this.project_date = project_date;
    }
}
