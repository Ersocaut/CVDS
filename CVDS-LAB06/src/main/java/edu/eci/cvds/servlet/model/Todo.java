package edu.eci.cvds.servlet.model;

/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano Garzón
 * @version 9/12/2020
 */
public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;


    public Todo(){ }

    /**
     * method that return the userId
     * @return int, userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * method that set the new userId
     * @param userId, int that represent the new userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * method that return the id
     * @return int, id
     */
    public int getId() {
        return id;
    }


    /**
     * method that set the new id
     * @param id, int hat represent the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * method that return the title
     * @return String, returns the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * method that set the new title
     * @param title, String that represent the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * method that return the attribute complete
     * @return boolean, that represent if is already completed
     */
    public boolean getCompleted() {
        return completed;
    }

    /**
     * Method that set the boolean Complete
     * @param completed, boolean the new boolean Complete
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }




}


