package models.service;

import models.Group;

import java.util.LinkedList;

public interface GroupInterface {
    LinkedList<Group> addnewGroup (Group group,LinkedList<Group> groups);
    Group getGroupByName(LinkedList<Group> groups);
    String updateGroupByName(LinkedList<Group> groups);
    void getAllGroups(LinkedList<Group> groups);
    String deleteGroupByName(String name,LinkedList<Group> groups);

}
