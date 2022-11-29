package ru.croc.task15.TimeCounting;

import java.util.ArrayList;

public class Organization{
    public String nameOfParent;
    public String name;
    public int processTime;
    public ArrayList<Organization> childDepartments;

    public Organization(int processTime, String name , String nameOfParent, ArrayList<Organization> childDepartments) {
        this.processTime = processTime;
        this.childDepartments = childDepartments;
        this.name = name;
        this.nameOfParent = nameOfParent;
    }

    public String getNameOfParent() {
        return nameOfParent;
    }

    public String getName() {
        return name;
    }

    public int getProcessTime() {
        return processTime;
    }
    public int totalProcessTime() {
        // основаня идея в том, что нам нужно найти максимальное количество часов, которое можно затратить, обрабатывая эти заявки
        // очевидно, что это и будет ответом на задачу
        // делается с помощью рекурсии
        int maxChildTime = 0;
        for (Organization child: this.childDepartments) {
            int childTime = child.totalProcessTime();
            if (childTime > maxChildTime)
                maxChildTime = childTime;
        }

        return this.processTime + maxChildTime;
    }
}
