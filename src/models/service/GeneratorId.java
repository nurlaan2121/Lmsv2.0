package models.service;

public class GeneratorId {
    public static Long  id = 0L;
    public static Long  id2 = 0L;
    public static Long  id3 = 0L;
    public static Long generatorId(){
        return ++id;
    }
    public static Long generatorIdLesson(){
        return ++id2;
    }
    public static Long generatorIdStudent(){
        return ++id3;
    }
}
